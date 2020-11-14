package software;

public class ControladorPedido {

	public static boolean validarSiExisteCodigoPedido(String codigoPedidoActual) {
		boolean existePedido = false;

		for (int i = 0; i < GuiRegistrarPedido.pedidosList.size(); i++) {
			if (GuiRegistrarPedido.pedidosList.get(i).getCodigoPedido().equalsIgnoreCase(codigoPedidoActual)) {
				existePedido = true;
			}
		}
		return existePedido;
	}

	public static double calcularValorTotalDelPedido() {
		double calcularValorTotal = 0;

		for (int i = 0; i < GuiRegistrarPedido.pedidosList.get(GuiRegistrarPedido.pedidosList.size() - 1).postresDelPedidoList.size(); i++) {
			calcularValorTotal += GuiRegistrarPedido.pedidosList.get(GuiRegistrarPedido.pedidosList.size() - 1).postresDelPedidoList.get(i).getPrecio();
		}
		if (GuiRegistrarPedido.domicilio.isSelected() == true) {
			calcularValorTotal += GuiRegistrarPedido.valorDomicilio;
		}
		return calcularValorTotal;
	}

	public static int cantidadDePostresXPedido(String codigoPedidoAConsultar) {
		int totalPostresXPedido = 0;

		for (int i = 0; i < GuiRegistrarPedido.pedidosList.size(); i++) {
			if (GuiRegistrarPedido.pedidosList.get(i).getCodigoPedido().equals(codigoPedidoAConsultar)) {
				totalPostresXPedido = GuiRegistrarPedido.pedidosList.get(i).postresDelPedidoList.size();
			}
		}
		return totalPostresXPedido;
	}

	public static double edadPromedioClientesDomicilio() {
		double edadPromedio = 0;
		double sumaEdad = 0;
		double totalPedidosADomicilio = 0;

		for (int i = 0; i < GuiRegistrarPedido.pedidosList.size(); i++) {
			if (GuiRegistrarPedido.pedidosList.get(i).getLugarDeEntrega().equals("Domicilio")) {
				totalPedidosADomicilio++;
				sumaEdad += GuiRegistrarPedido.pedidosList.get(i).getCliente().getEdad();
			}
		}
		return edadPromedio = sumaEdad / totalPedidosADomicilio;
	}
}
