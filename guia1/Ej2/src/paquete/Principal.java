package paquete;

public class Principal {

	public static void main(String[] args) {
		
		i1.etiquetarPersona(p1);
		i1.etiquetarPersona(p2);
		
		i3.agregarComentario("Que hermosa foto");
		
		int min= Math.min(p1.getEdad(), p2.getEdad(), p3.getEdad());
		
		boolean esPropietario = (i2.getPropietario() == p3);
		
		String cadena = i3.getComentarios();
		
		String paisauxiliar = i2.getLugar().getPais();
		
		i1.setLugar(l2);
		
	}

}
 