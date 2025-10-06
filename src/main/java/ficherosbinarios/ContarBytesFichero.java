/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherosbinarios;

import java.io.*;

public class ContarBytesFichero {
	public static void main(String[] args)
	{
		int i,contadorBytes=0;
		File fichero = new File("C:" + File.separator + "tmp"+ File.separator + "FichBytes.dat");


		System.out.println("Leemos el contenido del fichero");
        FileInputStream filein = null;
        try
		{
           	filein = new FileInputStream(fichero);
			// visualizar los datos del fichero
			while ((i = filein.read()) != -1) // Lee bytes
				contadorBytes++;

			filein.close(); // cierra el flujo

			System.out.println("Fichero de " + contadorBytes + " Bytes");
        }
		catch (FileNotFoundException fn)
		{
			System.out.println("No se encuentra el fichero");
			System.out.println(fn.getMessage());
		}
		catch(IOException io)
		{
			System.out.println("Error de E/S");
			System.out.println(io.getMessage());
		}
	}
}