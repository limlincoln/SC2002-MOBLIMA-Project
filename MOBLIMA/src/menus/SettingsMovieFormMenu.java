package menus;
import entities.Movie;
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

    public static int startMovieIDForm(){
        int movieID;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter movie ID: ");
        movieID = sc.nextInt();
        sc.close();
        return movieID;
    }

    public static String startMovieNameForm(){
        String movieName;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter movie Name: ");
        movieName = sc.nextLine();
        sc.close();
        return movieName;
    }

    public static CinemaType startGenreForm(){
        CinemaType cType;
        String ctypes;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter cinema type: ");
        ctypes = sc.nextLine();
        cType = Enum.valueOf(CinemaType.class,ctypes);
        sc.close();
        return cType;
    }

    public static Status startStatusForm(){
        Status status;
        String statuss;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter cinema type: ");
        statuss = sc.nextLine();
        status = Enum.valueOf(Status.class,statuss);
        sc.close();
        return status;
    }

    public static ArrayList<String> startCastForm(){
        ArrayList<String> cast;
        Scanner sc = new Scanner(System.in);

        sc.close();
        return cast;
    }

    public static String startDirectorForm(){
        String director;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Director Name: ");
        director = sc.nextLine();
        sc.close();
        return director;
    }

    public static String startSynopsisForm(){
        String synopsis;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Synopsis: ");
        synopsis = sc.nextLine();
        sc.close();
        return synopsis;
    }
}
