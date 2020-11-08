package software;

import java.util.ArrayList;

public class Pedido {

	private String codigoPedido;
	private String fechaPedido;
	private String fechaEntregaPedido;
	private Cliente cliente;
	private String lugarDeEntrega;
	private double valorTotal;
	// private int cantpostres;
	ArrayList<Postre> postresDelPedidoList = new ArrayList<Postre>();

	public Pedido(String codigoPedido, String fechaPedido, String fechaEntregaPedido, Cliente cliente, String lugarDeEntrega, double valorTotal, Postre postrePedido) {
		this.codigoPedido = codigoPedido;
		this.fechaPedido = fechaPedido;
		this.fechaEntregaPedido = fechaEntregaPedido;
		this.cliente = cliente;
		this.lugarDeEntrega = lugarDeEntrega;
		this.valorTotal = valorTotal;
		postresDelPedidoList.add(postrePedido);

//		postre = new Postre[p];
//		cantpostres = 0;

	}

	@Override
	public String toString() {
		return "Código del pedido=" + codigoPedido + ", Fecha del pedido=" + fechaPedido + ", Fecha de entrega del Pedido=" + fechaEntregaPedido + ", Lugar de entrega=" + lugarDeEntrega
				+ ", valorTotal=" + valorTotal + "\n" + cliente + "\n" + "Los postres del pedido son:\n" + postresDelPedidoList + "\n";
	}

	public String getCodigoPedido() {
		return codigoPedido;
	}

	public String listaPostresPedido() {

		String listadoPostresPedidoString = "Los postres son";

		for (int i = 0; i < postresDelPedidoList.size(); i++) {
			listadoPostresPedidoString += postresDelPedidoList.get(i) + "\n";
		}

		return listadoPostresPedidoString;

	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getLugarDeEntrega() {
		return lugarDeEntrega;
	}

	public Cliente getCliente() {
		return cliente;
	}

//	public void agregarPotre(Postre recibirpostre) {
//		if (cantpostres < postre.length) {
//			postre[cantpostres] = recibirpostre;
//			cantpostres++;
//		}
//	}

//	public void calcularvalortotal() {
//		double ContTotal = 0;
//
//		for (int i = 0; i < cantpostres; i++) {
//			// sumar la cantidad del valir de los postres y (asignar resultado del acumulador en totalValor(porfuera del ciclo))
//		}
//	}

//	@Override
//	public String toString() {
//		String cadena = "";
//		cadena = "codigoPedido=" + codigoPedido + ", fechaPedido=" + fechaPedido + ", fechaEntregaPedido=" + fechaEntregaPedido + ", cliente=" + cliente + ", postre=" + postre + ", lugarDeEntrega="
//				+ lugarDeEntrega + ", valorTotal=" + valorTotal;
//		for (int i = 0; cantpostres >= i; i++) {
//			cadena = "\ncantidad de postres\n";
//			cadena += postre[i].toString();
//			// se organiza el error para recorre el vector postre
//
//		}
//		return cadena;
//	}

}
