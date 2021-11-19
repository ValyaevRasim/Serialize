import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * сериализация и десериализация статических полей
 * https://overcoder.net/q/197157/как-сериализовать-статические-данные-членов-класса-java
 */

class Booking implements Serializable {
    /**
     * генерируем serial version ID.
     */

    private static final long serialVersionUID = 5316748056989930874L;
    private static int newBookingNumber = 0; // Для хранения нового номера бронирования.
    private int bookingNumber; // Номер бронирования.

    Booking(int bookingNumber) {
        this.bookingNumber = bookingNumber;
        newBookingNumber = bookingNumber * 100;
    }

    // сериализация статических данных
    public static void serialnewBookingNumber(ObjectOutputStream oos) throws IOException {
        oos.writeInt(newBookingNumber);
    }

    // ДЕсериализация статических данных
    public static void deserialnewBookingNumber(ObjectInputStream ois) throws IOException {
        newBookingNumber = ois.readInt();
    }

    // сериализация статических данных
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(newBookingNumber);
    }

    // ДЕсериализация статических данных
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        newBookingNumber = ois.readInt();
    }

    @Override
    public String toString() {
        return bookingNumber + ": " + newBookingNumber;
    }
}
