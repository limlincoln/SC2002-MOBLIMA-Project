package consolidators;

import enums.Status;
import managers.MovieManager;
import entities.Movie;
import java.util.ArrayList;


/*
 * Consolidates all movies in a given cineplex
 */
public class MovieConsolidator implements IConsolidator<Movie> {
    private static MovieConsolidator single_instance = null;

    private MovieConsolidator(){}

    public static MovieConsolidator getInstance(){
        if(single_instance == null){
            single_instance = new MovieConsolidator();
        }
        return single_instance;
    }
    
    public ArrayList<Movie> getAll(){
        MovieManager movieManager = MovieManager.getInstance();
        return movieManager.getMovies();
    }
    public ArrayList<Movie> getAvaliable(){
        ArrayList<Movie> result = new ArrayList<>(this.getAll());
        for(int i=0; i<result.size(); i++){
            if(result.get(i).getStatus() == Status.EndOfShowing){
                result.remove(i);
            }
        }
        return result;
    }

    public ArrayList<Movie> getTop5ByRating(){
        ArrayList<Movie> movies = this.getAll();
        ArrayList<Movie> result = new ArrayList<Movie>();

        movies.sort((m1, m2) -> {
            if(m1.getAvgRating() > m2.getAvgRating())
                return -1;
            if(m1.getAvgRating() < m2.getAvgRating())
                return 1;
            return 0;
        });
        for(int i=0; i<5; i++){
            System.out.println(movies.get(i).getMovieID());
            result.add(movies.get(i));
        }
        return result;
    }

    public ArrayList<Movie> getTop5BySales(){
        ArrayList<Movie> movies = this.getAll();
        ArrayList<Movie> result = new ArrayList<Movie>();
        result.sort((m1, m2) -> {
            if(m1.getTotalSales() > m2.getTotalSales())
                return -1;
            if(m1.getTotalSales() < m2.getTotalSales())
                return 1;
            return 0;
        });
       
        for(int i=0; i<5; i++){
            result.add(movies.get(i));
        }
        return result;
    }

    public Movie getMovieByName(String name){
        ArrayList<Movie> movies = this.getAll();
        String cleaned = name.trim().toLowerCase();
        for(Movie movie : movies){
            if(movie.getMovieName().trim().toLowerCase().equals(cleaned) && movie.getStatus() != Status.EndOfShowing){
                return movie;
            }
        }
        return null;
    }
}
