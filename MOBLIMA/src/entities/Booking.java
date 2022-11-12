package entities;

import java.util.ArrayList;

import managers.MovieManager;

// TODO: Auto-generated Javadoc
/**
 * The Class Booking.
 */
public class Booking {
    
    /** The transaction ID in the format XXXYYYYMMDDhh (XXX = cinema code). */
    private int TID;

    /** ID of movie for which the Booking was made. */
    private int movieID;

    /** The Customer who booked. */
    private Customer customer;

    /** The list of Tickets booked. */
    private ArrayList<Ticket> tickets;

    /** The rating given to the movie in this booking. */
    private int rating = -1;

    /** The total cost for this Booking. */
    private double totalCost;

    /**
	 * Constructor for the Booking Class.
	 *
	 * @param tid       The transaction ID of this Booking
	 * @param movieID   The ID of the movie for which this Booking was made
	 * @param customer  The Customer who booked this Booking
	 * @param tickets   The List of Tickets booked for this Booking
	 * @param totalCost The total cost for this Booking
	 * @param rating    The rating given to this movie
	 */
    public Booking(int tid, int movieID, Customer customer, ArrayList<Ticket> tickets, double totalCost, int rating) {
        this.TID = tid;
        this.movieID = movieID;
        this.customer = customer;
        this.tickets = tickets;
        this.totalCost = totalCost;
        this.rating = rating;
    }

    /**
	 * Prints out the details of the Booking on screen.
	 */
    public void showBookingDetails() {
        System.out.println(
            "TID: "+ TID + "\n" +
            "Movie: "+ MovieManager.getInstance().getMovieByID(movieID).getMovieName() + "\n" +
            "No. of Seats: "+tickets.size() + "\n" +
            "User Rating: "+rating + "\n" +
            "Purchased By: "+ customer.getUserName() +
            "\n" + customer.getPhoneNumber() +
            "\n" + customer.getEmail() + "\n" +
            "Total Cost: " + totalCost + "\n" +
            "Rating: " + rating
        );
    }

    /**
	 * Gets the tid.
	 *
	 * @return the tid
	 */
    // GETTERS & SETTERS
    public int getTID() {
        return TID;
    }

    /**
	 * Sets the tid.
	 *
	 * @param tID the new tid
	 */
    public void setTID(int tID) {
        TID = tID;
    }

    /**
	 * Gets the movie ID.
	 *
	 * @return the movie ID
	 */
    public int getMovieID() {
        return movieID;
    }

    /**
	 * Sets the movie ID.
	 *
	 * @param movieID the new movie ID
	 */
    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    /**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
    public Customer getCustomer() {
        return customer;
    }

    /**
	 * Sets the customer.
	 *
	 * @param customer the new customer
	 */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
	 * Gets the tickets.
	 *
	 * @return the tickets
	 */
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    /**
	 * Sets the tickets.
	 *
	 * @param tickets the new tickets
	 */
    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    /**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
    public int getRating() {
        return rating;
    }

    /**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
	 * Gets the total cost.
	 *
	 * @return the total cost
	 */
    public double getTotalCost() {
        return totalCost;
    }

    /**
	 * Sets the total cost.
	 *
	 * @param totalCost the new total cost
	 */
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
