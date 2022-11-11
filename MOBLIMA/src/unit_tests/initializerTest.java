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
import managers.MovieManager;

public class initializerTest {
    public static void main(String[] args) {
        ArrayList<Movie> movies = Movie_Initializer.GetMovieListing();
        MovieManager.instantiateMovies(movies);

        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        for(Ticket ticket: tickets) {
            ticket = new Ticket(1234, DayOfWeek.FRI,TimeOfDay.AFTER_6, TypeOfDay.PUBLIC_HOLIDAY, LocalDateTime.now(), AgeGroup.ADULT, "1A");
        }

        ArrayList<Booking> bookings = Booking_Initializer.GetBooking(tickets);

        for(Booking booking: bookings) {
            booking.showBookingDetails();
        }
    }
    
}
