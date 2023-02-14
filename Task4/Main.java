package Task4;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import javax.xml.bind.Marshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) throws JAXBException {
        Catalog catal = new Catalog();
        catal.add(new City("big", "Kyiv"));
        catal.add(new City("medium", "Nikopol"));
        catal.add(new City("small", "Marganets"));

        File file = new File("C:\\Users\\igorp\\IdeaProjects\\hw-adv7\\src\\Task4\\File2.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
        Marshaller marsh = jaxbContext.createMarshaller();

        marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marsh.marshal(catal, file);
        marsh.marshal(catal, System.out);


    }
}
