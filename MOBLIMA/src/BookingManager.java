import java.util.ArrayList;

public class BookingManager {
    private static ArrayList<Booking> bookingHistory = new ArrayList<Booking>();

    private static int generateTID(int cinemaID, int dateTime) {
        String strCinemaID = Integer.toString(cinemaID);
        String strDateTime = Integer.toString(dateTime);

        String strTID = strCinemaID + strDateTime;

        return Integer.parseInt(strTID);
    }

    public static boolean createBooking(int cinemaID, Movie movie, Customer customer) {
        int tid = generateTID(cinemaID, DateManager.getCurrentDateTime("yyyyMMddHHmm"));

        Booking booking = new Booking(tid, movie, customer);
        bookingHistory.add(booking);
    }  

    public static ArrayList<Booking> getBookingHistory() {
        return bookingHistory;
    }
}
