package ficherosjsonnode;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class AgregarCampoJsonNode {

    public static void main(String[] args) {
        // Crear ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        try
        {
            // Leer el archivo JSON como JsonNode
            File jsonFile = new File("datos/json/persona.json");
            JsonNode rootNode = mapper.readTree(jsonFile);

            // Verificar si es un ObjectNode (para añadir campos)
            if (rootNode.isObject()) {
                ObjectNode objectNode = (ObjectNode) rootNode;

                // Añadir dos nuevos campos al JSON
                objectNode.put("edad", 55);
                objectNode.put("ciudad", "Almería");

                // Guardar los cambios en el archivo
                mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, objectNode);

                System.out.println("Elemento añadido al JSON.");

                System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode));

            }
        }
        catch (StreamWriteException | DatabindException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }


    }
}
