package paquete;

public abstract class Permanente extends Empleado{
		protected int antiguedad;
		protected double sueldoBase;

		private static final double APORTE_JUBILATORIO = 0.11;
	    private static final double OBRA_SOCIAL = 0.06;
		
		public Permanente(String nombre,int legajo,String domicilio,int antiguedad,double sueldoBase) {
			super(nombre,legajo,domicilio);
			this.antiguedad=antiguedad;
			this.sueldoBase=sueldoBase;
		}

		public int getAntiguedad() {
			return antiguedad;
		}

		public void setAntiguedad(int antiguedad) {
			this.antiguedad = antiguedad;
		}

		public double getSueldoBase() {
			return sueldoBase;
		}

		public void setSueldoBase(double sueldoBase) {
			this.sueldoBase = sueldoBase;
		}
		
		public abstract double calcularSueldoBruto();
		
		public final double calcularSueldoNeto() {
			double bruto=calcularSueldoBruto();
			return bruto*(1-APORTE_JUBILATORIO-OBRA_SOCIAL);
		}
}
