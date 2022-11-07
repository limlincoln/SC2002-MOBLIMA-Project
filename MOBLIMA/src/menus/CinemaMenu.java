package menu;
import java.time.format.DateTimeFormatter; 
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import entities.Movie;
import entities.Cinema;
import entities.Cineplex;

public class CinemaMenu {
    private static CinemaMenu single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

    private CinemaMenu(){}


    public static CinemaMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new CinemaMenu();
        return single_instance;
    }


	public void displayCinemaMenu(Movie movie, int child,int adult) {
		int choice;
		System.out.println("Number of Adults:"+adult);//just to check
		System.out.println("Number of child:" +child);//just to check
		
		
    	

        do {
        	
			        System.out.println(	"============== SELECT A CINEPLEX =========\n" +
		            " 1. IMAX			     					        \n" +
		            " 2. 3D				                               \n" +
		            " 3. Normal				                           \n"+
				    "====================================================");
			
		    System.out.println("Enter choice: ");
                
            while (!sc.hasNextInt()) {
        		System.out.printf("Invalid input type.");
        		sc.next(); 
        	}
            choice = sc.nextInt();
            
            }while(choice  < 0 || choice >= 3);
        	int  arrayOfFixDatetime[] = new int[]{1123,3122,3123,1324,5123};;
        	System.out.println("Selected Cineplex : " + choice);
        	Cinema cinetest = new Cinema(1,choice,arrayOfFixDatetime);
        	
        	

            
		//print all cinema types based on movie
//		Cinema cin = null;
//		cin.getMovies().get(movie.getMovieID());
//		cin.getShowTime(); // calculate it based on showtime
//		cin.getCinemaType(); // calculate based on cinematype
		 
		//Pass to ticket class for (weekday weekend/ timing / age)
		
		
		
		double calculated = child + adult;
		BookingMenu.getInstance().showSeats(movie,cinetest,calculated);

		}
	public void movielisting() {
		//edit cinema
		int choice;
		do {
	        System.out.println(	"======= MOBLIMA STAFF EDIT MOVIE LISTING ==========\n" +
	                " 1. Edit Showtime                                    \n" +
	                " 2. Edit Cineplex                                    \n" +
	                " 3. Edit Cinema                                     \n" +
	                " 0. Back to MOBLIMA APP                              \n"+
				    "====================================================");
    		System.out.println("Enter choice: ");
            
            while (!sc.hasNextInt()) {
            	System.out.println("Please enter an integer value or correct value.");
        		sc.next(); 
            }
            
            choice = sc.nextInt();
            
            switch(choice){
                case 1:
                	//edit showtime
                    break;
                case 2:
                	//edit cineplex
                    break;
                case 3:
                	//edit cinema
                	break;
                case 0:
                	System.out.println("Back to MOBLIMA APP......");
                	break;
                default: 
                	System.out.println("Please enter an integer value or correct value.");
                	break;
	            }
	        } while (choice != 0);

        		
		}
	
	

}
