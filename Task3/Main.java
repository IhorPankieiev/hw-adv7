package Task3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element rootElement = doc.createElement("catalog");
            doc.appendChild(rootElement);

            Element city1 = doc.createElement("city");
            rootElement.appendChild(city1);

            Element cityName1 = doc.createElement("name");
            cityName1.setAttribute("size","big");
            cityName1.setTextContent("Kyiv");
            city1.appendChild(cityName1);

            Element city2 = doc.createElement("city");
            rootElement.appendChild(city2);

            Element cityName2 = doc.createElement("name");
            cityName2.setAttribute("size", "medium");
            cityName2.setTextContent("Nikopol");
            city2.appendChild(cityName2);

            Element city3 = doc.createElement("city");
            rootElement.appendChild(city3);

            Element cityName3 = doc.createElement("name");
            cityName3.setAttribute("size", "small");
            cityName3.setTextContent("Marganets");
            city3.appendChild(cityName3);



            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult sr = new StreamResult(new File("C:\\Users\\igorp\\IdeaProjects\\hw-adv7\\src\\Task3\\file.xml"));
            t.transform(source, sr);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }

        String path = "C:\\Users\\igorp\\IdeaProjects\\hw-adv7\\src\\Task3\\file.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        DefaultHandler handler = new DefaultHandler() {

            boolean name = false;


            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

                if (qName.equalsIgnoreCase("name")) {
                    name = true;
                    System.out.println("Size: " + attributes.getValue("size"));
                }

            }

            @Override
            public void characters(char ch[], int start, int length) throws SAXException {

                if (name) {
                    System.out.println("Name: " + new String(ch, start, length) );
                    name = false;
                    System.out.println();
                }
            }
        };

        saxParser.parse(path, handler);
    }
}
