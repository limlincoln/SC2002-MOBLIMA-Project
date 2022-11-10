package entities;

/**
 * Showtime class that holds the showtime slots and seats for that slot for a particular day.
 */
public class Showtime {
    private int[] showtime;
    private Seats[] seats;

    public Showtime(){
        this.showtime = new int[8];
        this.seats = new Seats[8];
    }

    public Seats getSeatsByShowtime(int index){
        return this.seats[index];
    }
    
    /** 
     * Getters & Setters
     */
    public int[] getShowtime() {
        return this.showtime;
    }

    public void setShowtime(int[] showtime) {
        this.showtime = showtime;
    }

    public Seats[] getSeats() {
        return this.seats;
    }

    public void setSeats(Seats[] seats) {
        this.seats = seats;
    }

}
