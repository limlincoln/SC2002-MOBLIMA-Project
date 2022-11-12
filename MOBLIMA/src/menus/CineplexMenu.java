package menus;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Cineplex;
import entities.Movie;
import managers.CineplexManager;

public class CineplexMenu {
    private static CineplexMenu single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

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
        ArrayList<Cineplex> cineplexes = CineplexManager.getInstance().getCineplexs();
        // System.out.println(CineplexManager.getInstance().getCineplexs().get(0).getCinemas().get(0).containsMovie(movie.getMovieID()));
        // System.out.println("Cineplexes: "+cineplexes);
        Cineplex selectedCinplex = CineplexSelectorMenu.getInstance().startSelector(cineplexes, "SELECT A CINEPLEX");

        if (selectedCinplex == null) return;
        	
        CinemaMenu.getInstance().displayCinemaMenu(movie, selectedCinplex); 
    }
}
