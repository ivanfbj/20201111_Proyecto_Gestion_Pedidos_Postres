package software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiRegistrarPedido extends JFrame {

    JTextField CodigoPedido, FechaPedido, FechaEntrega, cliente, postre, LugarEntrega, ValorTotal;
    JComboBox Cliente, Postre;
    JRadioButton Tienda, Domicilio;
    ButtonGroup TiendaDomicilio;
    JButton guardarPedidoButton, añadirPostreButton, limpiarCamposButton;

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
        add(cliente = new JTextField(27));

        add(new JLabel("Postre:"));
        add(postre = new JTextField(28));

        add(new JLabel("Lugar entrega:"));
        add(LugarEntrega = new JTextField(20));

        add(new JLabel("Valor Total:"));
        add(ValorTotal = new JTextField(26));
        
                add(new JLabel("Tipo de lugar:"));
		TiendaDomicilio= new ButtonGroup();
		add(Tienda = new JRadioButton("Tienda"));
		add(Domicilio = new JRadioButton("Domicilio"));
		TiendaDomicilio.add(Tienda);
		TiendaDomicilio.add(Domicilio);

       
        setSize(400, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
