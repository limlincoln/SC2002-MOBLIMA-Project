package menus;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Movie;
import enums.Status;
import utils.ConvertDouble;

public class MovieSelectorMenu implements ISelectorMenu<Movie> {
    public static MovieSelectorMenu single_instance = null;

    private MovieSelectorMenu() {}

    public static MovieSelectorMenu getInstance() {
        if(single_instance == null) {
            single_instance = new MovieSelectorMenu();
        }
        return single_instance;
    }

    /**
     * Select movie
     */
    public Movie startSelector(ArrayList<Movie> movies, String heading) {
        if(movies.size() == 0){
            System.out.println("NO "+ heading);
            System.out.println("");
            return null;
        }
        Scanner sc = new Scanner(System.in);
        
        System.out.println(	"================ " +heading+ " =================");
                    for(int i = 0;  i < movies.size(); i++) {
                        Movie cur = movies.get(i);
                        if(cur.getStatus() == Status.EndOfShowing){
                            continue;
                        }
                        System.out.println("("+(i+1)+")"+cur.getMovieName()+ " | Status: " + cur.getStatus() + " | Sales: " + ConvertDouble.convert(cur.getTotalSales()) + " | Average Rating: " + ConvertDouble.convert(cur.getAvgRating()));
        }

        int selectedMovieInd;
        do {
            System.out.println("Choose a movie or enter 0 to exit : ");
                
            while (!sc.hasNextInt()) {
                System.out.printf("Invalid input type.");
                sc.next(); 
            }
            selectedMovieInd = sc.nextInt()-1;
            
        }while(selectedMovieInd  < -1 || selectedMovieInd >= movies.size());

        if(selectedMovieInd == -1){
            return null;
        } 
        
        Movie selectedMovie = movies.get(selectedMovieInd); 
        selectedMovie.showDetails();

        if(selectedMovie.getStatus() == Status.ComingSoon){
            return null;
        }

        System.out.println("Do you want to book? (y/n)");
        sc.nextLine();
        boolean wantBook = sc.nextLine().toLowerCase().charAt(0) == 'y';

        if(wantBook) {
            return selectedMovie;
        } 
        return null;
    } 
    
    public Movie staffSelector(ArrayList<Movie> movies, String heading) {
        Scanner sc = new Scanner(System.in);
        System.out.println(	"================ " +heading+ " =================");
                    for(int i = 0;  i < movies.size(); i++) {
                        System.out.println("("+(i+1)+")"+movies.get(i).getMovieName());
        }

        int selectedMovieInd;
        do {
            System.out.println("Choose a movie or enter 0 to exit : ");
                
            while (!sc.hasNextInt()) {
                System.out.printf("Invalid input type.");
                sc.next(); 
            }
            selectedMovieInd = sc.nextInt()-1;
            
            }while(selectedMovieInd  < 0 || selectedMovieInd >= movies.size());

            if(selectedMovieInd == 0){
                return null;
            } 
            
            Movie selectedMovie = movies.get(selectedMovieInd); 
            selectedMovie.showDetails();

            System.out.println("Do you want to change this movie? (y/n)");
            sc.nextLine();
            boolean wantBook = sc.nextLine().toLowerCase().charAt(0) == 'y';

            if(wantBook) {
                return selectedMovie;
            }
            return null;
    } 
}
