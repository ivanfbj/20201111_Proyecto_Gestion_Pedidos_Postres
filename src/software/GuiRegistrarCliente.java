package software;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuiRegistrarCliente extends JFrame {

	ButtonGroup sexo;
	JRadioButton masculino, femenino;
	JTextField nombreCliente, direccion, telefono, edad;
	JButton guardarButton, limpiarCamposButton, mostrarClientesButton;
        static ArrayList<Cliente> cliente = new ArrayList<Cliente>();
	//ControladorCliente cliente = new ControladorCliente(10);

	public GuiRegistrarCliente() {
		setTitle("Registrar Cliente");
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		// setLayout(new GridLayout(10,3));

		add(new JLabel("Nombre del cliente:"));
		add(nombreCliente = new JTextField(20));

		/*
		 * nombreCliente = new JTextField(20); add(nombreCliente);
		 */
		add(new JLabel("Direccion:"));
		add(direccion = new JTextField(25));

		add(new JLabel("Telefono:"));
		add(telefono = new JTextField(26));

		add(new JLabel("Edad:"));
		add(edad = new JTextField(7));

		add(new JLabel("Sexo:"));
		sexo = new ButtonGroup();
		masculino = new JRadioButton("Masculino");
		masculino.setActionCommand("Masculino");
		add(masculino);

		femenino = new JRadioButton("Femenino");
		femenino.setActionCommand("Femenino");
		add(femenino);

		sexo.add(masculino);
		sexo.add(femenino);

		add(guardarButton = new JButton("Guardar"));
		guardarButton.addActionListener(new Guardar());

		add(limpiarCamposButton = new JButton("Limpiar campos"));
		limpiarCamposButton.addActionListener(new LimpiarCampos());

		add(mostrarClientesButton = new JButton("Mostrar clientes registrados"));
		mostrarClientesButton.addActionListener(new MostrarClientesRegistrados());

		setSize(400, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	class Guardar implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (nombreCliente.getText().equals("") || direccion.getText().equals("") || telefono.getText().equals("") || edad.getText().equals("")
					|| (masculino.isSelected() == false & femenino.isSelected() == false)) {
				
				JOptionPane.showMessageDialog(null, "Por favor verificar que todos los campos esten diligenciados","FALTA INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
			
			} else {

				Cliente clientes= new Cliente(nombreCliente.getText(), direccion.getText(), Integer.parseInt(telefono.getText()), sexo.getSelection().getActionCommand(), Integer.parseInt(edad.getText()));
                                cliente.add(clientes);

				JOptionPane.showMessageDialog(null, "El cliente fue registrado exitosamente.");

				nombreCliente.setText(null);
				direccion.setText(null);
				telefono.setText(null);
				edad.setText(null);
				sexo.clearSelection();
			}
		}
	}

	class LimpiarCampos implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			nombreCliente.setText(null);
			direccion.setText(null);
			telefono.setText(null);
			edad.setText(null);
			sexo.clearSelection();


		}
	}

	class MostrarClientesRegistrados implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String listadoClientes="";
                        for (int i = 0; i < cliente.size(); i++) {
                       listadoClientes+=cliente.get(i).toString()+"\n";
                        
                    }
                        JOptionPane.showMessageDialog(null, listadoClientes);

		}
	}

}
