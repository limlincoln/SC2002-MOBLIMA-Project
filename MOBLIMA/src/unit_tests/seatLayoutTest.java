package unit_tests;

import entities.SeatLayout;
import entities.Seats;
import utils.SeatPrinter;

public class seatLayoutTest {
    public static void main(String[] args) {
        SeatLayout seatLayout = new SeatLayout();
        Seats seats = new Seats(seatLayout);
        SeatPrinter sp = SeatPrinter.getInstance();
        sp.print(seats);
    }
}
