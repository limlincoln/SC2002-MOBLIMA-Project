package menus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Cinema;
import entities.Cineplex;
import entities.Movie;
import entities.Seats;
import managers.ShowTimeManager;
import utils.SeatPrinter;
/**
 * Menu to display ShowTime
 */
public class ShowTimeMenu {
    /** 
     * Single instance of ShowTimeMenu 
     */
    private static ShowTimeMenu single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

    private ShowTimeMenu(){}

    /**
     * Get or creates the single instance of ShowTimeMenu class
     * @return ShowTimeMenu Class
     */
    public static ShowTimeMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new ShowTimeMenu();
        return single_instance;
    }

    /**
     * Display showtime menu
     * @param movie
     * @param cineplex
     * @param cinema
     */
	public void displayShowTimeMenu(Movie movie, Cineplex cineplex,Cinema cinema) { 
		System.out.println("MOVIE: "+movie.getMovieName());
		ArrayList<LocalDateTime> showtimes = ShowTimeManager.getInstance().getShowTimeByMovie(cinema, movie);

		LocalDateTime selectedShowTime = ShowTimeSelectorMenu.getInstance().startSelector(showtimes, "SELECT SHOWTIME");	

		Seats selectedSeats = ShowTimeManager.getInstance().getSeatsByLocalDateTime(cinema, selectedShowTime);

		BookingMenu.getInstance().displayBookingMenu(movie, cinema, selectedSeats, selectedShowTime);
	}
}
