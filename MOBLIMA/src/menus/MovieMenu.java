package menus;

import java.util.ArrayList;
import java.util.Scanner;

import consolidators.MovieConsolidator;
import managers.SettingsManager;
import entities.Movie;

public class MovieMenu {
    private static MovieMenu single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

    private MovieMenu(){}


    public static MovieMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new MovieMenu();
        return single_instance;
    }
    
	public void displayCustomerMovieMenu() {
		int choice;
		
		do {
            System.out.println(	"============== MOBLIMA CUSTOMER MOVIE APP =========\n" +
			                    " 1. List all movies     					        \n" +
			                    " 2. List top 5 movie                               \n" +
			                    " 0. Back to MOBLIMA APP                           \n"+
							    "====================================================");
	    	
            System.out.println("Enter choice: ");
            
            while (!sc.hasNextInt()) {
            	System.out.println("Invalid input type. Please enter an integer value.");
        		sc.next(); 
            }
            
            choice = sc.nextInt();

            String heading;
            Movie selectedMovie;
            switch(choice){
                case 1:
                	// should show only now showing movie list?
                	ArrayList<Movie> movies = new ArrayList<Movie>();
                    movies = MovieConsolidator.getInstance().getShowing();
                    
                    heading = "MOVIES";
                    selectedMovie = MovieSelectorMenu.startMovieSelector(movies, heading);

                    if(selectedMovie != null) {
                        CineplexMenu.getInstance().displayCineplexMenu(selectedMovie);
                    }

                    break;
                    
                case 2:
                	// List top 5 movies
                	ArrayList<Movie> topmovies = new ArrayList<Movie>();
                	int options = SettingsManager.getInstance().getCustomerTop5();
                    switch(options) {
                        case 0:
                            heading = "TOP 5 MOVIES BY SALES";
                            topmovies = MovieConsolidator.getInstance().getTop5BySales();

                            selectedMovie = MovieSelectorMenu.startMovieSelector(topmovies, heading);
                            
                            if (selectedMovie != null) {
                                CineplexMenu.getInstance().displayCineplexMenu(selectedMovie); 
                            }
                            break;

                        case 1:
                            heading = "TOP 5 MOVIES BY RATING";
                            topmovies = MovieConsolidator.getInstance().getTop5ByRating();

                            selectedMovie = MovieSelectorMenu.startMovieSelector(topmovies, heading);
                            
                            if (selectedMovie != null) {
                                CineplexMenu.getInstance().displayCineplexMenu(selectedMovie); 
                            }
                            break; 

                        case 2:
                            System.out.println("(1) By Sales");
                            System.out.println("(2) By Rating");

                            int ratingChoice;
                            do {
                                ratingChoice = sc.nextInt();
                            } while(ratingChoice < 1 || ratingChoice > 2);
                            
                            // DO THIS LATER
                    }
                    break;
                case 0:
                	System.out.println("Back to MOBLIMA APP");
                	break;
                default: 
                	System.out.println("Please enter an integer value or correct value.");
                	break;
	            }
	        } while (choice != 0);
		}
}
