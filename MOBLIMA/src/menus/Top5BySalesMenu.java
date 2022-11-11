package menus;

import java.util.ArrayList;

import consolidators.MovieConsolidator;
import entities.Movie;


/**
 * Menu to display top 5 movies by sales 
 */
public class Top5BySalesMenu implements ITop5Menu {
    public static Top5BySalesMenu single_instance = null;

    private Top5BySalesMenu() {}

    public static Top5BySalesMenu getInstance() {
        if(single_instance == null) {
            single_instance = new Top5BySalesMenu();
        }
        return single_instance;
    }
    @Override
    public void displayMenu() {
        ArrayList<Movie> topmovies = MovieConsolidator.getInstance().getTop5BySales();

        Movie selectedMovie = MovieSelectorMenu.getInstance().startSelector(topmovies, "TOP 5 MOVIES BY RATING");
        
        if (selectedMovie != null) {
            CineplexMenu.getInstance().displayCineplexMenu(selectedMovie); 
        } 
    }
    
}
