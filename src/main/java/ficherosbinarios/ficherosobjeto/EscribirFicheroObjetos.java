
package ficherosbinarios.ficherosobjeto;

import java.io.*;

public class EscribirFicheroObjetos
{
	public static void main(String[] args) 
	{
		Persona persona; // define la variable persona
		
		File fichero = new File("datos/FichPersona.dat"); // fichero
		
		try 
		{
			// Creamos el flujo de salida
			FileOutputStream fileout = new FileOutputStream(fichero);
		 
			// Indicamos que se trata de un flujo de salida para escribir objetos
			ObjectOutputStream oOS = new ObjectOutputStream(fileout);

			String nombres[] = { "Ana", "Luis Miguel", "Alicia", "Pedro", "Manuel", "Andrés", "Mariano", "José Ramón",
				"María Jesús" };
		
			int edades[] = { 24, 25, 23, 25, 26, 22, 26, 24, 23 };

			for (int i = 0; i < edades.length; i++) 
			{
				persona = new Persona(nombres[i], edades[i]);// Crea objeto persona
				oOS.writeObject(persona); // se escribe objeto persona
			}
		
			oOS.close(); // cierra flujo de salida
			fileout.close();
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
