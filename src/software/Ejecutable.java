package software;

public class Ejecutable {
	public static void main(String[] args) {
		
		  Cliente cliente0 = new Cliente("Ivan", "Cra 40", 2701234, "Masculino", 27); GuiRegistrarCliente.cliente.add(cliente0);
		  
		  Cliente cliente1 = new Cliente("Luisa", "Cra 50", 2702345, "Femenino", 28); GuiRegistrarCliente.cliente.add(cliente1);
		  
		  Cliente cliente2 = new Cliente("Federico", "Calle 2", 2222222, "Masculino", 18); GuiRegistrarCliente.cliente.add(cliente2);
		  
		  Cliente cliente3 = new Cliente("Daniel", "Calle 3", 3333333, "Masculino", 19); GuiRegistrarCliente.cliente.add(cliente3);
		  
		  Cliente cliente4 = new Cliente("Santiago", "Calle 4", 4444444, "Masculino", 18); GuiRegistrarCliente.cliente.add(cliente4);
		  
		  Cliente cliente5 = new Cliente("Camila", "Calle 5", 555555, "Femenino", 18); GuiRegistrarCliente.cliente.add(cliente5);
		  
		  PostreHorneado postreNoHojaldrado = new PostreHorneado("MoraNoH", 100, "11 noviembre", 2000, false); PostreHorneado postreSiHojaldrado = new
		  PostreHorneado("FresaSiH", 200, "12 noviembre", 3000, true);
		  
		  GuiRegistrarPostre.postres.add(postreNoHojaldrado); GuiRegistrarPostre.postres.add(postreSiHojaldrado);
		  
		  GuiRegistrarPostre.postres.add(new PostreRefrigerado("MaracuyaRefrige", 300, "13 noviembre", 4000, 15, 24.5)); GuiRegistrarPostre.postres.add(new
		  PostreRefrigerado("Oreo", 500, "14 noviembre", 5000, 20, 20));
		 
		GuiMenu menu = new GuiMenu();
	}
}

// Todo este este bloque de comentarios, es una forma de agilizar las pruebas unitarias del proyecto.
// Se dejan comentareadas en caso de realizar pruebas en actualizaciones del proyecto. Esto no afecta la ejecución prinicipal.
/*
 * Cliente cliente0 = new Cliente("Ivan", "Cra 40", 2701234, "Masculino", 27); GuiRegistrarCliente.cliente.add(cliente0);
 * 
 * Cliente cliente1 = new Cliente("Luisa", "Cra 50", 2702345, "Femenino", 28); GuiRegistrarCliente.cliente.add(cliente1);
 * 
 * Cliente cliente2 = new Cliente("Federico", "Calle 2", 2222222, "Masculino", 18); GuiRegistrarCliente.cliente.add(cliente2);
 * 
 * Cliente cliente3 = new Cliente("Daniel", "Calle 3", 3333333, "Masculino", 19); GuiRegistrarCliente.cliente.add(cliente3);
 * 
 * Cliente cliente4 = new Cliente("Santiago", "Calle 4", 4444444, "Masculino", 18); GuiRegistrarCliente.cliente.add(cliente4);
 * 
 * Cliente cliente5 = new Cliente("Camila", "Calle 5", 555555, "Femenino", 18); GuiRegistrarCliente.cliente.add(cliente5);
 * 
 * PostreHorneado postreNoHojaldrado = new PostreHorneado("MoraNoH", 100, "11 noviembre", 2000, false); PostreHorneado postreSiHojaldrado = new
 * PostreHorneado("FresaSiH", 200, "12 noviembre", 3000, true);
 * 
 * GuiRegistrarPostre.postres.add(postreNoHojaldrado); GuiRegistrarPostre.postres.add(postreSiHojaldrado);
 * 
 * GuiRegistrarPostre.postres.add(new PostreRefrigerado("MaracuyaRefrige", 300, "13 noviembre", 4000, 15, 24.5)); GuiRegistrarPostre.postres.add(new
 * PostreRefrigerado("Oreo", 500, "14 noviembre", 5000, 20, 20));
 */