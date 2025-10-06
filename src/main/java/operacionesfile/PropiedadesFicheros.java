package operacionesfile;

import java.io.File;
import java.util.Date;

public class PropiedadesFicheros {
    public static void main(String[] args) {
        mostrarPropiedadesSistema();
        System.out.println("\nFicheros en direcotrio actual: ");
        System.out.println("============================== ");
        File f = new File ("."); //crea el objero file apuntando al directorio actual
        String[] archivos = f.list(); //guarda las entradas del directorio en el array archivos
        for (int i=0; i < archivos.length; i++)
            System.out.println(archivos[i]);


        File[] ficheros=f.listFiles();
        for (int i=0; i < ficheros.length; i++)
        {
            if (ficheros[i].isFile())
            {
                System.out.println("Fichero: " + archivos[i]);
                mostrarPropiedadesFichero(ficheros[i]);
            }
            else
                System.out.println("Directorio: " + archivos[i]);
        }
    }

    private static void mostrarPropiedadesSistema() {
        System.out.println("Propiedades del sistema");
        System.out.println("=======================");
        System.out.printf("Separador del sistema: %s%n", File.separator);
        System.out.printf("Directorio de trabajo: %s%n", new File("").getAbsolutePath());
    }

    private static void mostrarPropiedadesFichero(File fichero)
    {
        System.out.printf("Fecha �ltima modificaci�n: %s " +" - %s%n", new Date(fichero.lastModified()),fichero.lastModified());
        System.out.printf("Directorio? %s%n", fichero.isDirectory());
        System.out.printf("Fichero? %s%n", fichero.isFile());
        System.out.printf("Se puede escribir? %s%n", fichero.canWrite());
        System.out.printf("Se puede leer? %s%n", fichero.canRead());
        System.out.printf("Se puede ejecutar? %s%n", fichero.canExecute());
        System.out.printf("Ruta absoluta: %s%n", fichero.getAbsolutePath());
        System.out.printf("Nombre del directorio padre: %s%n",fichero.getParent());
        System.out.printf("Tamaño: %d%n", fichero.length());
    }
}
