package software;

public class Ejecutable {

	public static void main(String[] args) {

		GuiMenu menu = new GuiMenu();

		new GuiRegistrarCliente();
                
                Cliente Santi = new Cliente("Santiago","San juan",37564,"Hombre", 18 );
                
                GuiRegistrarCliente.cliente.add(Santi);
                  Cliente Ivan = new Cliente("Ivan","San juan",54323,"Hombre", 27 );
                
                GuiRegistrarCliente.cliente.add(Ivan);
                
                  Cliente Federico = new Cliente("Federico","San juan",35564,"Hombre", 18 );
                
                GuiRegistrarCliente.cliente.add(Federico);
                
                  Cliente jose = new Cliente("Jose","San juan",37514,"Hombre", 19);
                
                GuiRegistrarCliente.cliente.add(jose);

		new GuiRegistrarPostre();
                
                PostreRefrigerado oreo = new PostreRefrigerado("Oreo",150.50,"31 de diciembre",7500.50,22,1);
                
                GuiRegistrarPostre.postres.add(oreo); 

		new GuiRegistrarPedido();
	}

}
