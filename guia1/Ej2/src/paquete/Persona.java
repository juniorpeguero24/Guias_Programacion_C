package paquete;

public class Persona {
	private int edad;
	private Lugar lugarNacimento;
	private String nombre;
	
	
	public Persona(int edad, Lugar lugarNacimento, String nombre) {
		super();
		this.edad = edad;
		this.lugarNacimento = lugarNacimento;
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public Lugar getLugarNacimento() {
		return lugarNacimento;
	}


	public String getNombre() {
		return nombre;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public void setLugarNacimento(Lugar lugarNacimento) {
		this.lugarNacimento = lugarNacimento;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Persona() {
		// TODO Auto-generated constructor stub
	}

}
