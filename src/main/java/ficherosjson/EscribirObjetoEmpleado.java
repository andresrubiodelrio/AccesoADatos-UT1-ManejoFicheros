package ficherosjson;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class EscribirObjetoEmpleado {
    public static void main(String[] args)  {
        // Instanciar ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        try
        {
            // Crear un mapa con datos
            Empleado empleado = new Empleado(33,"FRAILE",30, 3000.34);

            // Escribir el JSON en el fichero
            File jsonFile = new File("datos/json/salida.json");
            mapper.writeValue(jsonFile, empleado);

            //mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, empleado);

            System.out.println("Fichero creado.");
        }
        catch ( StreamWriteException | DatabindException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }


    }
}
