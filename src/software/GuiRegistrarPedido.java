package software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiRegistrarPedido extends JFrame {

	JTextField codigoPedido, fechaPedido, fechaEntrega, valorTotal;
	JComboBox<String> cliente, postre, lugarEntrega;

	JRadioButton Tienda, Domicilio;
	ButtonGroup TiendaDomicilio;
	JButton GuardarPedidoButton, AnadirPostreButton, LimpiarCamposButton;

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
		for (int i = 0; i < GuiRegistrarCliente.cliente.size(); i++) {
			cliente.addItem(GuiRegistrarCliente.cliente.get(i).getNombreCliente());
		}
		add(cliente);

		add(new JLabel("Postre:"));
		postre = new JComboBox<>();
		for (int i = 0; i < GuiRegistrarPostre.postres.size(); i++) {
			postre.addItem(String.valueOf(GuiRegistrarPostre.postres.get(i).getNombrePostre()));
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
		add(Domicilio = new JRadioButton("Domicilio"));
		TiendaDomicilio.add(Tienda);
		TiendaDomicilio.add(Domicilio);

		add(new JLabel("Valor Total:"));
		add(valorTotal = new JTextField(26));

		add(GuardarPedidoButton = new JButton("Guardar Pedido"));
		// GuardarPedidoButton.addActionListener(new GuardarPedido());

		add(AnadirPostreButton = new JButton("Anadir Postre"));
		// AnadirPostreButton.addActionListener(new AnadirPostre());

		add(LimpiarCamposButton = new JButton("Limpiar Campos"));
		LimpiarCamposButton.addActionListener(new LimpiarCampos());

		setSize(400, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	class GuardarPedido implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// pedidos.registrarPedido(codigoPedido.getText(), fechaPedido.getText(), fechaEntrega.getText(),
			// Cliente, LugarEntrega.getText(), Double.parseDouble(valorTotal.getText()), Integer.parseInt(postre.toString()));//se presentan problemas para
			// llamar el contenido del atributo cliente

			JOptionPane.showMessageDialog(null, "los datos fueron almacenados con exito");

			codigoPedido.setText(null);
			fechaPedido.setText(null);
			fechaEntrega.setText(null);
			// LugarEntrega.setText(null);
			valorTotal.setText(null);
			TiendaDomicilio.clearSelection();
			postre.setSelectedIndex(0);
			cliente.setSelectedIndex(0);
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

}
