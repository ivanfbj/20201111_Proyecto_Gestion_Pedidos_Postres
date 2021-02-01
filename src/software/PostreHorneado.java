package software;

public class PostreHorneado extends Postre {

	private boolean esHojaldrado;

	public PostreHorneado(String nombrePostre, double cantidadDeCalorias, String fechaVencimiento, double precio, boolean esHojaldrado) {
		super(nombrePostre, cantidadDeCalorias, fechaVencimiento, precio);
		this.esHojaldrado = esHojaldrado;
	}

	public int getEsHojaldradoInt() {
		int validaHojaldradoEntero;

		return validaHojaldradoEntero = esHojaldrado ? 1 : 0;
	}

	public String informacionCompleta() {
		String validaHojaldrado = esHojaldrado ? "Si" : "No";// operador ternario

		return super.informacionCompleta() + ", Hojaldrado=" + validaHojaldrado + "\n";
	}

}
