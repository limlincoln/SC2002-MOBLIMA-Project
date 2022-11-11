package menus;

import java.util.ArrayList;

import consolidators.MovieConsolidator;
import entities.Movie;

/**
 * Menu to display top 5 movies by ratings 
 */
public class Top5ByRatingMenu implements ITop5Menu {
    /**
     * A single instance of Top5ByRatingMenu
     */
    public static Top5ByRatingMenu single_instance = null;

    private Top5ByRatingMenu() {}

    /**
     * Creates or gets a single instance of Top5ByRatingMenu class
     * @return Top5ByRatingMenu Class
     */

    public static Top5ByRatingMenu getInstance() {
        if(single_instance == null) {
            single_instance = new Top5ByRatingMenu();
        }
        return single_instance;
    }

    /**
     * Display List of top 5 movies by rating
     */
    @Override
    public void displayMenu() {
        ArrayList<Movie> topmovies = MovieConsolidator.getInstance().getTop5ByRating();

        Movie selectedMovie = MovieSelectorMenu.getInstance().startSelector(topmovies, "TOP 5 MOVIES BY RATING");
        
        if (selectedMovie != null) {
            CineplexMenu.getInstance().displayCineplexMenu(selectedMovie); 
        } 
    }
}
