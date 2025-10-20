package ficherosjsonnode;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class AgregarElementoArrayJsonNode {

    public static void main(String[] args) {

        try
        {
            // Crear ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Crear un nuevo objeto JSON para añadir al array
            ObjectNode nuevoEmpleado = mapper.createObjectNode();
            nuevoEmpleado.put("id", 54);
            nuevoEmpleado.put("apellido", "RAMOS");
            nuevoEmpleado.put("dep", 30);
            nuevoEmpleado.put("salario", 3100.0);

            // Leer el archivo JSON como JsonNode
            File jsonFile = new File("datos/json/empleados.json");
            JsonNode rootNode = mapper.readTree(jsonFile);

            // Verificar si es un ArrayNode (para añadir elementos al array)
            if (rootNode.isArray()) {
                ArrayNode arrayNode = (ArrayNode) rootNode;
                arrayNode.add(nuevoEmpleado);

                // Guardar el árbol modificado
                mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, rootNode);
                System.out.println("Empleado añadido.");

                System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode));
            }
        }
        catch (StreamReadException | DatabindException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
