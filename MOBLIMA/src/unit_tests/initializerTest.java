package unit_tests;

import java.util.ArrayList;

import entities.Cinema;
import entities.Cineplex;
import entities.ISeat;
import entities.Seats;
import entities.ShowTime;
import initializer.CineplexIntializer;
import utils.SeatPrinter;

public class initializerTest {
    public static void main(String[] args) {
        ArrayList <Cineplex> cinplexes = CineplexIntializer.readCineplexListFromFile();

        for(Cineplex cineplex: cinplexes) {
            System.out.println(cineplex.getCineplexName());
            for(Cinema cinema: cineplex.getCinemas()) {
                System.out.println("\n" + cinema.getCinemaType());
                for(ShowTime showtime: cinema.getShowtimes()) {
                    System.out.println("Showtime");
                    System.out.print(showtime.getShowTimeID());
                    for(Seats seats: showtime.getSeats()) {
                        System.out.println("\nSeats");
                        System.out.print(seats.getSeatsID());
                        ISeat[][] seatMatrix = seats.getSeats();
                        SeatPrinter.getInstance().print(seatMatrix);
                    }
                }
            }
        }
    }
    
}
