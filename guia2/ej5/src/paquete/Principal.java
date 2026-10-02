package paquete;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		Empresa empresa=new Empresa();

		empresa.agregarCategoria(new Categoria("Principiante",100));
		empresa.agregarCategoria(new Categoria("Intermedio",200));
		empresa.agregarCategoria(new Categoria("Experto",350));

		Colectivo col1 = new Colectivo("Mercedes");
		Colectivo col2 = new Colectivo("Volvo");
		Colectivo col3 = new Colectivo("Scania");

		empresa.agregarColectivo(col1);
		empresa.agregarColectivo(col2);
		empresa.agregarColectivo(col3);

		Chofer ch1=new Chofer(empresa.getCategorias().get(0),new Domicilio("Luro",1234),"Juan Perez");
		Chofer ch2=new Chofer(empresa.getCategorias().get(1),new Domicilio("Colon",5678),"Maria Gomez");
		Chofer ch3=new Chofer(empresa.getCategorias().get(2),new Domicilio("Belgrano",910),"Carlos lopez");

		empresa.agregarChofer(ch1);
		empresa.agregarChofer(ch2);
		empresa.agregarChofer(ch3);

		empresa.asignarColectivoAChofer(ch1,col1);
		empresa.asignarColectivoAChofer(ch2,col2);

		empresa.mostrarTodosLosChoferes();
		System.out.println();
		
		System.out.println("Choferes sin colectivo: "+empresa.cantidadChoferesSinColectivo());
		System.out.println("Total colectivos en la empresa: "+empresa.totalColectivos());
		System.out.println();
		
		empresa.mostrarChoferesPorCategorias("Intermedio");
		System.out.println();
		
		empresa.mostrarCategoriaSueldoSuperior(150);
		System.out.println();
		
		empresa.mostrarChoferesSueldoSuperior(150);
		System.out.println();
		
		System.out.println("Desvinculando colectivo a Juan");
		empresa.desvincularColectivoDeChofer(ch1);
		System.out.println(ch1);
		System.out.println("Nuevo total de choferes sin colectivo: " + empresa.cantidadChoferesSinColectivo());
		
	}
	
}
