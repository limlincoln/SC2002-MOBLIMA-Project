package entities;

import java.util.ArrayList;

import managers.MovieManager;

public class Booking {
    private int TID;
    private int movieID;
    private Customer customer;
    private ArrayList<Ticket> tickets;
    private int rating = -1;
    private double totalCost;

    public Booking(int tid, int movieID, Customer customer, ArrayList<Ticket> tickets, double totalCost) {
        this.TID = tid;
        this.movieID = movieID;
        this.customer = customer;
        this.tickets = tickets;
        this.totalCost = totalCost;
    }

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

    public void setTID(int tid) {
        this.TID = tid;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovie(int movieID) {
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

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
