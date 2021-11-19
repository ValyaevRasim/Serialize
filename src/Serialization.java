import java.io.*;

public class Serialization {

    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.bin"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.bin"))) {

            Booking booking = new Booking(21202);
//            Booking.serialnewBookingNumber(oos);
            oos.writeObject(booking);
//            booking.writeObject(oos);
            oos.flush();
            System.out.println(booking.toString());

//            booking = (Booking) ois.readObject();
//            System.out.println(booking.toString());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
