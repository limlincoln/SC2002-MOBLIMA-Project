package menus;

import java.util.ArrayList;

import consolidators.MovieConsolidator;
import entities.Movie;

public class Top5ByRatingMenu implements ITop5Menu {
    @Override
    public void displayMenu() {
        ArrayList<Movie> topmovies = MovieConsolidator.getInstance().getTop5ByRating();

        Movie selectedMovie = MovieSelectorMenu.getInstance().startSelector(topmovies, "TOP 5 MOVIES BY RATING");
        
        if (selectedMovie != null) {
            CineplexMenu.getInstance().displayCineplexMenu(selectedMovie); 
        } 
    }
    
}
