package ficherosjsonnode;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ModificarEliminarEmpleadosJsonNode {

    public static void main(String[] args) {

        try
        {
            // Crear ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Leer el archivo JSON como un árbol (JsonNode)
            File jsonFile = new File("datos/json/empleados.json");
            JsonNode rootNode = mapper.readTree(jsonFile);

            System.out.print("Introdcue el identificador del empleado a eliminar: ");
            int idEliminar=Entrada.entero();

            System.out.print("Introduce el identificador del empleado a modificar su salario y su apellido:");
            int id= Entrada.entero();

            Iterator<JsonNode> iterator = rootNode.elements();
            while (iterator.hasNext()) {
                JsonNode empleado = iterator.next();

                // Modificar datos
                if (empleado.get("id").asInt() ==id) {
                    System.out.println("Introduce el nuevo salario del empleado cuyo id=" + id);
                    double nuevoSalario=Entrada.realDoble();
                    System.out.println("Introduce el nuevo apellido del empleado cuyo id=" + id);
                    String nuevoApellido=Entrada.cadena();
                    ((ObjectNode) empleado).put("salario", nuevoSalario);
                    ((ObjectNode) empleado).put("apellido", nuevoApellido);
                }

                // Eliminar empleado con ID
                if (empleado.get("id").asInt() == idEliminar) {
                    iterator.remove();
                }
            }
            // Guardar el árbol modificado
            mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, rootNode);
            System.out.println("Fichero modificado con JsonNode.");
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
