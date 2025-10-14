package ficherosjsonnode;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class ModificarSalarioEmpleadosJsonNode {
    public static void main(String[] args) {
        try
        {
            // Crear ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Leer el fichero JSON como JsonNode
            File jsonFile = new File("datos/json/empleados.json");
            JsonNode rootNode = mapper.readTree(jsonFile);

            // Verificar si el JSON es un array
            if (rootNode.isArray()) {
                ArrayNode arrayNode = (ArrayNode) rootNode;

                // Recorrer los elementos del array
                for (JsonNode node : arrayNode) {
                    // Convertir cada elemento en ObjectNode
                    ObjectNode empleado = (ObjectNode) node;

                    // Obtener el salario actual y sumarle 100
                    double salarioActual = empleado.get("salario").asDouble();
                    empleado.put("salario", salarioActual + 100);
                }

                // Guardar los cambios en el fichero
                mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, arrayNode);

                System.out.println("Salario Modificado.");

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
