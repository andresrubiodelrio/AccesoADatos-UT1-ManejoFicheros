
package ficherostexto;

import java.io.*;

public class EscribirFichTextoPrintWriter {
	public static void main(String[] args)
	{

		
		File fichero = new File("C:" +File.separator + "tmp" + File.separator + "FichTextoPrintWriter.txt");

		PrintWriter pw;
		try {
			 pw = new PrintWriter(fichero); //crear el flujo de salida para sobreescribir a partir de un objeto File

			for (int i = 1; i < 11; i++) {
				pw.println("Fila número: " + i); // escribe una línea
			}

			pw.close();

		} 
		catch (FileNotFoundException ex) 
		{
			System.out.println("Fichero no encontrado");
			System.out.println(ex.getMessage());
		} 

	}
}