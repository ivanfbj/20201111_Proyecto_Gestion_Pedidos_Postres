package software;

public class Cliente {

	private Long nId;
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

	public Long getnId() {
		return nId;
	}

	public void setnId(Long nId) {
		this.nId = nId;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public long getTelefono() {
		return telefono;
	}

	public String getSexo() {
		return sexo;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public String toString() {
		return nombreCliente ;
	}

	public String informacionCompleta() {
		return "Nombre del cliente=" + nombreCliente + ", Direccion=" + direccion + ", Telefono=" + telefono + ", Sexo=" + sexo + ", Edad=" + edad;
	}
	
	
}
