package paquete;

public abstract class Empleado {
		private String nombre;
		private int legajo;
		private String domicilio;
		
		public Empleado(String nombre,int legajo,String domicilio) {
			this.nombre=nombre;
			this.legajo=legajo;
			this.domicilio=domicilio;
		}
		
		public abstract double calcularSueldoNeto();
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getLegajo() {
			return legajo;
		}

		public void setLegajo(int legajo) {
			this.legajo = legajo;
		}

		public String getDomicilio() { 
			return domicilio;
		}

		public void setDomicilio(String domicilio) {
			this.domicilio = domicilio;
		}
}
