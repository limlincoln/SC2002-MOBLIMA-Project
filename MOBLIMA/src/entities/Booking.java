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

	public Object getMovie() {
		// TODO Auto-generated method stub
		
		return null;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
