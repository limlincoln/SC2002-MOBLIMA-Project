package managers;
import java.util.ArrayList;
import entities.Cinema;

public class CinemaManager {
    private static CinemaManager single_instance = null;
    private ArrayList<Cinema> cinemas;
    // 1 week worth of showtimes
    // array list of showimes

    // Initialisers
    private CinemaManager(){}
    public static CinemaManager getInstance()
    {
        if (single_instance == null)
            single_instance = new CinemaManager();
        return single_instance;
    }

    // Getters
    public ArrayList<Cinema> getCinemas() {
        return this.cinemas;
    }

    public Cinema getCinemaByID(int cineID){
        for(int x = 0; x < cinemas.size(); x++){
            if(cinemas.get(x).getCinemaID() == cineID){
                return cinemas.get(x);
            }
        }
        return null;
    }

    public Cinema getCinemaByName(String cineName){
        for(int x = 0; x < cinemas.size(); x++){
            if(cinemas.get(x).getCinemaName() == cineName){
                return cinemas.get(x);
            }
        }
        return null;
    }

    // Setters
    public void setCinema(ArrayList<Cinema> cine) {
        this.cinemas = cine;
    }

    // Methods 
    public void addCinema(Cinema cine){
        for(int x = 0; x < cinemas.size(); x++){
            Cinema current = cinemas.get(x);
            if(current.getCinemaName() == cine.getCinemaName() 
               || current.getCinemaID() == cine.getCinemaID()){
                System.out.println("Cinema already exist!");
                return;
            }
        }
        cinemas.add(cine);
        System.out.println("Cinema successfully added!");
    }

    public void removeCinemaByID(int cineID){
        for(int x = 0; x < cinemas.size(); x++){
            if(cinemas.get(x).getCinemaID() == cineID){
                cinemas.remove(x);
                System.out.println("Successfully removed movie with ID: "+ cineID);
                return;
            }
        }
        System.out.println("Movie with ID: "+ cineID + " does not exist!");
    }
    
    public void removeCinemaByName(String cineName){
        for(int x = 0; x < cinemas.size(); x++){
            if(cinemas.get(x).getCinemaName() == cineName){
                cinemas.remove(x);
                System.out.println("Successfully removed: "+ cineName);
            }
        }
        System.out.println(cineName+ " does not exist!");
    }  
}
