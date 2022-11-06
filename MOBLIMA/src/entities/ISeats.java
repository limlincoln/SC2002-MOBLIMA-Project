package entities;

public abstract class ISeats {
    private ISeat[][] seats;
    
    public abstract void showSeats();

    public ISeat[][] getSeats() {
        return this.seats;
    }

    public void setSeats(ISeat[][] seats) {
        this.seats = seats;
    }
}
