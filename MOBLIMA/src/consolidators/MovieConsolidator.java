package consolidators;

import enums.Status;
import managers.MovieManager;
import entities.Movie;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class MovieConsolidator.
 */
/*
 * Consolidates all movies in a given cineplex
 */
public class MovieConsolidator implements IConsolidator<Movie> {
    
    /** The single instance. */
    private static MovieConsolidator single_instance = null;

    /**
	 * Instantiates a new movie consolidator.
	 */
    private MovieConsolidator(){}

    /**
	 * Gets the single instance of MovieConsolidator.
	 *
	 * @return single instance of MovieConsolidator
	 */
    public static MovieConsolidator getInstance(){
        if(single_instance == null){
            single_instance = new MovieConsolidator();
        }
        return single_instance;
    }
    
    /**
	 * Get all MovieManager.
	 *
	 * @return movieManager object
	 */
    public ArrayList<Movie> getAll(){
        MovieManager movieManager = MovieManager.getInstance();
        return movieManager.getMovies();
    }
    
    /**
	 * Gets currently showing Movie.
	 *
	 * @return an ArrayList of Movie that are currently showing
	 */
    public ArrayList<Movie> getShowing(){
        Status showing = Status.Showing;// settings.getShowingValue()
        ArrayList<Movie> result = this.getAll();
        for(int i=0; i<result.size(); i++){
            if(result.get(i).getStatus() != showing){
                result.remove(i);
            }
        }
        return result;
    }

    /**
	 * Gets the top 5 movie by rating.
	 *
	 * @return the top 5 movie by rating
	 */
    public ArrayList<Movie> getTop5ByRating(){
        ArrayList<Movie> result = this.getAll();
        result.sort((m1, m2) -> {
            if(m1.getAvgRating() > m2.getAvgRating())
                return -1;
            if(m1.getAvgRating() < m2.getAvgRating())
                return 1;
            return 0;
        });
        for(int i=5; i<result.size(); i++){
            result.remove(i);
        }
        return result;
    }

    /**
	 * Gets the top 5 movies by sales.
	 *
	 * @return the top 5 movies by sales
	 */
    public ArrayList<Movie> getTop5BySales(){
        ArrayList<Movie> result = this.getAll();
        result.sort((m1, m2) -> {
            if(m1.getTotalSales() > m2.getTotalSales())
                return -1;
            if(m1.getTotalSales() < m2.getTotalSales())
                return 1;
            return 0;
        });
        for(int i=5; i<result.size(); i++){
            result.remove(i);
        }
        return result;
    }
}
