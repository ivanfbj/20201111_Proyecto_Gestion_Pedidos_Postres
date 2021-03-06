package software;

public class Postre {

	private String nombrePostre;
	private double cantidadDeCalorias;
	private String fechaVencimiento;
	private double precio;
	private boolean esRefrigerado = false;

	//Contructor explicito
	public Postre(String nombrePostre, double cantidadDeCalorias, String fechaVencimiento, double precio) {
		this.nombrePostre = nombrePostre;
		this.cantidadDeCalorias = cantidadDeCalorias;
		this.fechaVencimiento = fechaVencimiento;
		this.precio = precio;
	}

	public String getNombrePostre() {
		return nombrePostre;
	}

	public double getPrecio() {
		return precio;
	}

	public boolean esRefrigerado() {
		return esRefrigerado;
	}

	public void setEsRefrigerado(boolean esRefrigerado) {
		this.esRefrigerado = esRefrigerado;
	}
	
	@Override
	public String toString() {
		return "Nombre del postre=" + nombrePostre + ", Cantidad de calorias=" + cantidadDeCalorias + ", Fecha de vencimiento=" + fechaVencimiento + ", Precio=" + precio;
	}

}
