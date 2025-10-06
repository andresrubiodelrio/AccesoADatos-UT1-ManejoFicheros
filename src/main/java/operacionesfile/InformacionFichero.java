package operacionesfile;

import java.io.File;

public class InformacionFichero {
    public static void main(String[] args) {


        //si se introdujo algun argumento
        if (args.length > 0) {
            File f = new File(args[0]);
            if (f.exists() && f.isFile()) {
                System.out.println("Información sobre el fichero");
                System.out.println("============================\n");
                System.out.println("Nombre del fichero: " + f.getName());
                System.out.println("Ruta absoluta: " + f.getAbsolutePath());
                System.out.println("Nombre del directorio padre: " + f.getParent());
                System.out.println("Se puede leer: " + f.canRead());
                System.out.println("Se puede escribir: " + f.canWrite());
                System.out.println("Tamaño: " + f.length());
                System.out.println("Es un directorio: " + f.isDirectory());
                System.out.println("Es un fichero: " + f.isFile());
            }
            else
                System.out.println("ERROR: La ruta indicada como parámetro o no se trata de un fichero o dicho fichero no existe.");
        }
        else
        {
            //si no se introdujo ning�n argumento, muestra un ejemplo de uso
            System.out.println("\n\nEjemplo de uso:\nInformacionFichero c:\\ejemplo.txt");
        }
    }

}
