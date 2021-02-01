package software;

import daoInterfaces.DAOCliente;
import interfazGraficaDeUsuario.GuiRegistrarCliente;
import interfazGraficaDeUsuario.GuiRegistrarPedido;

//ESTA CLASE ES REMPLAZADA POR DAOCliente y el método validarSiExisteCliente, YA QUE AHORA LA CONEXIÓN ES A UNA BASE DE DATOS MySQL
public class ControladorCliente {

	public static boolean validarSiExisteCliente(String nombreTelefonoCliente) {
		boolean existeCiente = false;

		if (GuiRegistrarCliente.cliente.isEmpty() == false) {
			for (int i = 0; i < GuiRegistrarCliente.cliente.size(); i++) {
				String clienteRegistrado = GuiRegistrarCliente.cliente.get(i).getNombreCliente() + GuiRegistrarCliente.cliente.get(i).getTelefono();

				if (nombreTelefonoCliente.equalsIgnoreCase(clienteRegistrado)) {
					existeCiente = true;
				}
			}
		}
		return existeCiente;
	}
	
public static void agregarClienteAlJComboBoxClienteGuiRegistrarPedido() {
	try {
		GuiRegistrarPedido.cliente.removeAllItems();
		
		GuiRegistrarPedido.cliente.addItem(new Cliente("Sin seleccionar", "", 0, "", 0));
		
		for (Cliente objClienteEnGuiRegistrarPedido : DAOCliente.listaClientes()) {
			GuiRegistrarPedido.cliente.addItem(objClienteEnGuiRegistrarPedido);
		}

	} catch (Exception e2) {
		e2.printStackTrace();
		System.out.println("La ventana de pedido no fue inicializada antes de abrir el aplicativo");
	}
}
	
}
