package unit_tests;

import java.time.LocalDateTime;
import java.util.ArrayList;

import consolidators.MovieConsolidator;
import entities.Booking;
import entities.ISeat;
import entities.ISeats;
import entities.Movie;
import entities.Seat;
import entities.Seats;
import entities.Ticket;
import enums.AgeGroup;
import enums.DayOfWeek;
import enums.TimeOfDay;
import enums.TypeOfDay;
import initializer.Booking_Initializer;
import initializer.Movie_Initializer;
import initializer.SeatsInitializer;
import managers.MovieManager;

public class initializerTest {
    public static void main(String[] args) {
       ISeat[][] test = new ISeat[1][1];

       test[0][0] = new Seat();

       Seats seats = new Seats(123, test);

       SeatsInitializer.writeSeatsToFile(seats);
       seats = SeatsInitializer.readSeatsFromFile(123);

       for(int i = 0; i < test.length; i++) {
        for(int j = 0; j < test[0].length; j++) {
            System.out.print(test[i][j]+",");
        }
        System.out.print("\n");
       }
    }
    
}
