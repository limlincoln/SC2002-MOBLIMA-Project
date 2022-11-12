package menus;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Movie;

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
                sc.close();
                return null;
            } 
            
            Movie selectedMovie = movies.get(selectedMovieInd); 
            selectedMovie.showDetails();

            System.out.println("Do you want to book? (y/n)");
            sc.nextLine();
            boolean wantBook = sc.nextLine().toLowerCase().charAt(0) == 'y';

            if(wantBook) {
                sc.close();
                return selectedMovie;
            }
            sc.close();  
            return null;
    } 
}
