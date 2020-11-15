package software;

public class Cliente {

	private String nombreCliente;
	private String direccion;
	private long telefono;
	private String sexo;
	private int edad;

	// Constructor explicito
	public Cliente(String nombreCliente, String direccion, long telefono, String sexo, int edad) {
		this.nombreCliente = nombreCliente;
		this.direccion = direccion;
		this.telefono = telefono;
		this.sexo = sexo;
		this.edad = edad;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public long getTelefono() {
		return telefono;
	}
	
	public int getEdad() {
		return edad;
	}

	@Override
	public String toString() {
		return "Nombre del cliente=" + nombreCliente + ", Direccion=" + direccion + ", Telefono=" + telefono + ", Sexo=" + sexo + ", Edad=" + edad;
	}

}
