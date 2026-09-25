package paquete;

public class Empleado {
	
	private String nombre,telefono,email;
	
	public Empleado(String nombre, String telefono, String email) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}


	public String getNombre() {
		return nombre;
	}


	public String getTelefono() {
		return telefono;
	}


	public String getEmail() {
		return email;
	}


	public Empleado() {
		// TODO Auto-generated constructor stub
	}

}
