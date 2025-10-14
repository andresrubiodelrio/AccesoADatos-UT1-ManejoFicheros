package ficherosjson;

import java.util.Objects;

public class Persona {
    private int id;
    private String nombre;
    private int edad;

    public Persona() {} // Constructor vacío requerido por Jackson

    public Persona(int id, String nombre, int edad) {
        setId(id);
        setNombre(nombre);
        setEdad(edad);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id<=0)
            throw new IllegalArgumentException("ERROR: No se puede establecer un id menor o igual a 0.");

        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if (nombre==null)
            throw new NullPointerException("ERROR: El nombre de una persona no puede ser nulo.");

        if (nombre.isBlank())
            throw new IllegalArgumentException("ERROR: El nombre de una persona no puede ser vacío.");

        this.nombre = nombre; }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad<1)
            throw new IllegalArgumentException("ERROR: La edad de una persona no puede ser inferior a 1.");

        this.edad = edad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return id == persona.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Persona{id=" + id + ", nombre='" + nombre + "', edad=" + edad + "}";
    }
}
