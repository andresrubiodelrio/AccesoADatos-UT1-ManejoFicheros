package ficherosjson;

import java.util.Objects;

public class Empleado {

    private int id;
    private String apellido;
    private int dep;
    private double salario;

    public Empleado() {} // Constructor vacío requerido por Jackson

    public Empleado(int id, String apellido, int dep, double salario) {
        setId(id);
        setApellido(apellido);
        setDep(dep);
        setSalario(salario);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id<=0)
            throw new IllegalArgumentException("ERROR: No se puede asignar un identificador menor que 1.");

        this.id = id;
    }

    public String getApellido() {

        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido==null)
            throw new NullPointerException("ERROR: El apellido de un empleado no puede ser nulo.");

        if (apellido.isBlank())
            throw new IllegalArgumentException("ERROR: El apellido de un empleado no puede ser vacío.");

        this.apellido = apellido;
    }

    public int getDep() {
        return dep;
    }

    public void setDep(int dep) {
        if (dep<=0)
            throw new IllegalArgumentException("ERROR: No se puede asignar un departamento menor que 1.");

        this.dep = dep;
    }

    public double getSalario() {

        return salario;
    }

    public void setSalario(double salario) {
        if (salario<=0)
            throw new IllegalArgumentException("ERROR: No se puede asignar un salario menor que 1.");

        this.salario = salario;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Apellido: %s, Departamento: %d, Salario: %,9.2f", id, apellido, dep,
                salario);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empleado empleado)) return false;
        return id == empleado.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
