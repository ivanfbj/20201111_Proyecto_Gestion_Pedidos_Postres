package software;

import java.util.ArrayList;

public class Pedido {

	private String codigoPedido;
	private String fechaPedido;
	private String fechaEntregaPedido;
	private Cliente cliente;
	private String lugarDeEntrega;
	private double valorTotal;
	ArrayList<Postre> postresDelPedidoList = new ArrayList<Postre>();

	// Contructor explicito
	public Pedido(String codigoPedido, String fechaPedido, String fechaEntregaPedido, Cliente cliente, String lugarDeEntrega, double valorTotal, Postre postrePedido) {
		this.codigoPedido = codigoPedido;
		this.fechaPedido = fechaPedido;
		this.fechaEntregaPedido = fechaEntregaPedido;
		this.cliente = cliente;
		this.lugarDeEntrega = lugarDeEntrega;
		this.valorTotal = valorTotal;
		postresDelPedidoList.add(postrePedido);
	}

	@Override
	public String toString() {
		return "Código del pedido=" + codigoPedido + ", Fecha del pedido=" + fechaPedido + ", Fecha de entrega del Pedido=" + fechaEntregaPedido + ", Lugar de entrega=" + lugarDeEntrega
				+ ", valorTotal=" + valorTotal + "\n" + cliente + "\n" + "Los postres del pedido son:\n" + postresDelPedidoList + "\n";
	}

	public String getCodigoPedido() {
		return codigoPedido;
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
}
