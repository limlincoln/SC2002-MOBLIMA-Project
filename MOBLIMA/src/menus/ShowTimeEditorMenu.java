package menus;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Cinema;
import entities.Cineplex;
import entities.Movie;
import entities.ShowTime;
import enums.DayOfWeek;
import managers.CineplexManager;
import managers.MovieManager;

public class ShowTimeEditorMenu {
    public static void startShowTimeEditor() {
        Cineplex cineplex = CineplexSelectorMenu.getInstance().startSelector(CineplexManager.getInstance().getCineplexs(), "Select a Cinplex");
        Cinema cinema = CinemaSelectorMenu.getInstance().startSelector(cineplex.getCinemas(), "Select a Cinema");
        ArrayList<ShowTime> showtimes = cinema.getShowtimes();

        System.out.println("Enter the day for which you would like to edit your showtimes: ");
        int index = 1;
        for(DayOfWeek day: DayOfWeek.values()) {
            System.out.println("("+index+")" +day);
            index++;
        }

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            choice = sc.nextInt();
        } while(choice < 1 || choice > DayOfWeek.values().length);

        int[] listofshowtime = showtimes.get(choice-1).getShowTime();
        String[] timings = {
                "0000-0300",
                "0300-0600",
                "0600-0900",
                "0900-1200",
                "1200-1500",
                "1500-1800",
                "1800-2100",
                "2100-0000"
            };
    	for(int i=0; i < listofshowtime.length; i++)
    	{
            
            Movie movie = MovieManager.getInstance().getMovieByID(listofshowtime[i]);
            if(movie == null) {
                System.out.println("("+(i+1)+")"+" TIMING : " + timings[i] + "  ");
            } else {
                System.out.println("("+(i+1)+")"+" TIMING : " + timings[i] + " " + movie.getMovieName());
            }
    	}

    	int subChoice;
        do {
        	
        	System.out.println("Choose a movie at the allocated timing or enter 0 to exit : ");
                
            while (!sc.hasNextInt()) {
        		System.out.printf("Invalid input type.");
        		sc.next(); 
        	}
            subChoice = sc.nextInt();
            
            }while(subChoice  < 0 || subChoice > listofshowtime.length);
        
        if(subChoice == 0) return;

        int newmovieid;
        boolean reAsk = false;
        do {
            System.out.print("Replace with (Enter a new movie ID or -1 to remove):");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input type. Please try again!");
                sc.next(); 
            }
            newmovieid = sc.nextInt();

            reAsk = newmovieid != -1 && MovieManager.getInstance().getMovieByID(newmovieid) == null ;
            if(reAsk) {
                System.out.println("Please enter a valid movie ID");
            }
        } while(reAsk);
        
        listofshowtime[subChoice-1] = newmovieid;
        showtimes.get(choice-1).setShowTime(listofshowtime);     
    }
    
}
