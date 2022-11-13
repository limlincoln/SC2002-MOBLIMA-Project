package managers;

import java.util.ArrayList;
import entities.Movie;

/**
 * Class that manages all things related to Movies and contains a list of movies from the database
 */
public class MovieManager {
    /**
     * a single instance for this class
     */
    private static MovieManager single_instance = null;

    /**
     * a list of all the movies from the database
     */
    private ArrayList<Movie> movies;

    /**
     * constructor for this class
     * @param movies the movies to store in the manager
     */
    private MovieManager(ArrayList<Movie> movies){
        this.movies = movies;
    }

    /**
     * initialize the movies list 
     * @param movies movies to initialize the movies list with
     */
    public static void initialize(ArrayList<Movie> movies){
        single_instance = new MovieManager(movies);
    }

    /**
     * get an instance of this class
     * @return a MovieManager object
     */
    public static MovieManager getInstance()
    {
        return single_instance;
    }

    // GETTERS and SETTERS
    public ArrayList<Movie> getMovies() {
        return this.movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    /**
     * Get the movie based on the movie ID being inputted
     * @param movieId the movie ID to use
     * @return the movie
     */
    public Movie getMovieByID(int movieId){
        for(int i=0; i<movies.size(); i++){
            if(movies.get(i).getMovieID() == movieId){
                return movies.get(i);
            }
        }
        return null;
    }
    
    /**
     * Get the movie based on the movie name bring inputted
     * @param movieName the movie name to use
     * @return the movie
     */
    public Movie getMovieByName(String movieName){
        for(int i=0; i<movies.size(); i++){
            if(movies.get(i).getMovieName() == movieName){
                return movies.get(i);
            }
        }
        return null;
    }

    /**
     * Add new movie to existing list
     * @param movie movie to add
     */
    public void addMovie(Movie movie){
        for(int i=0; i<movies.size(); i++){
            Movie cur = movies.get(i);
            if(cur.getMovieName() == movie.getMovieName() || cur.getMovieID()==movie.getMovieID()){
                System.out.println("Movie already exist!");
                return;
            }
        }
        movies.add(movie);
        System.out.println("Movie successfully added!");
    }

    /**
     * Remove movie based on the inputted ID
     * @param movieId the ID of the movie to remove
     */
    public void removeMovieByID(int movieId){
        for(int i=0; i<movies.size(); i++){
            if(movies.get(i).getMovieID() == movieId){
                movies.remove(i);
                System.out.println("Successfully removed movie with ID: "+ movieId);
                return;
            }
        }
        System.out.println("Movie with ID: "+ movieId + " does not exist!");
    }
    
    /**
     * * Remove movie based on the inputted name
     * @param movieName the name of the movie to remove
     */
    public void removeMovieByName(String movieName){
        for(int i=0; i<movies.size(); i++){
            if(movies.get(i).getMovieName() == movieName){
                movies.remove(i);
                System.out.println("Successfully removed: "+ movieName);
            }
        }
        System.out.println(movieName+ " does not exist!");
    }
}

   
