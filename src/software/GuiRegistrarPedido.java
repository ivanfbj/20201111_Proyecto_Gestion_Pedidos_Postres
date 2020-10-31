package software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GuiRegistrarPedido extends JFrame {

	JTextField codigoPedido, fechaPedido, fechaEntrega, valorTotal;
	static JComboBox<String> cliente;
	static JComboBox<String> postre;

	JRadioButton Tienda, Domicilio;
	ButtonGroup TiendaDomicilio;
	JButton GuardarPedidoButton, AnadirPostreButton, LimpiarCamposButton, mostrarPedidosButton;

	static ArrayList<Pedido> pedidosList = new ArrayList<Pedido>();

	public GuiRegistrarPedido() {

		setTitle("Registrar Pedido - IVAN");
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		add(new JLabel("Codigo del pedido:"));
		add(codigoPedido = new JTextField(20));

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
//		lugarEntrega.addItem("Tienda");
//		lugarEntrega.addItem("Domicilio");
//		add(lugarEntrega);

		add(new JLabel("Lugar de entrega:"));
		TiendaDomicilio = new ButtonGroup();
		add(Tienda = new JRadioButton("Tienda"));
		Tienda.setActionCommand("Tienda");
		add(Domicilio = new JRadioButton("Domicilio"));
		Domicilio.setActionCommand("Domicilio");

		TiendaDomicilio.add(Tienda);
		TiendaDomicilio.add(Domicilio);

		add(new JLabel("Valor Total:"));
		add(valorTotal = new JTextField(26));

		add(AnadirPostreButton = new JButton("Anadir Postre"));
		// AnadirPostreButton.addActionListener(new AnadirPostre());

		add(LimpiarCamposButton = new JButton("Limpiar Campos"));
		LimpiarCamposButton.addActionListener(new LimpiarCampos());

		add(mostrarPedidosButton = new JButton("Mostrar Pedidos"));
		mostrarPedidosButton.addActionListener(new AccionMostrarPedidos());

		add(GuardarPedidoButton = new JButton("Guardar Pedido"));
		GuardarPedidoButton.addActionListener(new GuardarPedido());

		setSize(400, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	class GuardarPedido implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// Cliente clienteDosPedido = new Cliente("Luisa", "Cra 50", 2702345, "Femenino", 28);

			Pedido pedidoRealizado = new Pedido(codigoPedido.getText(), fechaPedido.getText(), fechaEntrega.getText(), GuiRegistrarCliente.cliente.get(cliente.getSelectedIndex() - 1),
					TiendaDomicilio.getSelection().getActionCommand(), Double.parseDouble(valorTotal.getText()),GuiRegistrarPostre.postres.get(postre.getSelectedIndex() - 1));

			pedidosList.add(pedidoRealizado);

			//pedidosList.get(pedidosList.size() - 1).AgregarPostreAlPedido(GuiRegistrarPostre.postres.get(postre.getSelectedIndex() - 1));

						
			JOptionPane.showMessageDialog(null, pedidosList, "VENTANA IVAN MIS MENSAJES", JOptionPane.DEFAULT_OPTION);
			/*
			 * codigoPedido.setText(null); fechaPedido.setText(null); fechaEntrega.setText(null); // LugarEntrega.setText(null); valorTotal.setText(null);
			 * TiendaDomicilio.clearSelection(); postre.setSelectedIndex(0); cliente.setSelectedIndex(0);
			 */
		}

	}

	class AnadirPostre implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			postre.addItem(String.valueOf(postre.getAccessibleContext()));
			JOptionPane.showMessageDialog(null, "el postre se a agregado correctamente ");
		}
	}

	class LimpiarCampos implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			codigoPedido.setText(null);
			fechaPedido.setText(null);
			fechaEntrega.setText(null);
			// LugarEntrega.setText(null);
			valorTotal.setText(null);
			TiendaDomicilio.clearSelection();
			postre.setSelectedIndex(0);
			cliente.setSelectedIndex(0);
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

}
