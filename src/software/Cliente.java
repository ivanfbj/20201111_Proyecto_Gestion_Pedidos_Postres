package software;

public class Cliente {

	private String nombreCliente;
	private String direccion;
	private int telefono;
	private String sexo;
	private int edad;

	// Constructor explicito
	public Cliente(String nombreCliente, String direccion, int telefono, String sexo, int edad) {
		this.nombreCliente = nombreCliente;
		this.direccion = direccion;
		this.telefono = telefono;
		this.sexo = sexo;
		this.edad = edad;
	}

    public String getNombreCliente() {
        return nombreCliente;
    }

	@Override
	public String toString() {
		return "Nombre del cliente=" + nombreCliente + ", Direccion=" + direccion + ", Telefono=" + telefono + ", Sexo=" + sexo + ", Edad=" + edad;
	}


}
