package software;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GuiRegistrarPostre extends JFrame {

	JTextField nombreDelPostre, cantidadDeCalorias, fechaVencimiento, precio, temperaturaMantenimiento, tiempoMaximoSinRefrigeracionHoras;
	ButtonGroup hojaldreRefrigeradoButtonGroup;
	JRadioButton esHorneado, esRefrigerado, esHojaldrado;
	JButton guardarButton, limpiarCamposButton, mostrarPostresButton;

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
		hojaldreRefrigeradoButtonGroup = new ButtonGroup();
		add(esHorneado = new JRadioButton("Horneado"));
		add(esRefrigerado = new JRadioButton("Refrigerado"));
		hojaldreRefrigeradoButtonGroup.add(esHorneado);
		hojaldreRefrigeradoButtonGroup.add(esRefrigerado);
		add(esHojaldrado = new JRadioButton("Hojaldrado"));

		add(new JLabel("Temperatura de mantenimiento:"));
		add(temperaturaMantenimiento = new JTextField(10));

		add(new JLabel("Tiempo maximo sin refrigeracion:"));
		add(tiempoMaximoSinRefrigeracionHoras = new JTextField(9));

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

				Postre postreGuardado = new Postre(nombreDelPostre.getText(), Double.parseDouble(cantidadDeCalorias.getText()), fechaVencimiento.getText(), Double.parseDouble(precio.getText()),
						Double.parseDouble(temperaturaMantenimiento.getText()), Double.parseDouble(tiempoMaximoSinRefrigeracionHoras.getText()), esHorneado.isSelected(), esHojaldrado.isSelected());
				postres.add(postreGuardado);

				JOptionPane.showMessageDialog(null, "El postre fue registrado exitosamente.");

				nombreDelPostre.setText(null);
				cantidadDeCalorias.setText(null);
				fechaVencimiento.setText(null);
				precio.setText(null);
				temperaturaMantenimiento.setText(null);
				tiempoMaximoSinRefrigeracionHoras.setText(null);
				hojaldreRefrigeradoButtonGroup.clearSelection();
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
			hojaldreRefrigeradoButtonGroup.clearSelection();

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

}
