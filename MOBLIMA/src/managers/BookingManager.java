package managers;

import entities.Booking;
import entities.Customer;
import entities.Ticket;

import java.util.ArrayList;

public class BookingManager {
    private static ArrayList<Booking> bookingHistory = new ArrayList<Booking>();
    
    public static void initialize(ArrayList<Booking> bookingHistory){
        BookingManager.bookingHistory = bookingHistory;
    }
    /**
     * Generates the ID
     * @param cinemaID
     * @param dateTime
     * @return
     */
    private static int generateTID(int cinemaID, int dateTime) {
        String strCinemaID = Integer.toString(cinemaID);
        String strDateTime = Integer.toString(dateTime);

        String strTID = strCinemaID + strDateTime;

        return Integer.parseInt(strTID);
    }

    /**
     * Creates Booking for booking movie
     * @param cinemaID
     * @param movieID
     * @param customer
     * @param tickets
     * @param totalCost
     * @param rating
     * @return
     */
    public static boolean createBooking(int cinemaID, int movieID, Customer customer, ArrayList<Ticket> tickets, double totalCost, int rating ) {
        int tid = generateTID(cinemaID, DateManager.getCurrentDateTimeFormatted("yyyyMMddHHmm"));

        Booking booking = new Booking(tid, movieID, customer, tickets, totalCost, rating);
        bookingHistory.add(booking);
        return true;
    }  

    /**
     * Get the booking history by username
     * @param username
     * @return
     */
    public static ArrayList<Booking> getBookingHistoryByUsername(String username) {
        ArrayList<Booking> userBookingHistory = new ArrayList<Booking>();

        for(Booking booking: bookingHistory) {
            if(booking.getCustomer().getUserName().equals(username)) {
                userBookingHistory.add(booking);
            }
        }

        return userBookingHistory;
    }

    /**
     * Get unrated bookings by usernames
     * @param username
     * @return
     */
    public static ArrayList<Booking> getUnratedBookingsByUsername(String username) {
        ArrayList<Booking> unratedBookings = new ArrayList<Booking>();

        ArrayList<Booking> userBookingHistory = getBookingHistoryByUsername(username);

        for(Booking booking: userBookingHistory) {
            if(booking.getRating() == -1) {
                unratedBookings.add(booking);
            }
        }

        return unratedBookings;
    }

    /**
     * Get Rate Bookings by Username
     * @param usename
     * @return
     */
    public static ArrayList<Booking> getRatedBookingsByUsername(String usename) {
        ArrayList<Booking> ratedBookings = new ArrayList<Booking>();

        ArrayList<Booking> userBookingHistory = getBookingHistoryByUsername(usename);
        
        for(Booking booking: userBookingHistory) {
            if(booking.getRating() != -1) {
                ratedBookings.add(booking);
            }
        }

        return ratedBookings;
    }

    
}
