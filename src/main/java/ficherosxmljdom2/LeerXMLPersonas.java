package ficherosxmljdom2;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;

public class LeerXMLPersonas {
    public static void main(String[] args)  {

        try
        {
            // Cargar el fichero XML
            File file = new File("datos/xml/personas.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(file);

            // Obtener el elemento raíz
            Element raiz = document.getRootElement();
            System.out.println("Elemento raíz: " + raiz.getName());

            // Recorrer los elementos hijos
            for (Element persona : raiz.getChildren("persona")) {
                String id = persona.getAttributeValue("id");
                String nombre = persona.getChildText("nombre");
                String edad = persona.getChildText("edad");

                System.out.printf("Id: %s, Nombre: %s, Edad: %s %n", id, nombre, edad);
            }
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
