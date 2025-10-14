package ficherosjsonnode;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LeerEmpleadosJsonNode {

    public static void main(String[] args) {

        try
        {
            // Crear ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Leer el archivo JSON como JsonNode
            File jsonFile = new File("datos/json/empleados.json");
            JsonNode rootNode = mapper.readTree(jsonFile);

            for (JsonNode node : rootNode) {
                // Leer los campos del nodo
                int id = node.get("id").asInt(); // Leer "id" como int
                String apellido = node.get("apellido").asText(); // Leer "apellido" como String
                int dep = node.get("dep").asInt();
                double salario = node.get("salario").asDouble(); // Leer "salario" como double

                // Mostrar los valores leídos
                System.out.println("==========================");
                System.out.println("Datos de un nuevo empleado");
                System.out.println("==========================");
                System.out.println("ID: " + id);
                System.out.println("Apellido: " + apellido);
                System.out.println("Departamento: " + dep);
                System.out.println("Salario: " + salario+"\n");

                //PROBANDO JsonNode, obtiene el valor del campo
//                JsonNode id2 = node.get("id"); //ID2: 44
//                System.out.println("ID2: " + id2);
//                JsonNode apellido2 = node.get("apellido");
//                System.out.println("Apellido2: : " + apellido2); //Apellido2: : "SABINA"



            }
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
