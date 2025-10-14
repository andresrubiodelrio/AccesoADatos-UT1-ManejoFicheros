package ficherosxmljdom2;

import org.iesalandalus.programacion.utilidades.Entrada;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ModificarXMLPersonas {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("datos/xml/personas.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(xmlFile);

            // Obtener el elemento raíz
            Element raiz = document.getRootElement();

            // Buscar el nodo <persona> con el atributo id="1"
            System.out.print("Introduce el identificador (id) de la persona a modificar su nombre: ");
            String identificador= Entrada.cadena();

            Element elementoPersonaAModificar = null;
            for (Element elementoPersona : raiz.getChildren("persona")) {
                if (elementoPersona.getAttributeValue("id").equals(identificador)) {
                    elementoPersonaAModificar = elementoPersona;
                    break;
                }
            }

            if (elementoPersonaAModificar != null) {
                System.out.print("Introduce el nuevo nombre de la persona con identificador id=" + identificador + ": ");
                String nuevoNombre=Entrada.cadena();

                // Modificar el texto del nodo <nombre>
                elementoPersonaAModificar.getChild("nombre").setText(nuevoNombre);
                System.out.println("Modificación realizada al elemento nombre de la persona con identificador id=" + identificador);
            } else {
                System.out.println("No se encontró a la persona con el id=" + identificador);
            }


            System.out.print("Introduce la edad de las personas a modificar: ");
            String edad=Entrada.cadena();
            System.out.print("Introduce la nueva edad de las personas a modificar: ");
            String nuevaEdad=Entrada.cadena();
            //Buscar los nodos persona con la edad = 25 y modificarlos
            for (Element elementoPersona : raiz.getChildren("persona")) {
                if(elementoPersona.getChildText("edad").equals(edad)) {
                    elementoPersona.getChild("edad").setText(nuevaEdad);
                    System.out.println("Modificaciones de la edad realizadas.");
                }
            }

            //AÑADIR CONTENIDO A UN NODO EXISTENTE
            for (Element persona : raiz.getChildren("persona")) {
                if(persona.getChildText("nombre").equals("Ana")) {
                    persona.addContent(new Element("oficio").setText("Directora"));
                    System.out.println("Se ha añadido un nodo.");
                }
            }

            // Guardar los cambios en el mismo archivo
            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileWriter("datos/xml/modificacionPersonas.xml"));

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
