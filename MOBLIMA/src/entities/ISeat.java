package entities;

/**
 * Interface for an individual Seat
 */
public interface ISeat {
    /**
     * get the state of the Seat
     * @return string that describes the state of the seat
     */
    public String getState();

    /**
     * get the state of the Seat
     * @return int that describes the state of the seat
     */
    public int getStateInt();
}
