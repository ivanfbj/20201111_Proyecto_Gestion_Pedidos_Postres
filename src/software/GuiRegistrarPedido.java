package software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GuiRegistrarPedido extends JFrame {

    JTextField CodigoPedido, FechaPedido, FechaEntrega, LugarEntrega, ValorTotal;
    JComboBox<String> Cliente, Postre;

    JRadioButton Tienda, Domicilio;
    ButtonGroup TiendaDomicilio;
    JButton GuardarPedidoButton, AnadirPostreButton, LimpiarCamposButton,mostrarPedidosButton;

    static ArrayList<Pedido> pedido = new ArrayList<Pedido>();

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
        Cliente = new JComboBox<String>();
        for (int i = 0; i < GuiRegistrarCliente.cliente.size(); i++) {
            Cliente.addItem(GuiRegistrarCliente.cliente.get(i).getNombreCliente());
        }

        add(Cliente);

        add(new JLabel("Postre:"));
        Postre = new JComboBox<String>();
        for (int i = 0; i < GuiRegistrarPostre.postres.size(); i++) {
            Postre.addItem(String.valueOf(GuiRegistrarPostre.postres.get(i).getNombrePostre()));
        }
        add(Postre);

        add(new JLabel("Lugar entrega:"));
        add(LugarEntrega = new JTextField(20));

        add(new JLabel("Valor Total:"));
        ValorTotal.setEditable(false);
        add(ValorTotal = new JTextField(26));

        add(new JLabel("Tipo de lugar:"));
        TiendaDomicilio = new ButtonGroup();
        add(Tienda = new JRadioButton("Tienda"));
        add(Domicilio = new JRadioButton("Domicilio"));
        TiendaDomicilio.add(Tienda);
        TiendaDomicilio.add(Domicilio);

        add(GuardarPedidoButton = new JButton("Guardar Pedido"));
        GuardarPedidoButton.addActionListener(new GuardarPedido());

        add(AnadirPostreButton = new JButton("Anadir Postre"));
        AnadirPostreButton.addActionListener(new AnadirPostre());

        add(mostrarPedidosButton = new JButton("Mostrar Pedidos"));
        mostrarPedidosButton.addActionListener(new AccionMostrarPedidos());

        add(LimpiarCamposButton = new JButton("Limpiar Campos"));
        LimpiarCamposButton.addActionListener(new LimpiarCampos());

        setSize(370, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    class GuardarPedido implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Pedido pedidos = new Pedido(CodigoPedido.getText(), FechaPedido.getText(), FechaEntrega.getText(), GuiRegistrarCliente.cliente.get(Cliente.getSelectedIndex()), LugarEntrega.getText(), Double.parseDouble(ValorTotal.getText()),GuiRegistrarPostre.postres.get(Postre.getSelectedIndex()));

            pedido.add(pedidos);

            JOptionPane.showMessageDialog(null, "los datos fueron almacenados con exito");

            CodigoPedido.setText(null);
            FechaPedido.setText(null);
            FechaEntrega.setText(null);
            LugarEntrega.setText(null);
            ValorTotal.setText(null);
            TiendaDomicilio.clearSelection();
            Postre.setSelectedIndex(0);
            Cliente.setSelectedIndex(0);
        }

    }

    class AnadirPostre implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Postre.addItem(String.valueOf(Postre.getAccessibleContext()));
            JOptionPane.showMessageDialog(null, "el postre se a agregado correctamente ");
        }
    }

    class LimpiarCampos implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            CodigoPedido.setText(null);
            FechaPedido.setText(null);
            FechaEntrega.setText(null);
            LugarEntrega.setText(null);
            ValorTotal.setText(null);
            TiendaDomicilio.clearSelection();
            Postre.setSelectedIndex(0);
            Cliente.setSelectedIndex(0);
            JOptionPane.showMessageDialog(null, "Clic en el boton Limpiar campos");

        }
    }
    
    class AccionMostrarPedidos implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            
            String listadoDePedidos="";
            
            for(int i=0;i<pedido.size();i++){
                listadoDePedidos+=pedido.get(i).toString()+"\n";
            }        
            
             JOptionPane.showMessageDialog(null, listadoDePedidos);
        }

    }

}
