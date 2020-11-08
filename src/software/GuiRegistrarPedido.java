package software;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GuiRegistrarPedido extends JFrame {

	double valorDomicilio = 5000;
	JTextField codigoPedido, fechaPedido, fechaEntrega, valorTotal;
	static JComboBox<String> cliente;
	static JComboBox<String> postre;

	JRadioButton tienda, domicilio;
	ButtonGroup tiendaDomicilio;
	JButton guardarPedidoButton, anadirPostreButton, limpiarCamposButton, mostrarPedidosButton;

	static ArrayList<Pedido> pedidosList = new ArrayList<Pedido>();

	/* Lineas temporales */
	int p = 1;
	int f1 = 1;
	int f2 = 15;
	// int tt = 1000;

	public GuiRegistrarPedido() {

		setTitle("Registrar Pedido - IVAN");
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		add(new JLabel("Codigo del pedido:"));
		add(codigoPedido = new JTextField(20));
		codigoPedido.addFocusListener(new AccionPrueba());

		add(new JLabel("Fecha del pedido:"));
		add(fechaPedido = new JTextField(20));

		add(new JLabel("Fecha de entrega:"));
		add(fechaEntrega = new JTextField(20));

		add(new JLabel("Cliente:"));
		cliente = new JComboBox<>();
		cliente.addItem("Sin seleccionar");
		for (int i = 0; i < GuiRegistrarCliente.cliente.size(); i++) {
			cliente.addItem(GuiRegistrarCliente.cliente.get(i).getNombreCliente());
		}
		add(cliente);

		add(new JLabel("Postre:"));
		postre = new JComboBox<>();
		postre.addItem("Sin seleccionar");
		for (int i = 0; i < GuiRegistrarPostre.postres.size(); i++) {
			postre.addItem(GuiRegistrarPostre.postres.get(i).getNombrePostre());
		}
		add(postre);

//		add(new JLabel("Lugar entrega:"));
//		// add(LugarEntrega = new JTextField(20));
//		lugarEntrega = new JComboBox<String>();
//		lugarEntrega.addItem("Sin seleccionar");
//		lugarEntrega.addItem("tienda");
//		lugarEntrega.addItem("Domicilio");
//		add(lugarEntrega);

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

		/* Lineas temporales */
		codigoPedido.setText("Pedido_" + p);
		fechaEntrega.setText("Dic " + f1);
		fechaPedido.setText("Nov " + f2);
		// tienda.setSelected(true);
		// valorTotal.setText(String.valueOf(tt));
		/* Fin lineas temporales */

		setSize(400, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	class GuardarPedido implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (validarSiExisteCodigoPedido(codigoPedido.getText()) == false) {

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

					// pedidosList.get(pedidosList.size() - 1).AgregarPostreAlPedido(GuiRegistrarPostre.postres.get(postre.getSelectedIndex() - 1));

					JOptionPane.showMessageDialog(null, "El pedido se guardó exitosamente, el valor total es de $" + valorTotal.getText(), "VENTANA IVAN MIS MENSAJES", JOptionPane.DEFAULT_OPTION);

					/* Lineas temporales */
					p++;
					f1++;
					f2++;
					// tt += 1000;

					codigoPedido.setText("Pedido_" + p);
					fechaEntrega.setText("Dic " + f1);
					fechaPedido.setText("Nov " + f2);
					tienda.setSelected(true);
					// valorTotal.setText(String.valueOf(tt));
					/* Fin lineas temporales */

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
					JOptionPane.showMessageDialog(null, "Verificar que todos los campos esten diligenciados", "VENTANA IVAN MIS MENSAJES", JOptionPane.INFORMATION_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "El pedido se guardó exitosamente", "VENTANA IVAN MIS MENSAJES", JOptionPane.DEFAULT_OPTION);
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
			}
		}
	}

	class AnadirPostre implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// PostreHorneado postreTiramisu = new PostreHorneado("Tiramizú", 300, "2 mayo", 5000, true);

			// pedidosList.get(0).postresDelPedidoList.add(postreTiramisu);

			// JOptionPane.showMessageDialog(null, "el postre se a agregado correctamente ");

			// JOptionPane.showMessageDialog(null, "getcodigoPedido del pedido 0 : " + pedidosList.get(3).getCodigoPedido());
			// JOptionPane.showMessageDialog(null, "probando el indexOf : " + pedidosList.get(3).getCodigoPedido().indexOf("Pedido_2"));

			// Inicio repetir guardar pedido
			if (pedidosList.isEmpty() || validarSiExisteCodigoPedido(codigoPedido.getText()) == false) {

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

					// pedidosList.get(pedidosList.size() - 1).AgregarPostreAlPedido(GuiRegistrarPostre.postres.get(postre.getSelectedIndex() - 1));

					JOptionPane.showMessageDialog(null, "Se a creado el pedido ahora podrá añadir los postres que necesite a dicho pedido");

					codigoPedido.setEditable(false);
					fechaPedido.setEditable(false);
					fechaEntrega.setEditable(false);
					domicilio.setEnabled(false);
					tienda.setEnabled(false);
					cliente.setEnabled(false);
					postre.setSelectedIndex(0);

					// Fin repetir guardar pedido

				} else {
					JOptionPane.showMessageDialog(null, "Verificar que todos los campos esten diligenciados", "VENTANA IVAN MIS MENSAJES", JOptionPane.INFORMATION_MESSAGE);
				}

			} else {

				pedidosList.get((pedidosList.size() - 1)).postresDelPedidoList.add(GuiRegistrarPostre.postres.get(postre.getSelectedIndex() - 1));

				valorTotal.setText(String.valueOf(calcularValorTotalDelPedido()));
				// pedidosList.get(pedidosList.size()-1);

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
			// LugarEntrega.setText(null);
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
			JOptionPane.showMessageDialog(null, "Clic en el boton Limpiar campos");

		}
	}

	class AccionMostrarPedidos implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String listadoDePedidos = "";
			for (int i = 0; i < pedidosList.size(); i++) {
				listadoDePedidos += pedidosList.get(i).toString() + "\n";
			}
			JOptionPane.showMessageDialog(null, listadoDePedidos);
		}
	}

	class AccionPrueba implements FocusListener {

		@Override
		public void focusLost(FocusEvent e) {

			if (codigoPedido.isEditable() == true) {

				if (validarSiExisteCodigoPedido(codigoPedido.getText()) == true) {

					JOptionPane.showMessageDialog(null, "EL PEDIDO QUE USTED INGRESO YA EXISTE, POR FAVOR INGRESAR UN CÓDIGO DIFERENTE");
					codigoPedido.setText(null);
				}
			}
		}

		@Override
		public void focusGained(FocusEvent e) {
		}
	}

	public static boolean validarSiExisteCodigoPedido(String codigoPedidoActual) {
		boolean existePedido = false;

		for (int i = 0; i < pedidosList.size(); i++) {
			if (pedidosList.get(i).getCodigoPedido().equals(codigoPedidoActual)) {
				existePedido = true;
			}
		}

		return existePedido;
	}

	public double calcularValorTotalDelPedido() {
		double calcularValorTotal = 0;

		for (int i = 0; i < pedidosList.get(pedidosList.size() - 1).postresDelPedidoList.size(); i++) {
			calcularValorTotal += pedidosList.get(pedidosList.size() - 1).postresDelPedidoList.get(i).getPrecio();
		}
		if (domicilio.isSelected() == true) {
			calcularValorTotal += valorDomicilio;
		}
		return calcularValorTotal;
	}

	public static int cantidadDePostresXPedido(String codigoPedidoAConsultar) {
		int totalPostresXPedido = 0;

		for (int i = 0; i < pedidosList.size(); i++) {
			if (pedidosList.get(i).getCodigoPedido().equals(codigoPedidoAConsultar)) {
				totalPostresXPedido = pedidosList.get(i).postresDelPedidoList.size();
			}
		}
		return totalPostresXPedido;
	}

	public static double edadPromedioClientesDomicilio() {
		double edadPromedio = 0;
		double sumaEdad = 0;
		double totalPedidosADomicilio = 0;

		for (int i = 0; i < pedidosList.size(); i++) {
			if (pedidosList.get(i).getLugarDeEntrega().equals("Domicilio")) {
				totalPedidosADomicilio++;
				sumaEdad += pedidosList.get(i).getCliente().getEdad();
			}

		}
		return edadPromedio = sumaEdad / totalPedidosADomicilio;

	}
}
