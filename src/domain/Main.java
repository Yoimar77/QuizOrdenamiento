package domain;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Crear lista de personas
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona(1, "1001", 25, "M", false, true));
        listaPersonas.add(new Persona(2, "1002", 25, "F", true, false));
        listaPersonas.add(new Persona(3, "1003", 70, "F", false, false));
        listaPersonas.add(new Persona(4, "1004", 18, "F", true, true));
        listaPersonas.add(new Persona(5, "1005", 67, "F", true, true));
        
        //Ordenamiento natural 
        System.out.println("ordenamiento natural del arrayList");
        for (Persona persona : listaPersonas) {
			System.out.println(persona);
		}
        

        // Comparador jer�rquico
        ComparadorJerarquico comparadorJerarquico = new ComparadorJerarquico();
        
        // Comparador embarazo
        ComparadorPorEmbarazo comparadorPorEmbarazo = new ComparadorPorEmbarazo();
        

        // 1. Usar ArrayList con comparador jer�rquico
        System.out.println("--------------------------------------------------");
        System.out.println("ArrayList ordenado con comparador jer�rquico:");
        listaPersonas.sort(comparadorJerarquico);
        listaPersonas.forEach(System.out::println);
        
        
     // 1. Usar ArrayList con comparador por embarazo
        System.out.println("--------------------------------------------------");
        System.out.println("ArrayList ordenado por embarazo:");
        listaPersonas.sort(comparadorPorEmbarazo);
        listaPersonas.forEach(System.out::println);

        // 2. Usar PriorityQueue con comparador jer�rquico
        PriorityQueue<Persona> priorityQueue = new PriorityQueue<>(comparadorJerarquico);
        priorityQueue.addAll(listaPersonas);
        System.out.println("--------------------------------------------------");
        System.out.println("\nPriorityQueue ordenado con comparador jer�rquico:");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

        // 3. Usar TreeSet con comparador jer�rquico
        TreeSet<Persona> treeSet = new TreeSet<>(comparadorJerarquico);
        treeSet.addAll(listaPersonas);
        System.out.println("--------------------------------------------------");
        System.out.println("\nTreeSet ordenado con comparador jer�rquico:");
        treeSet.forEach(System.out::println);

        // Implementar cach�
        Map<String, Persona> cache = new HashMap<>();
        for (Persona persona : listaPersonas) {
            cache.put(persona.getCedula(), persona);
        }
        
     // Crear una PriorityQueue que solo usa el comparador de edad
        PriorityQueue<Persona> priorityQueuePorEdad = new PriorityQueue<>(ComparadorPorEdadLambda.COMPARADOR_POR_EDAD);

        // Agregar personas a la PriorityQueue
        priorityQueuePorEdad.addAll(listaPersonas);

        // Imprimir la PriorityQueue ordenada por edad
        System.out.println("--------------------------------------------------");
        System.out.println("\nPriorityQueue ordenado solo por edad:");
        while (!priorityQueuePorEdad.isEmpty()) {
            System.out.println(priorityQueuePorEdad.poll());
        }

     // Pedir n�mero de c�dula al usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------------------------");
        System.out.print("\nIngrese el n�mero de c�dula para verificar en la cach�: ");
        String cedula = scanner.nextLine();

        // Verificar si la persona est� en la cach�
        if (cache.containsKey(cedula)) {
            Persona persona = cache.get(cedula);
            System.out.println("Persona encontrada en la cach�: " + persona);

            // Preguntar al usuario si desea eliminar a la persona
            System.out.print("�Desea eliminar a esta persona de la cach�? (si/no): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("si")) {
                cache.remove(cedula);
                System.out.println("Persona eliminada de la cach�.");
            } else {
                System.out.println("No se ha eliminado ninguna persona.");
            }
        } else {
            System.out.println("Persona con c�dula " + cedula + " no encontrada en la cach�.");
        }

        scanner.close();
    }
}
