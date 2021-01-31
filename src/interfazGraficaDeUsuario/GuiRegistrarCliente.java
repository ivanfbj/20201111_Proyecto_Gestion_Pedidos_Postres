package interfazGraficaDeUsuario;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import daoInterfaces.DAOCliente;
import software.Cliente;
import software.ControladorCliente;

public class GuiRegistrarCliente extends JFrame {

	ButtonGroup sexo;
	JRadioButton masculino, femenino;
	static JTextField nombreCliente, direccion, telefono, edad;
	JButton guardarButton, limpiarCamposButton, mostrarClientesButton;
	public static ArrayList<Cliente> cliente = new ArrayList<Cliente>();

	DAOCliente daoClienteDB = new DAOCliente();

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
		mostrarClientesButton.addActionListener(new MostrarClientesRegistradosDB());

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
				if (ControladorCliente.validarSiExisteCliente(nombreCliente.getText() + telefono.getText()) == false) {
					Cliente clientes = new Cliente(nombreCliente.getText(), direccion.getText(), Long.parseLong(telefono.getText()), sexo.getSelection().getActionCommand(),
							Integer.parseInt(edad.getText()));

					// LINEA PARA BORRAR CON LA MIGRACIÓN A MySQL
					cliente.add(clientes);

					// En este bloque TRY CATCH, se comenzó a implementar el envío de información a la base de datos MySQL.
					try {
						daoClienteDB.registrarCliente(clientes);
					} catch (Exception e1) {
						System.out.println("GuiRegistrarCliente, falla al guardar cliente en la base de datos");
						e1.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, "El cliente fue registrado exitosamente.", "Cliente Registrado", JOptionPane.INFORMATION_MESSAGE);

					nombreCliente.setText(null);
					direccion.setText(null);
					telefono.setText(null);
					edad.setText(null);
					sexo.clearSelection();

					// Controlar el error en consola cuando no se abre primero la ventana de pedido antes de registrar cliente
					try {
						GuiRegistrarPedido.cliente.addItem(clientes.getNombreCliente());
					} catch (Exception e2) {
						System.out.println("La ventana de pedido no fue inicializada antes de abrir el aplicativo");
					}

				} else {
					JOptionPane.showMessageDialog(null, "El cliente ya existe por favor verificar la lista de clientes existentes", "CLIENTE DUPLICADO", JOptionPane.INFORMATION_MESSAGE);
				}

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

//METODO QUE SE DEBE CAMBIAR YA QUE LA CONSULTA SE REALIZARÁ HACÍA LA BASE DE DATOS
	class MostrarClientesRegistrados implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String listadoClientes = "";
			for (int i = 0; i < cliente.size(); i++) {
				listadoClientes += cliente.get(i).toString() + "\n";

			}
			JOptionPane.showMessageDialog(null, listadoClientes, "Clientes Registrados", JOptionPane.INFORMATION_MESSAGE);

		}
	}

	class MostrarClientesRegistradosDB implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String listadoClientes = "";
			try {

				if (!DAOCliente.listaClientes().isEmpty()) {
					for (Cliente c : DAOCliente.listaClientes()) {
						listadoClientes += c.toString() + "\n";
					}
					JOptionPane.showMessageDialog(null, listadoClientes, "Clientes Registrados", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "No hay cliente reglistrados", "SIN Clientes Registrados", JOptionPane.INFORMATION_MESSAGE);
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	}

}
