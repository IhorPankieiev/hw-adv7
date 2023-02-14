package Task2;

import java.io.Serializable;

public class Animal implements Serializable {
    public String type = "Dog";
    private int age = 5;
    protected String name = "Django";

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Animal() {

    }
}
