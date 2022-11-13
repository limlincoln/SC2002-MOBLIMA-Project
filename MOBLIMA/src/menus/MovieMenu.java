package menus;

import java.util.ArrayList;
import java.util.Scanner;

import consolidators.MovieConsolidator;
import managers.SettingsManager;
import entities.Movie;
/**
 * Menu to display movie 
 */
public class MovieMenu {
    /** 
     * Single instance of MovieMenu 
     */
    private static MovieMenu single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

    private MovieMenu(){}
    /**
     * Get or creates the single instance of MovieMenu class
     * @return MovieMenu Class
     */
    public static MovieMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new MovieMenu();
        return single_instance;
    }
    
    /**
     * Customer Movie App
     */
	public void displayCustomerMovieMenu() {
		int choice;
		
		do {
            System.out.println(	"============== MOBLIMA CUSTOMER MOVIE APP =========\n" +
                                " 1. Search movie        					        \n" +
			                    " 2. List all movies     					        \n" +
			                    " 3. List top 5 movie                               \n" +
			                    " 0. Back to MOBLIMA APP                           \n"+
							    "====================================================");
	    	
            System.out.println("Enter choice: ");
            
            while (!sc.hasNextInt()) {
            	System.out.println("Invalid input type. Please enter an integer value.");
        		sc.next(); 
            }
            
            choice = sc.nextInt();
            sc.nextLine();

            String heading;
            Movie selectedMovie;
            ArrayList<Movie> movies;
            switch(choice){
                case 1:
                    System.out.println("(1) Enter Movie Name: ");
                    String movieName = sc.nextLine();
                    movies = new ArrayList<Movie>();
                    selectedMovie = MovieConsolidator.getInstance().getMovieByName(movieName);
                    movies.add(selectedMovie);
                    heading = "SEARCH RESULTS";
                    selectedMovie = MovieSelectorMenu.getInstance().startSelector(movies, heading);

                    if(selectedMovie != null) {
                        CineplexMenu.getInstance().displayCineplexMenu(selectedMovie);
                    }
                    break;
                case 2:
                	// should show only now showing movie list?
                	movies = new ArrayList<Movie>();
                    movies = MovieConsolidator.getInstance().getAvaliable();
                    
                    heading = "MOVIES";
                    selectedMovie = MovieSelectorMenu.getInstance().startSelector(movies, heading);

                    if(selectedMovie != null) {
                        CineplexMenu.getInstance().displayCineplexMenu(selectedMovie);
                    }
                    break;
                    
                case 3:
                	ITop5Menu top5Menu = SettingsManager.getInstance().getCustomerTop5MenuClass();
                    top5Menu.displayMenu();
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
