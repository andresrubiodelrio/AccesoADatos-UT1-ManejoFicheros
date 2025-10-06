package operacionesfile;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.File;
import java.io.IOException;

public class CreacionDirectorio {
    public static void main(String[] args)
    {
        String borra;


        if (args.length>0) {
            String path = args[0];
            File d = new File(path, "acceso a datos"); //directorio que creo a partir del actual
            File f1 = new File(d, "ad1.txt");
            File f2 = new File(d, "ad2.txt");

            if (d.mkdir()) //crea fisicamente el directorio
                System.out.println("Directorio acceso a datos creado correctamente.");
            else
                System.out.println("No se ha podido crear el directorio acceso a datos");

            try {

                if (f1.createNewFile())
                    System.out.println("Fichero ad1 creado correctamente....");
                else
                    System.out.println("No se ha podido crear el fichero ad1");

                if (f2.createNewFile())
                    System.out.println("Fichero ad2 creado correctamente....");
                else
                    System.out.println("No se ha podido crear el fichero ad2");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Modificamos el nombre del fichero ad1 por ad1Nuevo.txt");
            f1.renameTo(new File(d, "ad1Nuevo.txt")); //renombre FICHERO1

            System.out.println("Creamos un nuevo fichero ad3 en el directorio previamente creado.");
            try {
                File f3 = new File(d, "ad3.txt");
                f3.createNewFile();//crea fichero ad3 en el directorio acceso a datos
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            do {
                System.out.print("Desea borrar el fichero ad2 (s/n)");
                borra = Entrada.cadena();
            } while (!borra.equalsIgnoreCase("s") && !borra.equalsIgnoreCase("n"));

            if (borra.toLowerCase().equalsIgnoreCase("s")) {
                if (f2.delete())
                    System.out.println("Fichero ad2 borrado...");
                else
                    System.out.println("No se ha podido borrar el fichero ad2.txt");
            } else
                System.out.println("Fichero ad2 NO borrado");
        }
        else
            //si no se introdujo ning?n argumento, muestra un ejemplo de uso
            System.out.println("\n\nEjemplo de uso:\nCreacionDirectorio c:\\tmp");
    }
}
