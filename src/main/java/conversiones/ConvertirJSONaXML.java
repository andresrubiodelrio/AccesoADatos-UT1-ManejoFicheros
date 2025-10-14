package conversiones;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class ConvertirJSONaXML {

    public static void main(String[] args) {

        try
        {
            // Crear ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            File jsonFile = new File("datos/json/libros.json");
            JsonNode jsonNode = mapper.readTree(jsonFile); // Convertir JSON a JsonNode

            // Crear XmlMapper para manejar XML
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode); // Convertir JsonNode a
            // XML

            System.out.println("XML generado:\n" + xml);

            // crear el fichero
            File xmlFile = new File("datos/xml/librosnuevo.xml");
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(xmlFile, jsonNode);
        }
        catch (DatabindException | StreamReadException | StreamWriteException e )
        {
            System.out.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
