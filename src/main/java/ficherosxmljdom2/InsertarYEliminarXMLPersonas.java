package ficherosxmljdom2;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class InsertarYEliminarXMLPersonas {
    public static void main(String[] args) {

        try
        {
            File xmlFile = new File("datos/personas.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(xmlFile);

            // Obtener el elemento raíz <personas>
            Element raiz = document.getRootElement();

            // Crear un nuevo nodo <persona>
            Element persona = new Element("persona");
            persona.setAttribute("id", "4");
            persona.addContent(new Element("nombre").setText("Pedro"));
            persona.addContent(new Element("edad").setText("25"));

            // Añadir el nuevo nodo <persona> al elemento raíz
            raiz.addContent(persona);
            System.out.println("id=4 Añadido");

            // ELIMINAR EL id 1
            // Buscar el nodo <persona> con el atributo id="1" y eliminarlo
            List<Element> personas = raiz.getChildren("persona");
            for (Element personaABorrar : personas) {
                if (personaABorrar.getAttributeValue("id").equals("1")) {
                    raiz.removeContent(personaABorrar);
                    System.out.println("id=1 Eliminado");
                    break;
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
