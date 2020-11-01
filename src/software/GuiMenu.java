package software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiMenu extends JFrame {

	JMenuBar barra;
	JMenu registro, informe;
	JMenuItem registrarCliente, registrarPostre, registrarPedido, cantidadDePostresXPedido, edadPromedioClienteDomicilio;

	public GuiMenu() {
		//setSize(600, 200);

		setLocationRelativeTo(null);
		FlowLayout F = new FlowLayout();
		F.setAlignment(0);
		setLayout(F);
		setTitle("Sistema de Postres la U");

		barra = new JMenuBar();
		add(barra);

		registro = new JMenu("Registrar");
		barra.add(registro);

		registrarCliente = new JMenuItem("Registrar Clientes");
		registro.add(registrarCliente);
		registrarCliente.addActionListener(new ActionRegistrarCliente());

		registrarPostre = new JMenuItem("Registrar Postres");
		registro.add(registrarPostre);
		registrarPostre.addActionListener(new ActionRegistrarPostre());

		registrarPedido = new JMenuItem("Registrar Pedidos");
		registro.add(registrarPedido);
		registrarPedido.addActionListener(new ActionRegistrarPedido());

		informe = new JMenu("Informes");
		barra.add(informe);

		cantidadDePostresXPedido = new JMenuItem("Cantidad de postres por pedido");
		informe.add(cantidadDePostresXPedido);
		edadPromedioClienteDomicilio = new JMenuItem("Edad promedio de clientes domicilio");
		informe.add(edadPromedioClienteDomicilio);
                
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	class ActionRegistrarCliente implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GuiRegistrarCliente registrarCliente = new GuiRegistrarCliente();
		}
	}

	class ActionRegistrarPostre implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GuiRegistrarPostre registrarPostre = new GuiRegistrarPostre();
		}
	}

	class ActionRegistrarPedido implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			GuiRegistrarPedido registrarPedido = new GuiRegistrarPedido();
		}
	}
        class ActioncantidadDePostresXPedido implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			GuiConsultas consultas = new GuiConsultas();
		}
	}

}
