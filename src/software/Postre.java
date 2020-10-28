package software;

public class Postre {

	private String nombrePostre;
	private double cantidadDeCalorias;
	private String fechaVencimiento;
	private double precio;
	private double temperaturaMantenimiento;
	private double tiempoMaximoSinRefrigeracionHoras;
	private boolean esHojaldrado;

	public Postre(String nombrePostre, double cantidadDeCalorias, String fechaVencimiento, double precio, double temperaturaMantenimiento, double tiempoMaximoSinRefrigeracionHoras,
			boolean esHojaldrado) {

		this.nombrePostre = nombrePostre;
		this.cantidadDeCalorias = cantidadDeCalorias;
		this.fechaVencimiento = fechaVencimiento;
		this.precio = precio;
		this.temperaturaMantenimiento = temperaturaMantenimiento;
		this.tiempoMaximoSinRefrigeracionHoras = tiempoMaximoSinRefrigeracionHoras;
		this.esHojaldrado = esHojaldrado;
	}

	@Override
	public String toString() {
		return "Nombre del postre=" + nombrePostre + ", Cantidad de calorias=" + cantidadDeCalorias + ", Fecha de vencimiento=" + fechaVencimiento + ", Precio=" + precio
				+ ", Temperatura de mantenimiento=" + temperaturaMantenimiento + ", Tiempo máximo sin refrigeración (horas)=" + tiempoMaximoSinRefrigeracionHoras + ", Hojaldrado=" + esHojaldrado;
	}

    public String getNombrePostre() {
        return nombrePostre;
    }

}
