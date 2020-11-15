package software;

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
