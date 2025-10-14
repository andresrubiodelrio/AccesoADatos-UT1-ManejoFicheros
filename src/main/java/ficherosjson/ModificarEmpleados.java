package ficherosjson;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.iesalandalus.programacion.utilidades.Entrada;

import javax.xml.stream.events.EntityReference;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ModificarEmpleados {

    public static void main(String[] args) {

        // Crear el ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        try
        {
            // Leer el JSON como una lista de objetos Empleado
            File jsonFile = new File("datos/json/empleados.json");
            List<Empleado> empleados = mapper.readValue(jsonFile, new TypeReference<List<Empleado>>() {
            });

            System.out.print("Introduce el identificador del empleado a modificar el sueldo: ");
            int id= Entrada.entero();
            System.out.println("Introduce la cantidad a incrementar en el sueldo del empleado con id=" + id);
            double sueldo= Entrada.realDoble();
            // ---- MODIFICAR UN EMPLEADO - con ID --
            for (Empleado empleado : empleados) {
                if (empleado.getId() == id) {
                    empleado.setSalario(empleado.getSalario() + sueldo);
                }
            }

            // ---- AÑADIR UN NUEVO EMPLEADO ----
            Empleado nuevoEmpleado = new Empleado(60, "LOPEZ", 40, 1800.0);
            if (empleados.contains(nuevoEmpleado))
                System.out.println("Ese empleado ya existe.");
            else
                empleados.add(nuevoEmpleado);

            // ---- ELIMINAR UN EMPLEADO con ID ----
            System.out.print("Introduce el identificador del empleado a eliminar: ");
            id= Entrada.entero();

//            for(Empleado empleado:empleados)
//            {
//                if (empleado.getId()==id)
//                    empleados.remove(empleado);
//            }

            Iterator<Empleado> iterator = empleados.iterator();
            while (iterator.hasNext()) {
                Empleado empleado = iterator.next();
                if (empleado.getId() == id) {
                    iterator.remove();
                }
            }

            // Guardar los cambios de vuelta al fichero JSON
            mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, empleados);

            System.out.println("Modificaciones realizadas y guardadas en empleados.json.");
        }
        catch (StreamReadException | StreamWriteException | DatabindException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }


    }
}
