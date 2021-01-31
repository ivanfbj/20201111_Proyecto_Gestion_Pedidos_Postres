package software;

import java.util.ArrayList;


//LA LÓGICA DEL CLIENTE DEBE CAMBIAR YA QUE NO SE GUARDARÁ UN OBJETO DENTRO DE UN OBJETO
//AHORA SE DEBERÁ DE TENER UNA RELACIÓN EN BASE DE DATOS
public class Pedido {

	private Long nIdPedido;
	private String codigoPedido;
	private String fechaPedido;
	private String fechaEntregaPedido;
	private Cliente cliente;
	private String lugarDeEntrega;
	private double valorTotal;
	public ArrayList<Postre> postresDelPedidoList = new ArrayList<Postre>();

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

	
	public Long getnIdPedido() {
		return nIdPedido;
	}
	
public void setnIdPedido(Long nIdPedido) {
	this.nIdPedido = nIdPedido;
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

	@Override
	public String toString() {
		return "Código del pedido=" + codigoPedido + ", Fecha del pedido=" + fechaPedido + ", Fecha de entrega del Pedido=" + fechaEntregaPedido + ", Lugar de entrega=" + lugarDeEntrega
				+ ", valorTotal=" + valorTotal + "\n" + cliente + "\n" + "Los postres del pedido son:\n" + postresDelPedidoList + "\n";
	}
}
