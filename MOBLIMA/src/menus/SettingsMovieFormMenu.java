package menus;
import enums.CinemaType;
import enums.Status;
import java.util.ArrayList;
import java.util.Scanner;

public class SettingsMovieFormMenu {
    /* 
    public static Movie startFullForm(){
        int movieID;
        String movieName;
        CinemaType genre;
        Status status;
        ArrayList<String> casts;
        String director;
        String sypnopsis;
        ArrayList<Integer> ratings;
        double totalSales;
        Float avgRating;
        return movie;
    }*/

    /**
     * MovieID form
     * @return movie ID
     */
    public static int startMovieIDForm(){
        int movieID;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter movie ID: ");
        movieID = sc.nextInt();
        return movieID;
    }
    /**
     * MovieName form
     * @return movie Name
     */
    public static String startMovieNameForm(){
        String movieName;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter movie Name: ");
        movieName = sc.nextLine();
        return movieName;
    }
    /**
     * Genre form
     * @return Cinema Type
     */
    public static CinemaType startGenreForm(){
        CinemaType cType;
        String ctypes;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter cinema type: ");
        ctypes = sc.nextLine();
        cType = Enum.valueOf(CinemaType.class,ctypes);
        return cType;
    }
    /**
     * Status form
     * @return Movie's Status
     */
    public static Status startStatusForm(){
        Status status;
        String statuss;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter cinema type: ");
        statuss = sc.nextLine();
        status = Enum.valueOf(Status.class,statuss);
        return status;
    }
    /**
     * Cast form
     * @return Movie's Cast
     */
    public static ArrayList<String> startCastForm(){
        ArrayList<String> cast = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        String choice = "";
        do {
            System.out.println("Please enter the new cast name: ");
            choice = sc.nextLine();
            cast.add(choice);
        }while (choice != "0");
        return cast;
    }
    /**
     * Director form
     * @return Movie's Director
     */   
    public static String startDirectorForm(){
        String director;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Director Name: ");
        director = sc.nextLine();
        return director;
    }
    /**
     * Synopsis form
     * @return Movie's Synopsis
     */ 
    public static String startSynopsisForm(){
        String synopsis;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Synopsis: ");
        synopsis = sc.nextLine();
        return synopsis;
    }
}
