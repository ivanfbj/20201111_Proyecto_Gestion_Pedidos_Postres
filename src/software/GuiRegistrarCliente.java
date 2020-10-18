package software;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuiRegistrarCliente extends JFrame {

	public GuiRegistrarCliente() {
		setTitle("Registrar Cliente");
		setLayout(new FlowLayout());
		// setLayout(new GridLayout(10,3));
		

		ButtonGroup sexo;
		JRadioButton masculino, femenino;
		JTextField nombreCliente, direccion, telefono, edad;
		JButton guardarButton, limpiarCamposButton;

		add(new JLabel("Nombre del cliente:"));
		add(nombreCliente = new JTextField(20));
		

		add(new JLabel("Dirección:"));
		add(direccion = new JTextField(25));

		add(new JLabel("Telefono:"));
		add(telefono = new JTextField(27));

		add(new JLabel("Edad:"));
		add(edad = new JTextField(28));
		
		add(new JLabel("Sexo:"));
		sexo = new ButtonGroup();
		add(masculino = new JRadioButton("Masculino"));
		add(femenino = new JRadioButton("Femenino"));
		sexo.add(masculino);
		sexo.add(femenino);
		
		
		add(guardarButton = new JButton("Guardar"));
		
		add(limpiarCamposButton = new JButton("Limpiar campos"));


		setSize(400, 500);
		setResizable(false);// Establecemos si la ventana puede cambiar de tamaño o no
		setLocationRelativeTo(null);
		setVisible(true);

	}
}
