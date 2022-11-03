package consolidators;

import entities.Cineplex;
import entities.Movie;
import entities.Cinema;
import java.util.ArrayList;
/*
 * Consolidates all movies in a given cineplex
 */
public class MovieConsolidator implements IConsolidator<Movie> {
    private Cineplex cineplex;
    public MovieConsolidator(Cineplex cineplex){
        this.cineplex = cineplex;
    }
    public ArrayList<Movie> getAll(){
        ArrayList<Cinema> cinemas = this.cineplex.getCinemas();
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
