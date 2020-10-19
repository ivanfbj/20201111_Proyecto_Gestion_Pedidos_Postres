package software;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import software.GuiRegistrarCliente.Guardar;
import software.GuiRegistrarCliente.LimpiarCampos;

public class GuiRegistrarPostre extends JFrame {

	JTextField nombreDelPostre, cantidadDeCalorias, fechaVencimiento, precio, temperaturaMantenimiento, tiempoMaximoSinRefrigeracionHoras;
	ButtonGroup hojaldreRefrigeradoButtonGroup;
	JRadioButton esHojaldrado, esRefrigerado;
	JButton guardarButton, limpiarCamposButton;

	public GuiRegistrarPostre() {
		setTitle("Registrar Postre");
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		// setLayout(null);
		// pack();

		add(new JLabel("Nombre del postre:"));
		add(nombreDelPostre = new JTextField(20));

		add(new JLabel("Cantidad de calorias:"));
		add(cantidadDeCalorias = new JTextField(20));

		add(new JLabel("Fecha de vencimiento:"));
		add(fechaVencimiento = new JTextField(20));

		add(new JLabel("Precio:"));
		add(precio = new JTextField(7));

		// add(new JLabel("Tipo de postre:"));
		hojaldreRefrigeradoButtonGroup = new ButtonGroup();
		add(esHojaldrado = new JRadioButton("Hojaldrado"));
		add(esRefrigerado = new JRadioButton("Refrigerado"));
		hojaldreRefrigeradoButtonGroup.add(esHojaldrado);
		hojaldreRefrigeradoButtonGroup.add(esRefrigerado);

		add(new JLabel("Temperatura de mantenimiento:"));
		add(temperaturaMantenimiento = new JTextField(10));

		add(new JLabel("Tiempo máximo sin refrigeración:"));
		add(tiempoMaximoSinRefrigeracionHoras = new JTextField(9));

		add(guardarButton = new JButton("Guardar"));
		guardarButton.addActionListener(new Guardar());

		add(limpiarCamposButton = new JButton("Limpiar campos"));
		limpiarCamposButton.addActionListener(new LimpiarCampos());

		setSize(400, 500);
		setResizable(false);// Establecemos si la ventana puede cambiar de tamaño o no
		setLocationRelativeTo(null);
		setVisible(true);

	}

	class Guardar implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			JOptionPane.showMessageDialog(null, "Clic en el botón guardar");

		}
	}

	class LimpiarCampos implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			nombreDelPostre.setText(null);
			cantidadDeCalorias.setText(null);
			fechaVencimiento.setText(null);
			precio.setText(null);
			temperaturaMantenimiento.setText(null);
			tiempoMaximoSinRefrigeracionHoras.setText(null);
			hojaldreRefrigeradoButtonGroup.clearSelection();

			JOptionPane.showMessageDialog(null, "Clic en el botón Limpiar campos");

		}
	}

}
