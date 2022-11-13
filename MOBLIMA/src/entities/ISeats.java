package entities;

/**
 * Abstract class for 2D array of seats
 */
public abstract class ISeats {
    /**
     * The 2D array of ISeat containing the actual seats
     */
    private ISeat[][] seats;

    // GETTERS and SETTERS
    public ISeat[][] getSeats() {
        return this.seats;
    }

    public void setSeats(ISeat[][] seats) {
        this.seats = seats;
    }
}
