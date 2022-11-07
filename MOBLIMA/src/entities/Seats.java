package entities;

public class Seats extends ISeats{
    public Seats(ISeatLayout seatLayout ){
        this.setSeats(seatLayout.getLayout());
    };
}
