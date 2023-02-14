package Task4;

import com.sun.xml.internal.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

public class City {

    private String name;
    private String size;

    public City(){ }

    public City(String size, String name){
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }
}
