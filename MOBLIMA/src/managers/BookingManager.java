package managers;

import entities.Booking;
import entities.Customer;
import entities.Ticket;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class BookingManager.
 */
public class BookingManager {
    
    /** The booking history. */
    private static ArrayList<Booking> bookingHistory = new ArrayList<Booking>();

    /**
	 * Generates the ID.
	 *
	 * @param cinemaID the cinema ID
	 * @param dateTime the date time
	 * @return the int
	 */
    private static int generateTID(int cinemaID, int dateTime) {
        String strCinemaID = Integer.toString(cinemaID);
        String strDateTime = Integer.toString(dateTime);

        String strTID = strCinemaID + strDateTime;

        return Integer.parseInt(strTID);
    }

    /**
	 * Creates Booking for booking movie.
	 *
	 * @param cinemaID  the cinema ID
	 * @param movieID   the movie ID
	 * @param customer  the customer
	 * @param tickets   the tickets
	 * @param totalCost the total cost
	 * @return true, if successful
	 */
    public static boolean createBooking(int cinemaID, int movieID, Customer customer, ArrayList<Ticket> tickets, double totalCost) {
        int tid = generateTID(cinemaID, DateManager.getCurrentDateTimeFormatted("yyyyMMddHHmm"));

        Booking booking = new Booking(tid, movieID, customer, tickets, totalCost);
        bookingHistory.add(booking);
        return true;
    }  

    /**
	 * Get the booking history by username.
	 *
	 * @param username the username
	 * @return the booking history by username
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
	 * Get unrated bookings by usernames.
	 *
	 * @param username the username
	 * @return the unrated bookings by username
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
	 * Get Rate Bookings by Username.
	 *
	 * @param usename the usename
	 * @return the rated bookings by username
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
