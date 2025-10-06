
package ficherostexto;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EscribirFichTexto {
	public static void main(String[] args)
	{

		
		File fichero = new File("C:" +File.separator + "tmp" + File.separator + "FichTexto.txt");

		FileWriter fw;
		try {
			 fw = new FileWriter(fichero); //crear el flujo de salida para sobreescribir a partir de un objeto File
			//fw = new FileWriter(fichero, true); // crear el flujo de salida para añadir
			
		
			String cadena = "Esto es una prueba con FileWriter ";			

			//Escribimos caracter a caracter usando la variable de tipo String
			for (int i = 0; i < cadena.length(); i++)
				fw.write(cadena.charAt(i)); // se va escribiendo un caracter
			
			//Escribimos caracter a caracter usando el array de caracteres
			//Para ello se convierte un String en array de caracteres
			char[] cad = cadena.toCharArray(); 
			
			for (int i = 0; i < cad.length; i++)
				fw.write(cad[i]); // se va escribiendo un caracter

			
			// Otras opciones a la hora de escribir sobre un fichero de carácteres
			fw.write(cad);
			fw.write(cadena);
			

			fw.append('*');

			fw.close();
			
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