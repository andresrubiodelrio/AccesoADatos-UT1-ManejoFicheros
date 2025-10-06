package ficherosxmljdom2;

import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class CrearXMLPersonas {
    public static void main(String[] args)  {

        try
        {
            // Crear el elemento raíz
            Element root = new Element("personas");

            // Añadir elementos hijos
            Element p1 = new Element("persona");
            p1.setAttribute("id", "1");
            p1.addContent(new Element("nombre").setText("Juan"));
            p1.addContent(new Element("edad").setText("30"));
            root.addContent(p1);

            Element p2 = new Element("persona");
            p2.setAttribute("id", "2");
            p2.addContent(new Element("nombre").setText("Ana"));
            p2.addContent(new Element("edad").setText("25"));
            root.addContent(p2);

            // Crear el documento
            Document document = new Document(root);

            // Guardar en un archivo
            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileWriter("datos/personas.xml"));

            System.out.println("Fichero XML creado.");

            String salida = xmlOutputter.outputString(document);
            System.out.println(salida);
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

    }
}
