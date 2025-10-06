package ficherosxmljdom2;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class EliminarXMLPersonas {
    public static void main(String[] args)  {

        try
        {
            // Leer el fichero XML existente
            File xmlFile = new File("datos/personas.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(xmlFile);

            // Obtener el elemento raíz <personas>
            Element raiz = document.getRootElement();

            // Buscar el nodo <persona> con el atributo id="1" y eliminarlo
            List<Element> personas = raiz.getChildren("persona");
            for (Element persona : personas) {
                if (persona.getAttributeValue("id").equals("1")) {
                    raiz.removeContent(persona);
                    System.out.println("Se eliminó el elemento con id=1");
                    break;
                }
            }

            // Buscar los nodos persona con la edad = 25 y eliminarlos
            Iterator<Element> iterator = raiz.getChildren("persona").iterator();
            while (iterator.hasNext()) {
                Element persona = iterator.next();
                if (persona.getChildText("edad").equals("25")) {
                    iterator.remove(); // Eliminar el nodo <persona>
                    System.out.println("Persona: " + persona.getChildText("nombre") + ", eliminada");
                }
            }

            // Guardar los cambios en el mismo fichero
            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileWriter(xmlFile));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IllegalNameException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IllegalDataException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IllegalAddException e)
        {
            System.out.println(e.getMessage());
        }
        catch(NullPointerException e)
        {
            System.out.println(e.getMessage());
        }
        catch (JDOMException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IllegalStateException e)
        {
            System.out.println(e.getMessage());
        }


    }
}
