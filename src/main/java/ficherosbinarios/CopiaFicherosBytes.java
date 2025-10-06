package ficherosbinarios;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class CopiaFicherosBytes {

    public static void main(String[] args) {
        int i;
        String sobreEscribir="";
        if (args.length==2)
        {
            File fuente=new File (args[0]);
            File destino=new File(args[1]);

            if (destino.exists())
            {
                do{
                    System.out.println("El fichero destino ya existe. Desea sobreescribirlo (s/n):");
                    sobreEscribir= Entrada.cadena();

                }while (!sobreEscribir.equalsIgnoreCase("s") && !sobreEscribir.equalsIgnoreCase("n"));
            }

            if (!destino.exists() || (destino.exists() && sobreEscribir.equalsIgnoreCase("s")))
            {
                try
                {
                    FileInputStream fis=new FileInputStream(fuente);
                    FileOutputStream fos=new FileOutputStream(destino);

                    while ((i=fis.read())!=-1)
                    {
                        fos.write(i);
                    }

                    fis.close();
                    fos.close();
                    System.out.println("Fichero " + args[0] + " copiado correctamente al fichero " + args[1]);
                }
                catch (FileNotFoundException e)
                {
                    System.out.println(e.getMessage());
                }
                catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        else
        {
            //si no se introdujo ning�n argumento, muestra un ejemplo de uso
            System.out.println("\n\nEjemplo de uso:\nCopiaFicherosBytes c:\\fuente.dat c:\\destino.dat");
        }
    }
}
