package software;

public class ControladorPostre {
//ESTA CLASE Y SU MÉTODO TAMBIÉN SE CAMBIAN POR EL MÉTODO EN LA CLASE DAOPostre.
	public static double PorcentajePostresRefrigerado() {
		double porcentaje = 0;
		double totalPostres = GuiRegistrarPostre.postres.size();
		double cantidadPostresRefrigerados = 0;

		for (int i = 0; i < GuiRegistrarPostre.postres.size(); i++) {
			if (GuiRegistrarPostre.postres.get(i).esRefrigerado() == true) {
				cantidadPostresRefrigerados += 1;
			}
		}
		return porcentaje = (cantidadPostresRefrigerados * 100) / totalPostres;
	}
}
