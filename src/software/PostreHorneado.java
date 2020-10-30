package software;

public class PostreHorneado extends Postre {

	private boolean esHojaldrado;

	public PostreHorneado(String nombrePostre, double cantidadDeCalorias, String fechaVencimiento, double precio, boolean esHojaldrado) {
		super(nombrePostre, cantidadDeCalorias, fechaVencimiento, precio);
		this.esHojaldrado = esHojaldrado;
	}

	@Override
	public String toString() {
		String validaHojaldrado = (esHojaldrado == true) ? "Si" : "No";// operador ternario

		return super.toString() + ", Hojaldrado=" + validaHojaldrado;
	}

}
