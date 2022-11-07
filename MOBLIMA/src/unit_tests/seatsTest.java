package unit_tests;
import entities.ISeat;
import entities.Seat;
import entities.SeatLayout;
import entities.Seats;
import entities.Space;
import utils.SeatPrinter;

public class seatsTest {
  public static void main(String[] args) {
      SeatPrinter sp = SeatPrinter.getInstance();
      ISeat[][] s = new ISeat[5][5];
      for(int i=0; i<5; i++){
        for(int j=0; j<5; j++){
          s[i][j] = new Seat();
        }
      }
      s[0][0] = new Space();
      s[0][1] = new Space();
      s[1][1] = new Space();
      SeatLayout seatLayout = new SeatLayout(s);
      Seats seats = new Seats(seatLayout);
      sp.print(seats);
  }
}
