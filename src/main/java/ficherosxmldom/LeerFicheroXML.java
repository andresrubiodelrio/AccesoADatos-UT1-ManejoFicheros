package ficherosxmldom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class LeerFicheroXML {

    public static void main(String[] args) {
        leerXML("datos/empleados.xml");
    }

    private static void leerXML(String rutaXml)
    {
        //Creamos DOM a partir de XML
        Document doc=null;
        try {
            // Creamos una nueva instancia de un fabrica de constructores de documentos.
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // A partir de la instancia anterior, fabricamos un constructor de documentos, que procesara el XML.
            DocumentBuilder db = dbf.newDocumentBuilder();
            //Procesamos el documento (almacenado en un archivo) y lo convertimos en un arbol DOM.
            doc=db.parse(rutaXml);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        if (doc==null)
        {
            System.out.println("No se ha podido leer el fichero ");
        }
        else
        {
            Element raizDOM = doc.getDocumentElement();

            //Recorremos la lista de nodos del DOM
            NodeList listaNodos=raizDOM.getElementsByTagName("empleado");

            if (listaNodos.getLength()>0) {
                System.out.println("Datos de los empleados:");
                System.out.println("=======================");

                for (int i=0; i<listaNodos.getLength();i++)
                {
                    Node nodo=listaNodos.item(i);

                    if(nodo.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element empleadoDOM = (Element) nodo;
                        Empleado empleado=elementToEmpleado(empleadoDOM);
                        System.out.println(empleado);
                    }
                }

                System.out.println("Fichero de empleados leido correctamente.");
            }
            else
                System.out.println("No hay datos de empleados en el fichero xml proporcionado");

        }
    }

    private static Empleado elementToEmpleado(Element empleadoDOM)
    {
        int aId = Integer.parseInt(empleadoDOM.getAttribute("id"));
        Element eApellido = (Element) empleadoDOM.getElementsByTagName("apellido").item(0);
        Element eDepartamento = (Element) empleadoDOM.getElementsByTagName("dep").item(0);
        Element eSalario = (Element) empleadoDOM.getElementsByTagName("salario").item(0);

        String aApellido = eApellido.getTextContent();
        int aDepartamento= Integer.parseInt(eDepartamento.getTextContent());
        double aSalario = Double.parseDouble(eSalario.getTextContent());

        return new Empleado(aId, aApellido, aDepartamento, aSalario);
    }
}
