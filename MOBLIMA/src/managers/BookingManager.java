package managers;

import entities.Booking;
import entities.Movie;
import entities.Customer;
import entities.Ticket;

import java.util.ArrayList;

public class BookingManager {
    private static ArrayList<Booking> bookingHistory = new ArrayList<Booking>();

    private static int generateTID(int cinemaID, int dateTime) {
        String strCinemaID = Integer.toString(cinemaID);
        String strDateTime = Integer.toString(dateTime);

        String strTID = strCinemaID + strDateTime;

        return Integer.parseInt(strTID);
    }

    public static boolean createBooking(int cinemaID, Movie movie, Customer customer, ArrayList<Ticket> tickets, double totalCost) {
        int tid = generateTID(cinemaID, DateManager.getCurrentDateTime("yyyyMMddHHmm"));

        Booking booking = new Booking(tid, movie, customer, tickets, totalCost);
        bookingHistory.add(booking);
        return true;
    }  

    public static ArrayList<Booking> getBookingHistory(String username) {
        ArrayList<Booking> userBookingHistory = new ArrayList<Booking>();

        for(Booking booking: bookingHistory) {
            if(booking.getCustomer().getUserName().equals(username)) {
                userBookingHistory.add(booking);
            }
        }

        return userBookingHistory;
    }
}
