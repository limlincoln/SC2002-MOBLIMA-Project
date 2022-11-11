package entities;

import java.util.ArrayList;

import managers.MovieManager;

public class Booking {
    /**
     * The transaction ID in the format XXXYYYYMMDDhh
     * (XXX = cinema code)
     */
    private int TID;

    /**
     * ID of movie for which the Booking was made
     */
    private int movieID;

    /**
     * The Customer who booked
     */
    private Customer customer;

    /**
     * The list of Tickets booked
     */
    private ArrayList<Ticket> tickets;

    /**
     * The rating given to the movie in this booking
     */
    private int rating = -1;

    /**
     * The total cost for this Booking
     */
    private double totalCost;

    /**
     * Constructor for the Booking Class
     * @param tid The transaction ID of this Booking
     * @param movieID The ID of the movie for which this Booking was made
     * @param customer The Customer who booked this Booking
     * @param tickets The List of Tickets booked for this Booking
     * @param totalCost The total cost for this Booking
     */
    public Booking(int tid, int movieID, Customer customer, ArrayList<Ticket> tickets, double totalCost) {
        this.TID = tid;
        this.movieID = movieID;
        this.customer = customer;
        this.tickets = tickets;
        this.totalCost = totalCost;
    }

    /**
     * Prints out the details of the Booking on screen
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
            "Total Cost: " + totalCost
        );
    }

    // GETTERS & SETTERS
    public int getTID() {
        return TID;
    }

    public void setTID(int tID) {
        TID = tID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
