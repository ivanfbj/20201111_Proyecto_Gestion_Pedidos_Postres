package software;

public class Ejecutable {

	public static void main(String[] args) {

		GuiMenu menu = new GuiMenu();

		Cliente clientePedido= new Cliente("Ivan", "Cra 40", 2701234, "Masculino", 27);
		GuiRegistrarCliente.cliente.add(clientePedido);

		Cliente clienteDosPedido = new Cliente("Luisa", "Cra 50", 2702345, "Femenino", 28);
		GuiRegistrarCliente.cliente.add(clienteDosPedido);
		
		PostreHorneado postreNoHojaldrado = new PostreHorneado("Mora", 100, "11 noviembre", 2000, false);
		PostreHorneado postreSiHojaldrado = new PostreHorneado("Fresa", 200, "12 noviembre", 3000, true);
		//PostreRefrigerado postreR = new PostreRefrigerado("Maracuya", 300, "13 noviembre", 4000, 15, 24.5);
		
		GuiRegistrarPostre.postres.add(postreNoHojaldrado);
		GuiRegistrarPostre.postres.add(postreSiHojaldrado);
		//GuiRegistrarPostre.postres.add(postreR);
		GuiRegistrarPostre.postres.add(new PostreRefrigerado("Maracuya", 300, "13 noviembre", 4000, 15, 24.5));
		
		
		// new GuiRegistrarCliente();

		//new GuiRegistrarPostre();

		 new GuiRegistrarPedido();
		// new GuiPromedioCliente();
	}

}
