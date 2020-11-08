package software;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GuiInformes extends JFrame {

	// JTextField totalClientes, totalClientesDomicilio, edadPromedioClientes, edadPromedioClientesDomicilio;
	// JButton CalcularPromedio;
	JTextField codigoPedidoTextField;
	JLabel cantidadPostresXPedidoLabel, codigoPedidoLabel, porcentajePostresRefrigeradosLabel;
	JButton consultarCantidadPostresXPedidoButton, consultarPoscentajePostresRefrigeradosButton, consultarEdadPromedioClientesDomicilio;

	public GuiInformes() {
		setTitle("Informe detallado");
		setLayout(null);
		// setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		add(cantidadPostresXPedidoLabel = new JLabel("Cantidad de postres por pedido: ")).setBounds(50, 10, 300, 30);
		cantidadPostresXPedidoLabel.setFont(new Font("arial", Font.PLAIN, 20));

		add(codigoPedidoLabel = new JLabel("Código del pedido:")).setBounds(30, 40, 200, 30);
		codigoPedidoLabel.setFont(new Font("arial", Font.PLAIN, 15));
		add(codigoPedidoTextField = new JTextField()).setBounds(160, 45, 100, 20);
		add(consultarCantidadPostresXPedidoButton = new JButton("Consultar")).setBounds(270, 45, 90, 20);
		consultarCantidadPostresXPedidoButton.addActionListener(new AccionConsultarPostreXPedido());

		add(porcentajePostresRefrigeradosLabel = new JLabel("Porcentaje de postres refrigerados: ")).setBounds(30, 80, 350, 30);
		porcentajePostresRefrigeradosLabel.setFont(new Font("arial", Font.PLAIN, 20));

		add(consultarPoscentajePostresRefrigeradosButton = new JButton("Consultar")).setBounds(150, 110, 90, 30);
		consultarPoscentajePostresRefrigeradosButton.addActionListener(new AccionConsultarPorcentajePostresRefrigerados());

		add(porcentajePostresRefrigeradosLabel = new JLabel("<html>Edad promedio de clientes:<br>(Pedidos a Domicilio) <html>")).setBounds(60, 150, 350, 45);
		porcentajePostresRefrigeradosLabel.setFont(new Font("arial", Font.PLAIN, 20));
		add(consultarEdadPromedioClientesDomicilio = new JButton("Consultar")).setBounds(150, 200, 90, 30);
		;
		consultarEdadPromedioClientesDomicilio.addActionListener(new AccionConsultarEdadPromedioClientesDomicilio());

//		totalClientes = new JTextField(20);
//		totalClientes.setLocation(100, 100);
//		add(totalClientes);
//
//		add(new JLabel("Total clientes domicilio:"));
//		add(totalClientesDomicilio = new JTextField(20));
//
//		add(new JLabel("Edad promedio clientes:"));
//		add(edadPromedioClientes = new JTextField(20));
//
//		add(new JLabel("Edad promedio clientes domicilio:"));
//		add(edadPromedioClientesDomicilio = new JTextField(10));
//
//		add(CalcularPromedio = new JButton("Calcular promedio"));
		// CalcularPromedio.addActionListener(new CalcularPromedio());
		// se crea el boton para calcular la edad promedio del total de ambos clientes.

		setSize(400, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	class AccionConsultarPostreXPedido implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (GuiRegistrarPedido.validarSiExisteCodigoPedido(codigoPedidoTextField.getText()) == true) {
				JOptionPane.showMessageDialog(null, "El pedido tiene en total: " + GuiRegistrarPedido.cantidadDePostresXPedido(codigoPedidoTextField.getText()) + " postre(s)");
			} else {
				JOptionPane.showMessageDialog(null, "El pedido consultado no existe, por favor verificar");
			}
		}
	}

	class AccionConsultarPorcentajePostresRefrigerados implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "El porcentaje de los postres refrigerados almacenados es de " + GuiRegistrarPostre.PorcentajePostresRefrigerado() + "%");
		}
	}

	class AccionConsultarEdadPromedioClientesDomicilio implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "La edad promedio de los clientes que realizan pedidios a domicilio es " + GuiRegistrarPedido.edadPromedioClientesDomicilio());
		}
	}
}
