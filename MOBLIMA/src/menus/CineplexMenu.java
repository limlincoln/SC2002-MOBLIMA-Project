package menus;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Cineplex;
import entities.Movie;
import managers.CineplexManager;
/**
 * Menu to display cineplex
 */
public class CineplexMenu {
    /** 
     * Single instance of CineplexMenu 
     */
    private static CineplexMenu single_instance = null;
    
    private CineplexMenu(){}
    /**
     * Get or creates the single instance of CineplexMenu class
     * @return CineplexMenu Class
     */

    public static CineplexMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new CineplexMenu();
        return single_instance;
    }

    /**
     * Display Cineplex Menu
     * @param movie
     */
	public void displayCineplexMenu(Movie movie) { 
        ArrayList<Cineplex> cineplexes = CineplexManager.getInstance().getCineplexByMovie(movie.getMovieID());
        Cineplex selectedCinplex = CineplexSelectorMenu.getInstance().startSelector(cineplexes, "SELECT A CINEPLEX");

        if (selectedCinplex == null) return;
        	
        CinemaMenu.getInstance().displayCinemaMenu(movie, selectedCinplex); 
    }
}
