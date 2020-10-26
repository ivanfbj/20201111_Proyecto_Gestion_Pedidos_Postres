package software;

import java.util.ArrayList;

public class ControladorPostre {

	ArrayList<Postre> postres = new ArrayList<>();

	/*
	 * //Debido a que un ArrayListo se hace de forma dinamica, no es necesario definir el tamanio como //se hace en COntroladorCliente.
	 * 
	 * ControladorPostre() { postre = new ArrayList(); }
	 */

	public void registrarPostre(String nombrePostre, double cantidadDeCalorias, String fechaVencimiento, double precio, double temperaturaMantenimiento, double tiempoMaximoSinRefrigeracionHoras,
			boolean esHojaldrado) {
		postres.add(new Postre(nombrePostre, cantidadDeCalorias, fechaVencimiento, precio, temperaturaMantenimiento, tiempoMaximoSinRefrigeracionHoras, esHojaldrado));
	}

	public void setPostres(Postre postres) {
		this.postres.add(postres);
	}

	@Override
	public String toString() {
		String cad = "la cantidad de postres son\n";
		for (int i = 0; i < postres.size(); i++)
			cad += postres.get(i);

		return cad;

	}

}
