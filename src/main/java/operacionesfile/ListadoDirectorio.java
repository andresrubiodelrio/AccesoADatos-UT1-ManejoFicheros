
package operacionesfile;

        
//librerías necesarias
import java.io.File;

/**
 * ****************************************************************************
 * muestra los ficheros del directorio pasado como parámetro desde la línea de
 * comandos
 *
 * @author IMCG
 */
public class ListadoDirectorio {

  /**
   * @param args argumentos de la línea de comandos
   */
  public static void main(String[] args)
  {

    //variables locales
    String ruta;
    File nombre;
    String[] directorio;

    //si se introdujo algún argumento
    if (args.length > 0)
    {
        //anota como ruta el primero de ellos
        ruta = args[0];
     
      
        //apunta un objeto File hacia la ruta especificada
        nombre = new File(ruta);

        //si la ruta existe y es un directorio
        if (nombre.exists() && nombre.isDirectory())
        {
            //anota su contenido en el array de cadenas
            directorio = nombre.list();
            System.out.printf("\n\nContenido de %s:\n\n", ruta);

            //para cada elemento del array
            for (String nombreDirectorio : directorio)
            {
              //lo imprime en la Salida terminado en un retorno de carro
              System.out.printf("%s\n", nombreDirectorio);
            }
        }
        else
        {
            //si la ruta no existe o no es un directorio
            System.out.printf("\n\n%s %s", ruta, "no es una carpeta\n");
        }
    }
    else
    {
        //si no se introdujo ningún argumento, muestra un ejemplo de uso
        System.out.println("\n\nEjemplo de uso:\nListadoDirectorio c:\\tmp");
    }
    
    //línea en blanco
    System.out.println();
  }
}

  
        
        
        
        
        
        
        
   