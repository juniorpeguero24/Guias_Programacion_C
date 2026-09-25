package paquete;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		Empresa empresa=new Empresa();
		
		Categoria principiante=new Categoria("Principiante",100);
		Categoria intermedio=new Categoria("Intermedio",200);
		Categoria experto=new Categoria("Experto",350);
		
		ArrayList<Categoria> listaCategorias=new ArrayList<>();
		listaCategorias.add(principiante);
		listaCategorias.add(intermedio);
		listaCategorias.add(experto);
		
		Colectivo col1=new Colectivo("Mercedes");
		Colectivo col2=new Colectivo("Volvo");
		Colectivo col3=new Colectivo("Scania");
		
		empresa.agregarColectivo(col1);
		empresa.agregarColectivo(col2);
		empresa.agregarColectivo(col3);
		
		Chofer ch1=new Chofer(principiante,new Domicilio("Luro",1234),"Juan Perez");
		Chofer ch2=new Chofer(intermedio,new Domicilio("Colon",5678),"Maria Gomez");
		Chofer ch3=new Chofer(experto,new Domicilio("Belgrano",910),"Carlos lopez");
		
		ch1.asignarColectivo(col1);
		ch2.asignarColectivo(col2);
		
		empresa.agregarChofer(ch1);
		empresa.agregarChofer(ch2);
		empresa.agregarChofer(ch3);
		
		empresa.mostrarTodosLosChoferes();
		System.out.println();
		
		System.out.println("Choferes sin colectivo: "+empresa.cantidadChoferesSinColectivo());
		System.out.println("Total colectivos en la empresa: "+empresa.totalColectivos());
		System.out.println();
		
		empresa.mostrarChoferesPorCategorias("Intermedio");
		System.out.println();
		
		empresa.mostrarCategoriaSueldoSuperior(150, listaCategorias);
		System.out.println();
		
		empresa.mostrarChoferesSueldoSuperior(150);
		System.out.println();
		
		System.out.println("Desvinculando colectivo a Juan");
		ch1.desvincularColectivo();
		System.out.println(ch1);
		System.out.println("Nuevo total de choferes sin colectivo: " + empresa.cantidadChoferesSinColectivo());
		
	}
	
}
