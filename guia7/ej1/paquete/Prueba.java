package paquete;

import java.util.*;

public class Prueba {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Perez", "Carlos", "Colon 3212");
        Persona persona2 = new Persona("Perez", "Carlos", "Colon 3212");
        Persona persona3 = new Persona("Garcia", "Ana", "Mitre 2812");
        Persona persona4 = new Persona("Alvarez", "Valeria", "San Luis 2812");
        Persona persona5 = new Persona("Garcia", "Luis", "Matheu 3538");

        System.out.println(persona1 == persona2);
        System.out.println(persona1.equals(persona2));
        Persona[] personas = new Persona[5];
        personas[0] = persona1;
        personas[1] = persona2;
        personas[2] = persona3;
        personas[3] = persona4;
        personas[4] = persona5;


        for (int i = 0; i < 5; i++) {
            System.out.println(personas[i]);
        }

        System.out.println("---------------------------------------------------------------------------");

        Ordenadora.ordenar(personas);

        for (int i = 0; i < 5; i++) {
            System.out.println(personas[i]);
        }

        System.out.println("--------------------------HASHSET-------------------------------------------------");
        Iterator<Persona> it;

        HashSet<Persona> pHS = new HashSet<>();
        pHS.add(persona1);
        pHS.add(persona2);
        pHS.add(persona3);
        pHS.add(persona4);
        pHS.add(persona5);
        it = pHS.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("-----------------------LINKEDHASHSET----------------------------------------------------");

        LinkedHashSet<Persona> pLHS = new LinkedHashSet<>();
        pLHS.addFirst(persona1);
        pLHS.addFirst(persona2);
        pLHS.addFirst(persona3);
        pLHS.addFirst(persona4);
        pLHS.addFirst(persona5);
        it = pLHS.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("------------------------------TREESET---------------------------------------------");

        TreeSet<Persona> pTS = new TreeSet<>();
        pTS.add(persona1);
        pTS.add(persona2);
        pTS.add(persona3);
        pTS.add(persona4);
        pTS.add(persona5);
        it = pTS.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("------------------------------ARRAYLIST---------------------------------------------");

        ArrayList<Persona> pAL = new ArrayList<>();
        pAL.add(persona1);
        pAL.add(persona2);
        pAL.add(persona3);
        pAL.add(persona4);
        pAL.add(persona5);
        it = pAL.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("-----------------------------------LINKEDLIST----------------------------------------");

        LinkedList<Persona> pLL = new LinkedList<>();
        pLL.add(0, persona1);
        pLL.add(1, persona2);
        pLL.add(2, persona3);
        pLL.add(3, persona4);
        pLL.add(4, persona5);
        it = pLL.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("----------------------------------PRIORITYQUEUE-----------------------------------------");

        PriorityQueue<Persona> pPQ = new PriorityQueue<>();
        pPQ.offer(persona1);
        pPQ.offer(persona2);
        pPQ.offer(persona3);
        pPQ.offer(persona4);
        pPQ.offer(persona5);
        while(!pPQ.isEmpty())
            System.out.println(pPQ.poll());
    }
}

