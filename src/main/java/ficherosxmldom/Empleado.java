package ficherosxmldom;

import java.util.Objects;

public class Empleado {
    private int id;
    private String apellido;
    private int departamento;
    private double salario;

    public Empleado(int id, String apellido, int departamento, double salario)
    {
        setId(id);
        setApellido(apellido);
        setDepartamento(departamento);
        setSalario(salario);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id<=0)
            throw new IllegalArgumentException("ERROR: No se puede establecer un identificador inferior a 1");

        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido==null)
            throw new NullPointerException("ERROR: No se puede establecer un apellido nulo.");

        if (apellido.isBlank())
            throw new IllegalArgumentException("ERROR: No se puede establecer una apellido vacio.");

        this.apellido = apellido;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        if (departamento<=0)
            throw new IllegalArgumentException("ERROR: No se puede establecer un departamento inferior a 1");

        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario<=0)
            throw new IllegalArgumentException("ERROR: No se puede establecer un salario inferior a 1");

        this.salario = salario;
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

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", departamento=" + departamento +
                ", salario=" + salario +
                '}';
    }
}
