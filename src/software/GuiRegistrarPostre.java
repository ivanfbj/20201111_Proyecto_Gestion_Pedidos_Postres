package software;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;

public class GuiRegistrarPostre extends JFrame {

	JTextField nombreDelPostre, cantidadDeCalorias, fechaVencimiento, precio, temperaturaMantenimiento, tiempoMaximoSinRefrigeracionHoras;
	ButtonGroup horneadoRefrigeradoButtonGroup;
	JRadioButton esHorneado, esRefrigerado, esHojaldrado;
	JButton guardarButton, limpiarCamposButton, mostrarPostresButton;
	JLabel jLabeltemperaturaMantenimiento, jLabeltiempoMaximoSinRefrigeracionHoras;

	static ArrayList<Postre> postres = new ArrayList<Postre>();

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
		horneadoRefrigeradoButtonGroup = new ButtonGroup();
		add(esHorneado = new JRadioButton("Horneado"));
		esHorneado.addActionListener(new AccionRadioButtonHorneado());

		add(esRefrigerado = new JRadioButton("Refrigerado"));
		esRefrigerado.addActionListener(new AccionRadioButtonRefrigerado());

		horneadoRefrigeradoButtonGroup.add(esHorneado);
		horneadoRefrigeradoButtonGroup.add(esRefrigerado);

		add(esHojaldrado = new JRadioButton("Hojaldrado"));
		esHojaldrado.setVisible(false);

		add(jLabeltemperaturaMantenimiento = new JLabel("Temperatura de mantenimiento:")).setVisible(false);

		add(temperaturaMantenimiento = new JTextField(10));
		temperaturaMantenimiento.setVisible(false);

		add(jLabeltiempoMaximoSinRefrigeracionHoras = new JLabel("Tiempo maximo sin refrigeracion:")).setVisible(false);
		add(tiempoMaximoSinRefrigeracionHoras = new JTextField(9));
		tiempoMaximoSinRefrigeracionHoras.setVisible(false);

		add(guardarButton = new JButton("Guardar"));
		guardarButton.addActionListener(new Guardar());

		add(limpiarCamposButton = new JButton("Limpiar campos"));
		limpiarCamposButton.addActionListener(new LimpiarCampos());

		add(mostrarPostresButton = new JButton("Mostrar postres registrados"));
		mostrarPostresButton.addActionListener(new AccionMostrarRegistros());

		setSize(400, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	class Guardar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (nombreDelPostre.getText().equals("") || cantidadDeCalorias.getText().equals("") || fechaVencimiento.getText().equals("") || precio.getText().equals("")
					|| temperaturaMantenimiento.getText().equals("") || tiempoMaximoSinRefrigeracionHoras.getText().equals("")
					|| (esHorneado.isSelected() == false & esRefrigerado.isSelected() == false)) {

				JOptionPane.showMessageDialog(null, "Por favor verificar que todos los campos esten diligenciados", "FALTA INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

			} else {

				Postre postreGuardado = new Postre(nombreDelPostre.getText(), Double.parseDouble(cantidadDeCalorias.getText()), fechaVencimiento.getText(), Double.parseDouble(precio.getText()));
				postres.add(postreGuardado);
				// Double.parseDouble(temperaturaMantenimiento.getText()), Double.parseDouble(tiempoMaximoSinRefrigeracionHoras.getText()), esHorneado.isSelected()
				JOptionPane.showMessageDialog(null, "El postre fue registrado exitosamente.");

				nombreDelPostre.setText(null);
				cantidadDeCalorias.setText(null);
				fechaVencimiento.setText(null);
				precio.setText(null);
				temperaturaMantenimiento.setText(null);
				tiempoMaximoSinRefrigeracionHoras.setText(null);
				horneadoRefrigeradoButtonGroup.clearSelection();
			}
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
			horneadoRefrigeradoButtonGroup.clearSelection();
			esHojaldrado.setVisible(false);
			esHojaldrado.setSelected(false);

			jLabeltemperaturaMantenimiento.setVisible(false);
			temperaturaMantenimiento.setVisible(false);

			jLabeltiempoMaximoSinRefrigeracionHoras.setVisible(false);
			tiempoMaximoSinRefrigeracionHoras.setVisible(false);

		}
	}

	class AccionMostrarRegistros implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String listadoDePostres = "";
			for (int i = 0; i < postres.size(); i++) {
				listadoDePostres += postres.get(i).toString() + "\n";

			}
			JOptionPane.showMessageDialog(null, listadoDePostres);

		}
	}

	class AccionRadioButtonHorneado implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// JOptionPane.showMessageDialog(null, "Radio Boton Horneado seleccionado");
			esHojaldrado.setVisible(true);

			jLabeltemperaturaMantenimiento.setVisible(false);
			temperaturaMantenimiento.setVisible(false);

			jLabeltiempoMaximoSinRefrigeracionHoras.setVisible(false);
			tiempoMaximoSinRefrigeracionHoras.setVisible(false);
		}
	}

	class AccionRadioButtonRefrigerado implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// JOptionPane.showMessageDialog(null, "Radio Boton Refrigerado seleccionado");
			esHojaldrado.setVisible(false);
			esHojaldrado.setSelected(false);

			jLabeltemperaturaMantenimiento.setVisible(true);
			temperaturaMantenimiento.setVisible(true);

			jLabeltiempoMaximoSinRefrigeracionHoras.setVisible(true);
			tiempoMaximoSinRefrigeracionHoras.setVisible(true);
		}
	}

}
