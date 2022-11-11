package menus;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Movie;

public class MovieSelectorMenu {
    public static Scanner sc = new Scanner(System.in);

    public static Movie startMovieSelector(ArrayList<Movie> movies, String heading) {

        System.out.println(	"================ " +heading+ " =================");
                    for(int i = 0;  i < movies.size(); i++) {
                        System.out.println("("+i+1+")"+movies.get(i).getMovieName());
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

            if(selectedMovieInd == 0) return null;
            
            Movie selectedMovie = movies.get(selectedMovieInd); 
            selectedMovie.showDetails();

            System.out.println("Do you want to book? (y/n)");
            boolean wantBook = sc.nextLine().toLowerCase().charAt(0) == 'y';

            if(wantBook) {
                return selectedMovie;
            }

            return null;
    } 
}
