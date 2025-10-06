package ficherosxmldom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EscribirFicheroXML {
    private static List<Empleado> coleccionEmpleados=new ArrayList<>();

    public static void main(String[] args)
    {

        creaListaEmpleados();

        //Creamos documento con el arbol DOM solo con el elemento raiz
        Document DOMEmpleados=crearDomVacio("empleados");

        Element raizDOM = DOMEmpleados.getDocumentElement();

        //Convertimos cada objeto empledo en un elemento empleado que se anade al documento del arbol DOM
        if (!coleccionEmpleados.isEmpty())
        {
            for (Empleado empleado : coleccionEmpleados)
            {
                Element empleadoDOM = empleadoToElement(DOMEmpleados, empleado);
                raizDOM.appendChild(empleadoDOM);
            }
        }

        //Convertimos nuestro arbol DOM en un fichero xml
        domToXml(DOMEmpleados, "datos/empleados_nuevos.xml");

    }

    private static void creaListaEmpleados()
    {
        coleccionEmpleados.add(new Empleado(1,"FERNANDEZ",10,1000.45));
        coleccionEmpleados.add(new Empleado(2,"GIL",20,2400.6));
        coleccionEmpleados.add(new Empleado(3,"LOPEZ",10,3000.0));
    }


    private static Document crearDomVacio(String etiquetaRaiz)
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        Document doc = null ;
        try {
            db = dbf.newDocumentBuilder() ;
            doc = db.newDocument();
            Element elementoRaiz=doc.createElement(etiquetaRaiz);
            doc.appendChild(elementoRaiz);
            return doc;
        } catch (ParserConfigurationException ex) {
            System.out.println(ex.getMessage());
        }
        return doc ;
    }

    private static Element empleadoToElement(Document DOMEmpleados, Empleado empleado)
    {
        Element empleadoDOM = DOMEmpleados.createElement("empleado");
        empleadoDOM.setAttribute("id", String.valueOf(empleado.getId()));

        Element eApellido = DOMEmpleados.createElement("apellido");
        eApellido.setTextContent(empleado.getApellido());
        empleadoDOM.appendChild(eApellido);
        Element eDepartamento = DOMEmpleados.createElement("departamento");
        eDepartamento.setTextContent(String.valueOf(empleado.getDepartamento()));
        empleadoDOM.appendChild(eDepartamento);
        Element eSalario = DOMEmpleados.createElement("salario");
        eSalario.setTextContent(String.valueOf(empleado.getSalario()));
        empleadoDOM.appendChild(eSalario);

        return empleadoDOM;
    }


    private static boolean domToXml (Document DOM, String rutaXml)
    {
        try
        {
            File f=new File(rutaXml);

            FileOutputStream fos =new FileOutputStream(f);

            //Creamos la fuente del fichero XML
            DOMSource source = new DOMSource(DOM);
            //Creamos el StreamResult, que intermediarIO entre el transformador y el archivo de destino.
            StreamResult result = new StreamResult(new OutputStreamWriter(fos,"UTF-8"));

            // Creamos un objeto transformer que transformara el DOM en el fichero xml
            //Creamos una fabrica de transformadores de DOM
            TransformerFactory tFactory=TransformerFactory.newInstance();

            //Establecemos algunas opciones de salida, como por ejemplo, la codificaci�n de salida.
            tFactory.setAttribute("indent-number", Integer.valueOf(4));
            Transformer transformer = tFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            //Transformamos el arbol DOM en un fichero xml
            transformer.transform(source, result);
            System.out.printf("Fichero %s escrito correctamente.%n", rutaXml);
            return true;
        }
        catch (TransformerException | FileNotFoundException | UnsupportedEncodingException ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
