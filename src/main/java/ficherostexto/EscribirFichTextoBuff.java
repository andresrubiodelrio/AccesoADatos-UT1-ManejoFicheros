/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherostexto;

import java.io.*;

public class EscribirFichTextoBuff {
	public static void main(String[] args) 
	{
		File fichero = new File("c:" +File.separator + "tmp" +  File.separator +  "FichTexto2.txt");
		try 
		{
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);

			// BufferedWriter bw= new BufferedWriter(new FileWriter(fichero));

			for (int i = 1; i < 11; i++) {
				bw.write("Fila número: " + i); // escribe una línea
				bw.newLine();// salto de línea
			}

			bw.close();
			fw.close();
		} 
		catch (FileNotFoundException fn) 
		{
			System.out.println("No se encuentra el fichero");
			System.out.println(fn.getMessage());
		} 
		catch (IOException io) 
		{
			System.out.println("Error de E/S");
			System.out.println(io.getMessage());
		}
	}
}