package software;

public class PostreRefrigerado extends Postre {

	private double temperaturaMantenimiento;
	private double tiempoMaximoSinRefrigeracionHoras;

	public PostreRefrigerado(String nombrePostre, double cantidadDeCalorias, String fechaVencimiento, double precio, double temperaturaMantenimiento, double tiempoMaximoSinRefrigeracionHoras) {
		super(nombrePostre, cantidadDeCalorias, fechaVencimiento, precio);
		this.temperaturaMantenimiento = temperaturaMantenimiento;
		this.tiempoMaximoSinRefrigeracionHoras = tiempoMaximoSinRefrigeracionHoras;
		setEsRefrigerado(true);
	}

	public double getTemperaturaMantenimiento() {
		return temperaturaMantenimiento;
	}
	
	public double getTiempoMaximoSinRefrigeracionHoras() {
		return tiempoMaximoSinRefrigeracionHoras;
	}
	
	public String informacionCompleta() {
		return super.informacionCompleta() + ", Temperatura de Mantenimiento=" + temperaturaMantenimiento + ", Tiempo Maximo sin refrigeracion (Horas)=" + tiempoMaximoSinRefrigeracionHoras + "\n";
	}
}
