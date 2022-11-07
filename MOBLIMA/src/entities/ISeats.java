package entities;

public abstract class ISeats {
    private ISeat[][] seats;

    public ISeat[][] getSeats() {
        return this.seats;
    }

    public void setSeats(ISeat[][] seats) {
        this.seats = seats;
    }
}
