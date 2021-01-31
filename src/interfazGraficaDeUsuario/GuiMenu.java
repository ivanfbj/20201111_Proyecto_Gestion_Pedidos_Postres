package interfazGraficaDeUsuario;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GuiMenu extends JFrame {

	JMenuBar barra;
	JMenu registro, informe;
	JMenuItem registrarCliente, registrarPostre, registrarPedido, detalleDeInforme;

	public GuiMenu() {

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
		informe.addActionListener(new ActionInformes());

		detalleDeInforme = new JMenuItem("Informe detallado");
		informe.add(detalleDeInforme);
		detalleDeInforme.addActionListener(new ActionInformes());

		 setSize(400, 200);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(400, 200));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	class ActionRegistrarCliente implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new GuiRegistrarCliente();
		}
	}

	class ActionRegistrarPostre implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new GuiRegistrarPostre();
		}
	}

	class ActionRegistrarPedido implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new GuiRegistrarPedido();
		}
	}

	class ActionInformes implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new GuiInformes();
		}
	}

}
