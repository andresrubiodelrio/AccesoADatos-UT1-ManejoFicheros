/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherosbinarios;

import java.io.*;

public class LeerFicheroDatos {

	public static void main(String[] args) // throws IOException
	{

		File fichero = new File("c:" + File.separator + "tmp" + File.separator + "FichData.dat");

		try 
		{
			// Creamos el flujo de entrada
			FileInputStream filein = new FileInputStream(fichero);

			// Indicamos que se trata de un flujo de entrada para leer datos primitivos
			DataInputStream dataIS = new DataInputStream(filein);

			String nombre;
			int edad;

			try 
			{
				while (true) 
				{
					nombre = dataIS.readUTF(); // recupera el nombre
					edad = dataIS.readInt(); // recupera la edad
					System.out.println("Nombre: " + nombre + ", edad: " + edad);
				}
			} 
			catch (EOFException eo) 
			{
				System.out.println("Fichero leído correctamente");
				dataIS.close(); // cierra flujo
			}
			
			filein.close();
			dataIS.close();
			
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
