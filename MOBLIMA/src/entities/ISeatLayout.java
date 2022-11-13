package entities;

import java.util.Optional;

/**
 * Abstract class for Seat Layouts
 */
abstract class ISeatLayout {
    /**
     * the 2D array describing the layouts of a set of seats
     */
    ISeat[][] layout;

    /**
     * create the seat layout
     * @param <T> the type of the layout of the seat (eg. 2D array of ISeat)
     * @return the layout of the seats
     */
    public abstract <T> Optional<T> createLayout();

    // GETTERS and SETTERS
    public ISeat[][] getLayout() {
        return this.layout;
    }

    public void setLayout(ISeat[][] layout) {
        this.layout = layout;
    }

}
