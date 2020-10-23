package software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiRegistrarPedido extends JFrame {

	JTextField CodigoPedido, FechaPedido, FechaEntrega, LugarEntrega, ValorTotal;
	JComboBox Cliente, Postre;
	JRadioButton Tienda, Domicilio;
	ButtonGroup TiendaDomicilio;
	JButton GuardarPedidoButton, AnadirPostreButton, LimpiarCamposButton;
        
        ControladorPedido pedidos= new ControladorPedido(10);

	public GuiRegistrarPedido() {

		setTitle("Registrar Pedido");
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		add(new JLabel("Codigo del pedido:"));
		add(CodigoPedido = new JTextField(20));

		add(new JLabel("Fecha del pedido:"));
		add(FechaPedido = new JTextField(20));

		add(new JLabel("Fecha de entrega:"));
		add(FechaEntrega = new JTextField(20));

		add(new JLabel("Cliente:"));
		Cliente = new JComboBox();
		Cliente.addItem("Cliente 1");
		Cliente.addItem("Cliente 2");
		add(Cliente);

		add(new JLabel("Postre:"));
		Postre = new JComboBox();
		Postre.addItem("Postre 1");
		Postre.addItem("Postre 2");
		add(Postre);

		add(new JLabel("Lugar entrega:"));
		add(LugarEntrega = new JTextField(20));

		add(new JLabel("Valor Total:"));
		add(ValorTotal = new JTextField(26));

		add(new JLabel("Tipo de lugar:"));
		TiendaDomicilio = new ButtonGroup();
		add(Tienda = new JRadioButton("Tienda"));
		add(Domicilio = new JRadioButton("Domicilio"));
		TiendaDomicilio.add(Tienda);
		TiendaDomicilio.add(Domicilio);

		add(GuardarPedidoButton = new JButton("Guardar Pedido"));
		// GuardarPedidoButton.addActionListener(new GuardarPedido());

		add(AnadirPostreButton = new JButton("Anadir Postre"));
		// AnadirPostreButton.addActionListener(new AnadirPostre());

		add(LimpiarCamposButton = new JButton("Limpiar Campos"));
		// LimpiarCamposButton.addActionListener(new LimpiarCampos());

		setSize(400, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		

	}
        class GuardarPedido implements ActionListener{
            public void actionPerformed(ActionEvent e){
                pedidos.registrarPedido(CodigoPedido.getText(), FechaPedido.getText(), FechaEntrega.getText(),
            "cliente",  LugarEntrega.getText(), Double.parseDouble(ValorTotal.getText()),Integer.parseInt(Postre.toString()))
                        ;//se presentan problemas para llamar el contenido del atributo cliente
                JOptionPane.showMessageDialog(null, "Clic en el boton guardar");
                
            }
        }
}
