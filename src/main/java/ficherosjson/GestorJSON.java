package ficherosjson;

import java.util.List;

public class GestorJSON {
    public static void main(String[] args) {
        CrudPersonasJSON gestor = new CrudPersonasJSON();

        // Añadir personas
        gestor.agregar(new Persona(1, "Ana", 25));
        gestor.agregar(new Persona(2, "Luis", 30));

        System.out.println("Contenido inicial:");
        gestor.leer().forEach(System.out::println);

        // Modificar y borrar
        gestor.modificar(2, new Persona(2, "Luis Alberto", 31));
        gestor.borrar(1);

        System.out.println("\nDespués de modificar y borrar:");
        gestor.leer().forEach(System.out::println);

        // Escribir un solo objeto (si solo queda uno)
        System.out.println("\nLeyendo primer objeto (por compatibilidad con JSON único):");
        Persona primera = gestor.leerPrimero();
        System.out.println(primera);

        // Si ahora solo hay uno, el archivo se guarda como objeto simple
        gestor.escribir(List.of(primera));
    }
}
