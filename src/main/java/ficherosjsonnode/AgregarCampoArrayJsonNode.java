package ficherosjsonnode;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.File;
import java.io.IOException;

public class AgregarCampoArrayJsonNode {
    public static void main(String[] args)
    {
        try {
            // Crear ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Leer el fichero JSON como JsonNode
            File jsonFile = new File("datos/json/empleados.json");
            JsonNode rootNode = mapper.readTree(jsonFile);

            // Verificar si el JSON es un array
            if (rootNode.isArray())
            {
                ArrayNode arrayNode = (ArrayNode) rootNode;
                System.out.print("Introduce el identificador del empleado a modificar: ");
                int id= Entrada.entero();
                // Recorrer los elementos del array
                for (JsonNode node : arrayNode) {
                    // Buscar el elemento con "id"
                    if (node.get("id").asInt() == id) {
                        // Convertir el elemento en ObjectNode para modificarlo
                        ObjectNode empleado = (ObjectNode) node;
                        System.out.println("Introduce la ciudad del empleado: ");
                        String ciudad=Entrada.cadena();
                        // Añadir el nuevo campo "ciudad"
                        empleado.put("ciudad", ciudad);

                        System.out.println("Campo añadido al elemento con id=" + id);
                    }
                }

                // Guardar los cambios en el fichero
                mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, arrayNode);

                System.out.println("Fichero modificado y guardado.");
                System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode));
            }
        }
        catch (StreamWriteException | DatabindException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }



    }
}
