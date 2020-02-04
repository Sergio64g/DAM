package examen_tr1_ad_3;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Examen_Tr1_AD_3 {

    public static void main(String[] args) {
        //Crear un try-catch para manejar excepciones
        try {
            //Se crea un archivo XML al que se le tienen que añadir elementos
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            //Se crea el elemento 'Hoteles'
            Element raiz = doc.createElement("Hoteles");
            //Mediante el metodo appendChild se configurara como el elemento raiz
            doc.appendChild(raiz);

            //Se crea el metodo 'Hotel'
            Element hotel = doc.createElement("Hotel");
            //El elemento 'hotel' tendrá el será el padre de el resto de atributos
            raiz.appendChild(hotel);

            //Se crea el metodo 'Nombre'
            Element nombre = doc.createElement("Nombre");
            //Nombre es un atributo de Hotel
            hotel.appendChild(nombre);

            //Se crea el metodo 'Localidad'
            Element localidad = doc.createElement("Localidad");
            //Localidad un atributo de Hotel
            hotel.appendChild(localidad);

            //Se crea el metodo 'Tipo de alojamiento'
            Element tAlojamiento = doc.createElement("Tipo_de_alojamiento");
            //Tipo de alojamineto es un atributo de Hotel
            hotel.appendChild(tAlojamiento);

            //Se crea el metodo 'Valoración'
            Element valoracion = doc.createElement("Valoración");
            //Valoracion es un atributo de Hotel
            hotel.appendChild(valoracion);

            //Se escribe el contenido en un archivo .xml
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/Hotels/alojamiento.xml"));

           
            transformer.transform(source, result);

        } catch (ParserConfigurationException ex) {
            System.err.println("Error al crear el XML");
        } catch (TransformerException ex) {
            System.err.println("Error al crear el XMl");
        }

    }

}
