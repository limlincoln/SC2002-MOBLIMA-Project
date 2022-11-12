package entities;

// TODO: Auto-generated Javadoc
/**
 * The Class ISeats.
 */
public abstract class ISeats {
    
    /** The seats. */
    private ISeat[][] seats;

    /**
	 * Gets the seats.
	 *
	 * @return the seats
	 */
    public ISeat[][] getSeats() {
        return this.seats;
    }

    /**
	 * Sets the seats.
	 *
	 * @param seats the new seats
	 */
    public void setSeats(ISeat[][] seats) {
        this.seats = seats;
    }
}
