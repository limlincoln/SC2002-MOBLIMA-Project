package menu;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Cineplex;
import entities.Movie;

public class CineplexMenu {
    private static CineplexMenu single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

    private CineplexMenu(){}


    public static CineplexMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new CineplexMenu();
        return single_instance;
    }


	public void displayCineplexMenu(Movie movie) { 
		//CINEPLEX CLASS(MOVIE): returns list of cinplex that has that movie
    	Cineplex cineplex = new Cineplex(0, null, null);
    	System.out.println(	"================ SELECT A CINEPLEX =================");
    	//show a list of of existing cineplex that correspond to the movie
        int choice;
        			
        do {                
        	
        	System.out.println("Choose a Cineplex or enter 0 to exit : ");
                
            while (!sc.hasNextInt()) {
        		System.out.printf("Invalid input type.");
        		sc.next(); 
        	}
            choice = sc.nextInt();
            
            }while(choice  < 0 || choice >= 10);//movies.size()

          	//cineplex.get(subChoice)
        	
        	
            CinemaMenu.getInstance().displayCinemaMenu(movie,cineplex); 
            

		}
}
