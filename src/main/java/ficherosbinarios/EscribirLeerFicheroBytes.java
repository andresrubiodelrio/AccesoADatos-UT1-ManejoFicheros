/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherosbinarios;

import java.io.*;

public class EscribirLeerFicheroBytes {
	public static void main(String[] args)
	{
		File fichero = new File("C:" + File.separator + "tmp"+ File.separator + "FichBytes.dat");

		// Crea un flujo de salida sin sobreescritura
		FileOutputStream fileout = null;
		try {
			fileout = new FileOutputStream(fichero, true);

			int i;
			for (i = 1; i < 100; i++)
				fileout.write(i); // escribe bytes

			fileout.close(); // cierra el flujo
		
			// Crea flujo de entrada
			System.out.println("Fichero escrito correctamente");
			System.out.println("Leemos el contenido del fichero");
			FileInputStream filein = new FileInputStream(fichero);

			// visualizar los datos del fichero
			while ((i = filein.read()) != -1) // Lee bytes
				System.out.println(i);

			filein.close(); // cierra el flujo
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