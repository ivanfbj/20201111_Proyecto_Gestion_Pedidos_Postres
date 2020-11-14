package software;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class GuiRegistrarCliente extends JFrame {

	ButtonGroup sexo;
	JRadioButton masculino, femenino;
	JTextField nombreCliente, direccion, telefono, edad;
	JButton guardarButton, limpiarCamposButton, mostrarClientesButton;
	static ArrayList<Cliente> cliente = new ArrayList<Cliente>();

	public GuiRegistrarCliente() {
		setTitle("Registrar Cliente");
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		// setLayout(new GridLayout(10,3));

		add(new JLabel("Nombre del cliente:"));
		add(nombreCliente = new JTextField(20));

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
//Si hay algún campo vacío no se podrá guardar el cliente.
			if (nombreCliente.getText().equals("") || direccion.getText().equals("") || telefono.getText().equals("") || edad.getText().equals("")
					|| (masculino.isSelected() == false & femenino.isSelected() == false)) {

				JOptionPane.showMessageDialog(null, "Por favor verificar que todos los campos esten diligenciados", "FALTA INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

			} else {

				Cliente clientes = new Cliente(nombreCliente.getText(), direccion.getText(), Long.parseLong(telefono.getText()), sexo.getSelection().getActionCommand(),
						Integer.parseInt(edad.getText()));
				cliente.add(clientes);
				GuiRegistrarPedido.cliente.addItem(clientes.getNombreCliente());
				
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

			String listadoClientes = "";
			for (int i = 0; i < cliente.size(); i++) {
				listadoClientes += cliente.get(i).toString() + "\n";

			}
			JOptionPane.showMessageDialog(null, listadoClientes);

		}
	}

}
