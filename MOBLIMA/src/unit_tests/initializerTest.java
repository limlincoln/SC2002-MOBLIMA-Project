package unit_tests;

import java.time.LocalDateTime;
import java.util.ArrayList;

import consolidators.MovieConsolidator;
import entities.Booking;
import entities.Movie;
import entities.Ticket;
import enums.AgeGroup;
import enums.DayOfWeek;
import enums.TimeOfDay;
import enums.TypeOfDay;
import initializer.Booking_Initializer;
import initializer.Movie_Initializer;
import initializer.Seats_Initializer;
import managers.MovieManager;

public class initializerTest {
    public static void main(String[] args) {
       int[][] test = new int[3][4];

       test[1][3] = 3;

       Seats_Initializer.writeSeatsToFile(123, test);
       test = Seats_Initializer.readSeatsFromFile(123);

       for(int i = 0; i < test.length; i++) {
        for(int j = 0; j < test[0].length; j++) {
            System.out.print(test[i][j]+",");
        }
        System.out.print("\n");
       }
    }
    
}
