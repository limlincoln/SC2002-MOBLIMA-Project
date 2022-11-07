package managers;

import java.util.ArrayList;
import entities.Movie;



public class MovieManager {
    private static MovieManager single_instance = null;
    private ArrayList<Movie> movies;

    private MovieManager(ArrayList<Movie> movies){
        this.movies = movies;
    }
    public static void instantiateMovies(ArrayList<Movie> movies){
        single_instance = new MovieManager(movies);
    }

    public static MovieManager getInstance()
    {
        return single_instance;
    }

    public ArrayList<Movie> getMovies() {
        return this.movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public Movie getMovieByID(int movieId){
        for(int i=0; i<movies.size(); i++){
            if(movies.get(i).getMovieID() == movieId){
                return movies.get(i);
            }
        }
        return null;
    }
    
    public Movie getMovieByName(String movieName){
        for(int i=0; i<movies.size(); i++){
            if(movies.get(i).getMovieName() == movieName){
                return movies.get(i);
            }
        }
        return null;
    }

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

   
