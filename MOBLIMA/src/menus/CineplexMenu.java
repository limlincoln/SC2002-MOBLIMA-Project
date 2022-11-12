package menus;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Cineplex;
import entities.Movie;
import managers.CineplexManager;

public class CineplexMenu {
    private static CineplexMenu single_instance = null;
    
    private CineplexMenu(){}


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
