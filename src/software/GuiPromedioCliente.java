package software;

import java.awt.*;
import javax.swing.*;

public class GuiPromedioCliente extends JFrame {
	JTextField TotalClientes, TotalClientesDomicilio, EdadPromedioClientes, EdadPromedioClientesDomicilio;
	JButton CalcularPromedio;

	public GuiPromedioCliente() {
		setTitle("Promedio clientes");
		setLayout(new FlowLayout());
		// setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		add(new JLabel("Total clientes:"));
		add(TotalClientes = new JTextField(20));

		add(new JLabel("Total clientes domicilio:"));
		add(TotalClientesDomicilio = new JTextField(20));

		add(new JLabel("Edad promedio clientes:"));
		add(EdadPromedioClientes = new JTextField(20));

		add(new JLabel("Edad promedio clientes domicilio:"));
		add(EdadPromedioClientesDomicilio = new JTextField(10));

		add(CalcularPromedio = new JButton("Calcular promedio"));
		// CalcularPromedio.addActionListener(new CalcularPromedio());
		// se crea el boton para calcular la edad promedio del total de ambos clientes.

		setSize(400, 200);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public static void main(String[] args) {
		GuiPromedioCliente ventana = new GuiPromedioCliente();
	}

}
