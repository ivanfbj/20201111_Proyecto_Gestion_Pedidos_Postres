package software;

import javax.swing.*;

import daoInterfaces.DAOCliente;
import daoInterfaces.DAOPostre;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GuiRegistrarPedido extends JFrame {

	static double valorDomicilio = 5000;
	JTextField codigoPedido, fechaPedido, fechaEntrega, valorTotal;
	static JComboBox<String> cliente;
	static JComboBox<String> postre;

	JRadioButton tienda;
	static JRadioButton domicilio;
	ButtonGroup tiendaDomicilio;
	JButton guardarPedidoButton, anadirPostreButton, limpiarCamposButton, mostrarPedidosButton;

	static ArrayList<Pedido> pedidosList = new ArrayList<Pedido>();

	public GuiRegistrarPedido() {

		setTitle("Registrar Pedido");
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		add(new JLabel("Codigo del pedido:"));
		add(codigoPedido = new JTextField(20));
		codigoPedido.addFocusListener(new AccionValidarSiExisteCodigoPedidoAntesDeGuardar());

		add(new JLabel("Fecha del pedido:"));
		add(fechaPedido = new JTextField(20));

		add(new JLabel("Fecha de entrega:"));
		add(fechaEntrega = new JTextField(20));

		add(new JLabel("Cliente:"));
		cliente = new JComboBox<>();
		cliente.addItem("Sin seleccionar");

		// ESTA LÓGICA DEBE CAMBIAR YA QUE LOS CLIENTES SE GUARDAN EN LA BASE DE DATOS
//		for (int i = 0; i < GuiRegistrarCliente.cliente.size(); i++) {
//			cliente.addItem(GuiRegistrarCliente.cliente.get(i).getNombreCliente());
//		}

		try {
			for (Cliente objClienteEnGuiRegistrarPedido : DAOCliente.listaClientes()) {
				cliente.addItem(objClienteEnGuiRegistrarPedido.getNombreCliente());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		add(cliente);

		add(new JLabel("Postre:"));
		postre = new JComboBox<>();
		postre.addItem("Sin seleccionar");
		// ESTA LÓGICA DEBE CAMBIAR YA QUE LOS CLIENTES SE GUARDAN EN LA BASE DE DATOS
//		for (int i = 0; i < GuiRegistrarPostre.postres.size(); i++) {
//			postre.addItem(GuiRegistrarPostre.postres.get(i).getNombrePostre());
//		}

		try {
			for (Postre objPostreEnGuiRegistrarPedido : DAOPostre.listaPostres()) {
				postre.addItem(objPostreEnGuiRegistrarPedido.getNombrePostre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		add(postre);

		add(new JLabel("Lugar de entrega:"));
		tiendaDomicilio = new ButtonGroup();
		add(tienda = new JRadioButton("Tienda"));
		tienda.setActionCommand("Tienda");
		add(domicilio = new JRadioButton("Domicilio($" + valorDomicilio + ")"));
		domicilio.setActionCommand("Domicilio");

		tiendaDomicilio.add(tienda);
		tiendaDomicilio.add(domicilio);

		add(new JLabel("Valor Total:"));
		add(valorTotal = new JTextField(26));
		valorTotal.setEditable(false);
		valorTotal.setText("0");

		add(anadirPostreButton = new JButton("Añadir Postre"));
		anadirPostreButton.addActionListener(new AnadirPostre());

		add(limpiarCamposButton = new JButton("Limpiar Campos"));
		limpiarCamposButton.addActionListener(new LimpiarCampos());

		add(mostrarPedidosButton = new JButton("Mostrar Pedidos"));
		mostrarPedidosButton.addActionListener(new AccionMostrarPedidos());

		add(guardarPedidoButton = new JButton("Guardar Pedido"));
		guardarPedidoButton.addActionListener(new GuardarPedido());

		setSize(400, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

//Si el código del pedido no existe, si todos los campos están llenos, calcula el valor total del pedido, crea el pedido, lo añade al ArrayList de pedidos, limpia campos,habilita los campos y quita la selección. 
//(condición sino): Si el código del pedido existe, limpia campos,habilita los campos y quita la selección.
	class GuardarPedido implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (ControladorPedido.validarSiExisteCodigoPedido(codigoPedido.getText()) == false) {
				if (!codigoPedido.getText().equals("") & !fechaPedido.getText().equals("") & !fechaEntrega.getText().equals("") & cliente.getSelectedIndex() != 0
						& (tienda.isSelected() != false || domicilio.isSelected() != false) & postre.getSelectedIndex() != 0) {
					if (domicilio.isSelected() == true) {
						valorTotal.setText(String.valueOf(GuiRegistrarPostre.postres.get(postre.getSelectedIndex() - 1).getPrecio() + valorDomicilio));
					} else {
						valorTotal.setText(String.valueOf(GuiRegistrarPostre.postres.get(postre.getSelectedIndex() - 1).getPrecio()));
					}

					// ESTA LOGICA TAMBIÉN DEBE CAMBIAR YA QUE NO SE GUARDARÁ UN OBJETO DENTRO DE UN OBJETO, SINO QUE EL PEDIDO TENDRÁ EL ID DEL CLIENTE PARA LA RELACIÓN
					// DE PEDIDOXCLIENTEXPOSTRE.
					Pedido pedidoRealizado = new Pedido(codigoPedido.getText(), fechaPedido.getText(), fechaEntrega.getText(), GuiRegistrarCliente.cliente.get(cliente.getSelectedIndex() - 1),
							tiendaDomicilio.getSelection().getActionCommand(), Double.parseDouble(valorTotal.getText()), GuiRegistrarPostre.postres.get(postre.getSelectedIndex() - 1));

					pedidosList.add(pedidoRealizado);

					JOptionPane.showMessageDialog(null, "El pedido se guardó exitosamente, el valor total es de $" + valorTotal.getText(), "Pedido guardado", JOptionPane.DEFAULT_OPTION);

					codigoPedido.setEditable(true);
					fechaPedido.setEditable(true);
					fechaEntrega.setEditable(true);
					domicilio.setEnabled(true);
					tienda.setEnabled(true);
					cliente.setEnabled(true);
					cliente.setSelectedIndex(0);
					postre.setSelectedIndex(0);
					tiendaDomicilio.clearSelection();
					valorTotal.setText("0");
				} else {
					JOptionPane.showMessageDialog(null, "Verificar que todos los campos estén diligenciados", "VALIDAR INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
				}

			} else {

				if (postre.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "El pedido se guardó exitosamente, el valor total es de $" + valorTotal.getText(), "Pedido guardado", JOptionPane.DEFAULT_OPTION);
					codigoPedido.setText(null);
					codigoPedido.setEditable(true);
					fechaPedido.setEditable(true);
					fechaPedido.setText(null);
					fechaEntrega.setEditable(true);
					fechaEntrega.setText(null);
					cliente.setEnabled(true);
					cliente.setSelectedIndex(0);
					postre.setSelectedIndex(0);
					domicilio.setEnabled(true);
					tienda.setEnabled(true);
					tiendaDomicilio.clearSelection();
					valorTotal.setText("0");
				} else {
					JOptionPane.showMessageDialog(null, "Si desea guardar el pedido, NO debe de haber ningún postre seleccionado", "VALIDAR POSTRE SELECCIONADO", JOptionPane.WARNING_MESSAGE);
				}

			}
		}
	}

//Si la lista de pedidos está vacía o el pedido no existe, si todos los campos están llenos, calcula el valor total del pedido, crea el pedido, lo añade al ArrayList de pedidos, desahabilita los campos y solo deja el JcomboBox de postres para seguir añadiendo.
//Condición (Sino) Si hay algún campo vacío o sin seleccionar genera un mensaje para cverificar la información.
//Condición (Sino) Si el pedidio existe, coge el ultimo pedido y le añade el postre seleccionado, actualizar el valor total del pedido, y actualizar el valor total en la ventana.

	class AnadirPostre implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (pedidosList.isEmpty() || ControladorPedido.validarSiExisteCodigoPedido(codigoPedido.getText()) == false) {

				if (!codigoPedido.getText().equals("") & !fechaPedido.getText().equals("") & !fechaEntrega.getText().equals("") & cliente.getSelectedIndex() != 0
						& (tienda.isSelected() != false || domicilio.isSelected() != false) & postre.getSelectedIndex() != 0) {

					if (domicilio.isSelected() == true) {

						valorTotal.setText(String.valueOf(GuiRegistrarPostre.postres.get(postre.getSelectedIndex() - 1).getPrecio() + valorDomicilio));
					} else {
						valorTotal.setText(String.valueOf(GuiRegistrarPostre.postres.get(postre.getSelectedIndex() - 1).getPrecio()));
					}

					Pedido pedidoRealizado = new Pedido(codigoPedido.getText(), fechaPedido.getText(), fechaEntrega.getText(), GuiRegistrarCliente.cliente.get(cliente.getSelectedIndex() - 1),
							tiendaDomicilio.getSelection().getActionCommand(), Double.parseDouble(valorTotal.getText()), GuiRegistrarPostre.postres.get(postre.getSelectedIndex() - 1));

					pedidosList.add(pedidoRealizado);

					JOptionPane.showMessageDialog(null, "Se a creado el pedido ahora podrá seguir añadiendo los postres que necesite a dicho pedido", "Pedido guardado", JOptionPane.DEFAULT_OPTION);

					codigoPedido.setEditable(false);
					fechaPedido.setEditable(false);
					fechaEntrega.setEditable(false);
					domicilio.setEnabled(false);
					tienda.setEnabled(false);
					cliente.setEnabled(false);
					postre.setSelectedIndex(0);

				} else {
					JOptionPane.showMessageDialog(null, "Verificar que todos los campos estén diligenciados", "VALIDAR INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
				}

			} else {

				pedidosList.get((pedidosList.size() - 1)).postresDelPedidoList.add(GuiRegistrarPostre.postres.get(postre.getSelectedIndex() - 1));

				valorTotal.setText(String.valueOf(ControladorPedido.calcularValorTotalDelPedido()));

				pedidosList.get(pedidosList.size() - 1).setValorTotal(Double.parseDouble(valorTotal.getText()));

				JOptionPane.showMessageDialog(null, "El postre seleccionado se añade al pedido con código " + pedidosList.get((pedidosList.size() - 1)).getCodigoPedido());
			}
		}
	}

	class LimpiarCampos implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			codigoPedido.setText(null);
			fechaPedido.setText(null);
			fechaEntrega.setText(null);
			valorTotal.setText(null);
			tiendaDomicilio.clearSelection();
			postre.setSelectedIndex(0);
			cliente.setSelectedIndex(0);
			codigoPedido.setEditable(true);
			fechaPedido.setEditable(true);
			fechaEntrega.setEditable(true);
			domicilio.setEnabled(true);
			tienda.setEnabled(true);
			cliente.setEnabled(true);
			valorTotal.setText("0");
			
		}
	}

	class AccionMostrarPedidos implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (pedidosList.isEmpty() == false) {
				String listadoDePedidos = "";
				for (int i = 0; i < pedidosList.size(); i++) {
					listadoDePedidos += pedidosList.get(i).toString() + "\n";
				}
				JOptionPane.showMessageDialog(null, listadoDePedidos);
			} else {
				JOptionPane.showMessageDialog(null, "Actualmente no existen pedidos registrados", "Sin pedidos registrados", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

//En caso de que el usuario ingrese un código de pedido que ya existe se validará antes de guardar el pedido o añadir el postre
	class AccionValidarSiExisteCodigoPedidoAntesDeGuardar implements FocusListener {
		public void focusLost(FocusEvent e) {

			if (codigoPedido.isEditable() == true) {
				if (ControladorPedido.validarSiExisteCodigoPedido(codigoPedido.getText()) == true) {
					JOptionPane.showMessageDialog(null, "EL PEDIDO QUE USTED INGRESO YA EXISTE, POR FAVOR INGRESAR UN CÓDIGO DIFERENTE", "CÓDIGO PEDIDO REPETIDO", JOptionPane.ERROR_MESSAGE);
					codigoPedido.setText(null);
				}
			}
		}

		public void focusGained(FocusEvent e) {
		}
	}
}
