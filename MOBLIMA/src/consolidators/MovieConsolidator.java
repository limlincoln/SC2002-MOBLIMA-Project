package consolidators;

import entities.Cineplex;
import entities.Movie;
import entities.Cinema;
import java.util.ArrayList;
/*
 * Consolidates all movies in a given cineplex
 */
public class MovieConsolidator implements IConsolidator<Movie, Cineplex> {
    private static MovieConsolidator single_instance = null;

    private MovieConsolidator(){}

    public static MovieConsolidator getInstance(){
        if(single_instance == null){
            single_instance = new MovieConsolidator();
        }
        return single_instance;
    }
    
    public ArrayList<Movie> getAll(Cineplex cineplex){
        ArrayList<Cinema> cinemas = cineplex.getCinemas();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        for(int i=0; i<cinemas.size(); i++){
            movies.addAll(cinemas.get(i).getMovies());
        }
        return movies;
    }
    public ArrayList<Movie> getShowing(){
        return new ArrayList<Movie>();
    }
}
