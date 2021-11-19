import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * как сериализовать статичесие поля
 */

public class Animal implements Serializable {
    private String strControl = "сериализуется ли";
    private String animalName;
    private static String strStatic = "strStatic";
    private static int intstatic = 1;

    public Animal(String animalName) {
        this.animalName = animalName;
    }

    public static String getStrStatic() {
        return strStatic;
    }

    public static void setStrStatic(String strStatic) {
        Animal.strStatic = strStatic;
    }

    // для сериализации статических полей
    private void writeObject(ObjectOutputStream oos) throws IOException {
        try {
            oos.defaultWriteObject();
            oos.writeObject(new String(strStatic));
            oos.writeObject(new Integer(intstatic));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // для ДЕсериализации статических полей
    private void readObeject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        try {
            ois.defaultReadObject();
            ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String getStr() {
        return strControl;
    }

    public void setStr(String str) {
        this.strControl = str;
    }

    @Override
    public String toString() {
        return (animalName.toString());
    }
}

abstract class SubAnimal extends Animal{
    private String s;

    SubAnimal(String s){
        super("SubAnimal");
        this.s = s;
    }

}