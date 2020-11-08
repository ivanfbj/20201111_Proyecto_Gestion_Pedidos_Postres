package software;

public class Ejecutable {

	public static void main(String[] args) {

		GuiMenu menu = new GuiMenu();

		Cliente cliente0 = new Cliente("Ivan", "Cra 40", 2701234, "Masculino", 27);
		GuiRegistrarCliente.cliente.add(cliente0);

		Cliente cliente1 = new Cliente("Luisa", "Cra 50", 2702345, "Femenino", 28);
		GuiRegistrarCliente.cliente.add(cliente1);

		Cliente cliente2 = new Cliente("Federico", "Calle 2", 2222222, "Masculino", 18);
		GuiRegistrarCliente.cliente.add(cliente2);

		Cliente cliente3 = new Cliente("Daniel", "Calle 3", 3333333, "Masculino", 19);
		GuiRegistrarCliente.cliente.add(cliente3);

		Cliente cliente4 = new Cliente("Santiago", "Calle 4", 4444444, "Masculino", 18);
		GuiRegistrarCliente.cliente.add(cliente4);

		Cliente cliente5 = new Cliente("Maria Isabel", "Calle 5", 555555, "Femenino", 18);
		GuiRegistrarCliente.cliente.add(cliente5);

		PostreHorneado postreNoHojaldrado = new PostreHorneado("MoraNoH", 100, "11 noviembre", 2000, false);
		PostreHorneado postreSiHojaldrado = new PostreHorneado("FresaSiH", 200, "12 noviembre", 3000, true);
		// PostreRefrigerado postreR = new PostreRefrigerado("Maracuya", 300, "13 noviembre", 4000, 15, 24.5);

		GuiRegistrarPostre.postres.add(postreNoHojaldrado);
		GuiRegistrarPostre.postres.add(postreSiHojaldrado);
		// GuiRegistrarPostre.postres.add(postreR);
		GuiRegistrarPostre.postres.add(new PostreRefrigerado("MaracuyaRefrige", 300, "13 noviembre", 4000, 15, 24.5));
		GuiRegistrarPostre.postres.add(new PostreRefrigerado("Oreo", 500, "14 noviembre", 5000, 20, 20));

		// new GuiRegistrarCliente();

		// new GuiRegistrarPostre();

		new GuiRegistrarPedido();
		// new GuiPromedioCliente();
		
		
		new GuiInformes();
	}

}
