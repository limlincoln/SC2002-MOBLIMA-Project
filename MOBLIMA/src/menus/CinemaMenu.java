package menus;
import java.util.Scanner;

import java.util.ArrayList;
import entities.Movie;
import entities.Cinema;
import entities.Cineplex;

public class CinemaMenu {
    private static CinemaMenu single_instance = null;
    
    private CinemaMenu(){}

    public static CinemaMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new CinemaMenu();
        return single_instance;
    }

    /**
     * Display cinema menu
     * @param movie
     * @param cineplex
     */
	public void displayCinemaMenu(Movie movie, Cineplex cineplex) { 
		ArrayList<Cinema> cinemas = cineplex.getCinemas();
        Cinema selectedCinema = CinemaSelectorMenu.getInstance().startSelector(cinemas, "SELECT A CINEMA");

        if (selectedCinema == null) return;

		ShowTimeMenu.getInstance().displayShowTimeMenu(movie, cineplex, selectedCinema);
	}
}
