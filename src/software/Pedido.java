package software;

public class Pedido {

	private String codigoPedido;
	private String fechaPedido;
	private String fechaEntregaPedido;
	private Cliente cliente;
	private Postre[] postre;
	private String lugarDeEntrega;
	private double valorTotal;
	private int cantpostres;// contador

	public Pedido(String codigoPedido, String fechaPedido, String fechaEntregaPedido, Cliente cliente, String lugarDeEntrega, double valorTotal, int p) {
		this.codigoPedido = codigoPedido;
		this.fechaPedido = fechaPedido;
		this.fechaEntregaPedido = fechaEntregaPedido;
		this.cliente = cliente;
		this.lugarDeEntrega = lugarDeEntrega;
		this.valorTotal = valorTotal;

		postre = new Postre[p];
		cantpostres = 0;

	}
       /* public void agregarPotre(Postre recibirpostre){
            if(cantpostres<postre.length){
                postre[cantpostres]=recibirpostre;
                cantpostres++;
            }
        }*/
        public void calcularvalortotal(){
            //recorrer el vector, definir un acumulador de pecios
        }
        

	@Override
	public String toString() {
		String cadena = "";
		cadena = "codigoPedido=" + codigoPedido + ", fechaPedido=" + fechaPedido + ", fechaEntregaPedido=" + fechaEntregaPedido + ", cliente=" + cliente + ", postre=" + postre + ", lugarDeEntrega="
				+ lugarDeEntrega + ", valorTotal=" + valorTotal;
		for (int i = 0; cantpostres >= i; i++) {
			cadena = "\ncantidad de postres\n";
			cadena += postre[i].toString();
			// se organiza el error para recorre el vector postre

		}
		return cadena;
	}
}
