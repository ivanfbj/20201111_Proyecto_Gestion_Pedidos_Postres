package software;

public class PostreHorneado extends Postre {

	private boolean esHojaldrado;

	public PostreHorneado(String nombrePostre, double cantidadDeCalorias, String fechaVencimiento, double precio) {
		super(nombrePostre, cantidadDeCalorias, fechaVencimiento, precio);
		this.esHojaldrado = false;
	}

	@Override
	public String toString() {
		return super.toString() + "Hojaldrado=" + esHojaldrado;
	}

}
