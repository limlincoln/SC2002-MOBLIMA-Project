package entities;

public class Booking {
    private int TID;
    private Movie movie;
    private Customer customer;

    public Booking(int tid, Movie movie, Customer customer) {
        this.TID = tid;
        this.movie = movie;
        this.customer = customer;
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
}
