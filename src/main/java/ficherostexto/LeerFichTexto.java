
package ficherostexto;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeerFichTexto {
	public static void main(String[] args)
	{
		// declarar fichero Opción 1
		File fichero = new File("C:"+ File.separator + "tmp" + File.separator + "FichTexto.txt");
		
		FileReader fr;
		try 
		{
			fr = new FileReader(fichero); // crea el flujo de entrada
			
			int i;

			
			/* while ((i=fr.read())!=-1 ) //se va leyendo un carácter
			 System.out.print((char)i);*/
			

			// Usando un array de carácteres
			char[] b = new char[10];
			while (fr.read(b) != -1)
				System.out.print(b);

			fr.close(); // cerrar el flujo

		} 
		catch (FileNotFoundException ex) 
		{
			System.out.println("Fichero no encontrado");
			System.out.println(ex.getMessage());
		} 
		catch (IOException ex)
		{
			System.out.println("Error de I/O");
			System.out.println(ex.getMessage());
		}

	}
}