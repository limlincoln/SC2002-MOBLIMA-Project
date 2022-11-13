package consolidators;

import enums.Status;
import managers.MovieManager;
import entities.Movie;
import java.util.ArrayList;


/*
 * Consolidates all movies in a given cineplex
 */
public class MovieConsolidator implements IConsolidator<Movie> {
    /**
     * the single instance for this class
     */
    private static MovieConsolidator single_instance = null;

    /**
     * the Constructor for MovieConsolidator
     */
    private MovieConsolidator(){}

    /**
     * get an instance of this class
     * @return MovieConsolidator object
     */
    public static MovieConsolidator getInstance(){
        if(single_instance == null){
            single_instance = new MovieConsolidator();
        }
        return single_instance;
    }
    
    /**
     * get all the movies that exist in the Database
     */
    public ArrayList<Movie> getAll(){
        MovieManager movieManager = MovieManager.getInstance();
        return movieManager.getMovies();
    }

    /**
     * get all the movies that are available
     * i.e. movies that are not EndOfShowing
     * @return all the available movies
     */
    public ArrayList<Movie> getAvaliable(){
        ArrayList<Movie> result = new ArrayList<>(this.getAll());
        for(int i=0; i<result.size(); i++){
            if(result.get(i).getStatus() == Status.EndOfShowing){
                result.remove(i);
            }
        }
        return result;
    }

    /**
     * get the Top 5 movies by Rating
     * @return all top 5 movies by rating
     */
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

    /**
     * get the Top 5 movies by Sales
     * @return all the top 5 movies by sales
     */
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

    /**
     * get a movie by using its name
     * @param name the name of the movie to return
     * @return movie based on the name
     */
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
