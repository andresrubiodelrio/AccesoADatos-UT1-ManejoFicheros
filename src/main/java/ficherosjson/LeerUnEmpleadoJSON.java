package ficherosjson;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class LeerUnEmpleadoJSON {

    static File jsonFile = new File("datos/json/unempleado.json");

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try
        {
            // Leer fichero JSON y mapearlo a un Map
            Map<String, Object> json = mapper.readValue(jsonFile, Map.class);
            System.out.println("Contenido del JSON como mapa: \t" + json + "\n");

            // Leer fichero JSON y mapearlo a un objeto Empleado
            Empleado empleado = mapper.readValue(jsonFile, Empleado.class);
            System.out.print("Objeto Empleado: \t" +empleado + "\n");
        }
        catch (StreamReadException | DatabindException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }


    }


}
