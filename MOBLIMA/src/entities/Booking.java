package entities;

import java.util.ArrayList;

public class Booking {
    private int TID;
    private Movie movie;
    private Customer customer;
    private ArrayList<Ticket> tickets;
    private double totalCost;

    public Booking(int tid, Movie movie, Customer customer, ArrayList<Ticket> tickets, double totalCost) {
        this.TID = tid;
        this.movie = movie;
        this.customer = customer;
        this.tickets = tickets;
        this.totalCost = totalCost;
    }

    public void showBookingDetails() {
        System.out.println(
            "TID: "+ TID + "\n" +
            "Movie: "+ movie.getMovieName() + "\n" +
            "No. of Seats: "+tickets.size() + "\n" +
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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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
