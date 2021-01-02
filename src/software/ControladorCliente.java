package software;

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
}
