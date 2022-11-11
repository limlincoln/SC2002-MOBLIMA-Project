package managers;
import java.util.ArrayList;
import java.util.Scanner;

//import entities.Movie;
//import managers.MovieManager;
import entities.ShowTime;

//need to filter by movie or cinplex??


public class ShowTimeManager{
    private static ShowTimeManager single_instance = null;
    //private ArrayList<Movie> movies;
    private ArrayList<ShowTime> ShowTimes;
    private Scanner sc = new Scanner(System.in);
// FUNCTIONALITY
// SHOW ShowTime FOR A PARTICULAR MOVIE & DAY & CINEPLEX & CINEMA
// RETURN ARRAY OF ShowTime

// FINDSEATS:
// FIND THE SEATS FROM CINEMA CLASS USING ShowTime SLOT INDEX

    // Initialisers
    private ShowTimeManager(){}
    public static ShowTimeManager getInstance()
    {
        if (single_instance == null)
            single_instance = new ShowTimeManager();
        return single_instance;
    }

    // Getters
    public ArrayList<ShowTime> getShowTimes(){
        return this.ShowTimes;
    }
    public ShowTime getShowTimeByID(int sID){
        for(int x = 0; x < ShowTimes.size(); x++){
            if(ShowTimes.get(x).getShowTimeID() == sID){
                return ShowTimes.get(x);
            }
        }
        return null;
    }
    
    // Setters
    public void setShowTime(ArrayList<ShowTime> stime){
        this.ShowTimes = stime;
    }

    // Methods
    // Add ShowTimes
    public void addShowTime(ShowTime stime){
        for(int x = 0; x < ShowTimes.size(); x++){
            ShowTime current = ShowTimes.get(x);
            if(current.getShowTimeID() == stime.getShowTimeID() 
               || current.getShowTimeID()==stime.getShowTimeID()){
                System.out.println("ShowTime already exist!");
                return;
            }
        }
        ShowTimes.add(stime);
        System.out.println("ShowTime successfully added!");
    }
}