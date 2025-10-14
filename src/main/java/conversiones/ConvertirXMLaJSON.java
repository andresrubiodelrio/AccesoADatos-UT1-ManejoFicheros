package conversiones;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ConvertirXMLaJSON {

    public static void main(String[] args) {

        try
        {
            // Leer el fichero XML
            XmlMapper xmlMapper = new XmlMapper();
            File xmlFile = new File("datos/xml/libros.xml");

            // Convertir XML a Map
            Map<String, Object> map = xmlMapper.readValue(xmlFile, Map.class);

            // Convertir el Map a JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);

            System.out.println(json);// Mostrar el JSON

            // Escribir datos en un fichero JSON
            File jsonFile = new File("datos/json/libros.json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, map);
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
