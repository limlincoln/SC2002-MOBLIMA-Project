package managers;

import entities.Booking;
import entities.Customer;
import entities.Ticket;

import java.util.ArrayList;

/**
 * Class that manages all booking related things and contains the Booking history
 */
public class BookingManager {
    private static ArrayList<Booking> bookingHistory = new ArrayList<Booking>();
    
    public static void initialize(ArrayList<Booking> bookingHistory){
        BookingManager.bookingHistory = bookingHistory;
    }
    /**
     * Generates the ID
     * @param cinemaID the ID of the cinema for which to generate the TID
     * @param dateTime the date and time at the time of Booking creation
     * @return the TID
     */
    private static String generateTID(int cinemaID, String dateTime) {
        String strCinemaID = Integer.toString(cinemaID);

        String strTID = strCinemaID + dateTime;

        return strTID;
    }

    /**
     * Creates Booking for booking movie
     * @param cinemaID the cinema ID associated with this booking 
     * @param movieID the movie ID associated with this booking 
     * @param customer the customer associated with this booking 
     * @param tickets the tickets associated with this booking 
     * @param totalCost the totalcost for this booking 
     * @param rating the rating given to the movie in this booking
     * @return true if successful else false
     */
    public static boolean createBooking(int cinemaID, int movieID, Customer customer, ArrayList<Ticket> tickets, double totalCost, int rating ) {
        String tid = generateTID(cinemaID, DateManager.getCurrentDateTimeFormatted("yyyyMMddHHmm"));

        Booking booking = new Booking(tid, movieID, customer, tickets, totalCost, rating);
        bookingHistory.add(booking);
        return true;
    }  

    /**
     * Get all of the booking history
     * @return array list of Booking class
     */
    public static ArrayList<Booking> getAllBookingHistory() {
        return bookingHistory;
    }

    /**
     * Get the booking history by username
     * @param username the username for which to return the booking history
     * @return list of booking history for this user
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
     * @param username he username for which to return the unrated bookings
     * @return list of unrated bookings for this user
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
     * @param usename he username for which to return the unrated bookings
     * @return list of unrated bookings for this user
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
