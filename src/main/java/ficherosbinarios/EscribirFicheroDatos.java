/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherosbinarios;

import java.io.*;

public class EscribirFicheroDatos {
	
	public static void main(String[] args) 
	{
		File fichero = new File("c:" + File.separator + "tmp" + File.separator + "FichData.dat");

		try 
		{
			// Creamos el flujo de salida
			FileOutputStream fileout = new FileOutputStream(fichero);

			// Indicamos que se trata de un flujo de salida para escribir datos primitivos
			DataOutputStream dataOS = new DataOutputStream(fileout);

			String [] nombres = { "Ana", "Luis Miguel", "Alicia", "Pedro", "Manuel", "Andrés", "Mariano", "José Ramón",
					"María Jesús" };

			int [] edades = { 24, 25, 23, 25, 26, 22, 26, 24, 23 };

			for (int i = 0; i < edades.length; i++) {

				dataOS.writeUTF(nombres[i]); // inserta nombre

				dataOS.writeInt(edades[i]); // inserta edad
			}

			dataOS.close(); // cierra flujo
			fileout.close();
		} 
		catch (FileNotFoundException ex) 
		{
			System.out.println("Fichero no encontrado");
			ex.getMessage();
		} 
		catch (IOException ex) 
		{
			System.out.println("Error de I/O");
			ex.getMessage();
		}

	}
}