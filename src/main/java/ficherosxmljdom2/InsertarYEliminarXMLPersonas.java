package ficherosxmljdom2;

import org.iesalandalus.programacion.utilidades.Entrada;
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
        boolean encontrado=false;

        try
        {
            File xmlFile = new File("datos/xml/personas.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(xmlFile);

            // Obtener el elemento raíz <personas>
            Element raiz = document.getRootElement();

            // Crear un nuevo nodo <persona>
            Element persona=creaNuevoElemento();

            if (existePersona(raiz, persona.getAttributeValue("id")))
            {
                System.out.println("El elemento a añadir ya existe en el fichero.");
            }
            else {
                // Añadir el nuevo nodo <persona> al elemento raíz
                raiz.addContent(persona);
                System.out.println("La nueva persona ha sido añadida.");
            }

            // ELIMINAR
            // Buscar el nodo <persona> con el atributo id y eliminarlo
            System.out.print("Introduce el indentificador de la persona a eliminar: ");
            String identificador= Entrada.cadena();
            List<Element> personas = raiz.getChildren("persona");
            for (Element personaABorrar : personas) {
                if (personaABorrar.getAttributeValue("id").equals(identificador)) {
                    raiz.removeContent(personaABorrar);
                    System.out.println("Persona con id=" + identificador + " eliminada.");
                    encontrado=true;
                    break;
                }
            }

            if (!encontrado)
                System.out.println("La persona con identificador id=" + identificador + " no ha sido encontrada. Por tanto, " +
                        "no ha sido eliminada. ");

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

    private static Element creaNuevoElemento()
    {
        Element persona = new Element("persona");

        System.out.print("Introduce el identificador de la persona: ");
        String id=Entrada.cadena();
        persona.setAttribute("id", id);
        System.out.print("Introduce el nombre de la persona: ");
        String nombre=Entrada.cadena();
        System.out.print("Introduce la edad de la persona: ");
        String edad=Entrada.cadena();
        persona.addContent(new Element("nombre").setText(nombre));
        persona.addContent(new Element("edad").setText(edad));

        return persona;
    }

    private static boolean existePersona(Element raiz, String id)
    {
        boolean encontrado=false;
        for(Element persona: raiz.getChildren("persona"))
        {
            if (persona.getAttributeValue("id").equals(id)) {
                encontrado = true;
                break;
            }
        }

        return encontrado;
    }
}
