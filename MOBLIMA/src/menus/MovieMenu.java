package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Customer;
import entities.Staff;
import entities.Movie;
//import java.time.format.DateTimeFormatter;

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
            
            switch(choice){
                case 1:
                	// should show only now showing movie list?
                	ArrayList<Movie> movies = new ArrayList<Movie>();
                    int subChoice;
                    for (int i = 0; i < movies.size(); i++) {
                    	System.out.print("Index"+ i+1 + " ");  movies.get(i).showDetails();
                    	}
                    do {
                    	System.out.println("Choose a movie or enter 0 to exit : ");
                            
                        while (!sc.hasNextInt()) {
                    		System.out.printf("Invalid input type.");
                    		sc.next(); 
                    	}
                        subChoice = sc.nextInt()-1;
                        
                        }while(subChoice  < 0 || subChoice >= 10);//movies.size()
                    	
                        Movie testmovie = null;
                        System.out.println("Enter number of adults tickets : ");
                        int noadult = sc.nextInt();
                        System.out.println("Enter number of children tickets : ");
                        int nochild = sc.nextInt();
                        
                        CinemaMenu.getInstance().displayCinemaMenu(testmovie, nochild, noadult);
                        //BookingMenu.getInstance().showSeats(testmovie,calculated);

                    break;
                    
                    
                    
                case 2:
                	// List top 5 movies
                	ArrayList<Movie> topmovies = new ArrayList<Movie>();
                	topmovies.get(0).showDetails();
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
	
	public void displayStaffMovieMenu() {
		int choice;

		
		do {
            System.out.println(	"============== MOBLIMA STAFF APP ================\n" +
			                    " 1. Edit Movie          					        \n" +
			                    " 2. Add Movie                                     \n" +
			                    " 3. Delete Movie                                  \n" +
			                    " 0. Back to MOBLIMA APP                           \n"+
							    "====================================================");
	    	
            System.out.println("Enter choice: ");
            
            while (!sc.hasNextInt()) {
            	System.out.println("Invalid input type. Please enter an integer value.");
        		sc.next(); 
            }
            
            choice = sc.nextInt();
            
            switch(choice){
                case 1:
                	// EDIT MOVIE
                    break;
                case 2:
                	// ADD MOVIE
                    break;
                case 3:
                	// DELETE MOVIE
                    break;
                case 0:
                	System.out.println("Back to MOBLIMA APP......");
                	break;
                default: 
                	System.out.println("Invalid choice.");
                	break;
	            }
	        } while (choice != 0);
		}


}
