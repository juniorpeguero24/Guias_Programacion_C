package paquete;

public class Intermedio extends Permanente{
	
	public Intermedio(String nombre,int legajo,String domicilio,int antiguedad,double sueldoBase) {
		super(nombre,legajo,domicilio,antiguedad,sueldoBase);
	}
	
	public double calcularSueldoBruto() {
		sueldoBase *= (1.25+1.5*antiguedad);
		return sueldoBase;
	}
}
