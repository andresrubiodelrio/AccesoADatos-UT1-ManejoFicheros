package operacionesfile;

import java.io.File;

public class BorraDirectorio {
    public static void main(String[] args)
    {
        File f;
        String[] archivos;

        if (args.length>0) {
            String rutaDirectorio = args[0];
            //objeto File hacia la ruta del directorio padre si la ruta existe
            File d = new File(rutaDirectorio);
            if (d.exists()) {
                archivos = d.list(); //obtengo la lista de archivos

                for (int i = 0; i < archivos.length; i++)
                {
                    f = new File(d, archivos[i]); //objeto File hacia la ruta completa del archivo i-ésimo
                    if (!f.delete())
                    { //borra el archivo (se recibe true si la operación tiene éxito)
                        System.out.printf("\nNo se pudo borrar el fichero %s\n", f.getName());
                    }
                }
                //borra la ruta padre (no tendrá efecto si quedó algún fichero sin borrar)
                d.delete();
            }
            else
            {
                //si la ruta no existe
                System.out.printf("\nNo se encuentra el directorio %s\n", rutaDirectorio);
            }
        }
        else
            //si no se introdujo ningn argumento, muestra un ejemplo de uso
            System.out.println("\n\nEjemplo de uso:\nBorraDirectorio c:\\tmp");

    }


}
