package unit_tests;

import java.util.ArrayList;

import consolidators.MovieConsolidator;
import entities.Booking;
import entities.Movie;
import initializer.Booking_Initializer;
import initializer.Movie_Initializer;
import managers.MovieManager;

public class initializerTest {
    public static void main(String[] args) {
        ArrayList<Movie> movies = Movie_Initializer.GetMovieListing();
        MovieManager.instantiateMovies(movies);

        ArrayList<Booking> bookings = Booking_Initializer.GetBooking();

        for(Booking booking: bookings) {
            booking.showBookingDetails();
        }
    }
    
}
