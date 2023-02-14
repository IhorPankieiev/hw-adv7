package Task2;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File file = new File("C:\\Users\\igorp\\IdeaProjects\\hw-adv7\\src\\Task2\\file.txt");

        Animal animal = new Animal();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(animal);
        objectOutputStream.flush();
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Animal newAnimal = (Animal)objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(newAnimal.toString());
    }
}
