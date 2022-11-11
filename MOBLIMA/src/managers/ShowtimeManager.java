package managers;
import java.util.ArrayList;
//import entities.Movie;
//import managers.MovieManager;
import entities.Showtime;

//need to filter by movie or cinplex??


public class ShowtimeManager{
    private static ShowtimeManager single_instance = null;
    //private ArrayList<Movie> movies;
    private ArrayList<Showtime> showtimes;
    private Scanner sc = new Scanner(System.in);
// FUNCTIONALITY
// SHOW SHOWTIME FOR A PARTICULAR MOVIE & DAY & CINEPLEX & CINEMA
// RETURN ARRAY OF SHOWTIME

// FINDSEATS:
// FIND THE SEATS FROM CINEMA CLASS USING SHOWTIME SLOT INDEX

    // Initialisers
    private ShowtimeManager(){}
    public static ShowtimeManager getInstance()
    {
        if (single_instance == null)
            single_instance = new ShowtimeManager();
        return single_instance;
    }

    // Getters
    public ArrayList<Showtime> getShowtimes(){
        return this.showtimes;
    }
    public Showtime getShowtimeByID(int sID){
        for(int x = 0; x < showtimes.size(); x++){
            if(showtimes.get(x).getShowtimeID() == sID){
                return showtimes.get(x);
            }
        }
        return null;
    }
    
    // Setters
    public void setShowtime(ArrayList<Showtime> stime){
        this.showtimes = stime;
    }

    // Methods
    // Add showtimes
    public void addShowtime(Showtime stime){
        for(int x = 0; x < showtimes.size(); x++){
            Showtime current = showtimes.get(x);
            if(current.getShowtimeID() == stime.getShowtimeID() 
               || current.getShowtimeID()==stime.getShowtimeID()){
                System.out.println("Showtime already exist!");
                return;
            }
        }
        showtimes.add(stime);
        System.out.println("Showtime successfully added!");
    }
}