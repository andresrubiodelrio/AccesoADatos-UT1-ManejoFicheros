/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherosbinarios.ficherosobjeto;

import java.io.*;
import java.io.Serializable;

public class Persona implements Serializable {
	
	private String nombre;
	private int edad;

	public Persona(String nombre, int edad) {
		setNombre(nombre);
		setEdad(edad);
	}	

	public void setNombre(String nombre) 
	{
		if (nombre==null)
			throw new NullPointerException("ERROR: No se puede establecer un nombre nulo.");
		
		if (nombre.isEmpty() || nombre.isBlank())
			throw new IllegalArgumentException("ERROR: No se puede establecer un nombre vac?o.");
		
		this.nombre = nombre;
	}

	public void setEdad(int edad) 
	{
		if (edad<=0)
			throw new IllegalArgumentException("ERROR: No se puede establecer una edad negativa.");
		
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + edad;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (edad != other.edad)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", edad=" + edad;
	}
	
	
}
