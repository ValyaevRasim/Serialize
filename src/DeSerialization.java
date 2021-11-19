import java.io.*;
/*
 * http://javateaching.blogspot.com/2011/12/serialization-static-field.html
 */

public class DeSerialization {
    public static void main(String[] args) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f:\\Baza\\Admin\\Java\\JMPZ_File\\object.bin "))) {

//            Booking.deserialnewBookingNumber(ois);

            Booking obj = (Booking) ois.readObject();
            System.out.println(obj.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
