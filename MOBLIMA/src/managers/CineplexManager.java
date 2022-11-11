package managers;
import java.util.ArrayList;
import entities.Cineplex;

public class CineplexManager {
    private static CineplexManager single_instance = null;
    private ArrayList<Cineplex> cineplex;

    // Initialiser
    private CineplexManager(){}

    public static CineplexManager getInstance()
    {
        if (single_instance == null)
            single_instance = new CineplexManager();
        return single_instance;
    }

    // Setters
    public void setCineplex(ArrayList<Cineplex> cine){
        this.cineplex = cine;
    }

    // Getters
    public ArrayList<Cineplex> getCineplexs(){
        return this.cineplex;
    }

    public Cineplex getCineplexByID(int cineID){
        for (int x = 0; x <cineplex.size(); x++){
            if (cineplex.get(x).getCineplexID() == cineID){
                return cineplex.get(x);
            }
        }
        return null;
    }

    public Cineplex getCineplexByName(String cineName){
        for(int x = 0; x< cineplex.size(); x++){
            if(cineplex.get(x).getCineplexName() == cineName){
                return cineplex.get(x);
            }
        }
        return null;
    } 

    // Methods
    // add new Cineplex
    public void addCineplex(Cineplex cine){
        for(int x = 0; x < cineplex.size(); x++){
            Cineplex current = cineplex.get(x);
            if(current.getCineplexName() == cine.getCineplexName() 
               || current.getCineplexID() == cine.getCineplexID()){
                System.out.println("Cineplex already exist!");
                return;
            }
        }
        cineplex.add(cine);
        System.out.println("Cineplex successfully added!");
    }

    // remove cineplex by ID
    public void removeCineplexByID(int cineID){
        for(int x = 0; x < cineplex.size(); x++){
            if(cineplex.get(x).getCineplexID() == cineID){
                cineplex.remove(x);
                System.out.println("Successfully removed Cineplex with ID: "+ cineID);
                return;
            }
        }
        System.out.println("Cineplex with ID: "+ cineID + " does not exist!");
    }
    
    // remove Cineplex by name
    public void removeCineplexByName(String cineName){
        for(int x = 0; x < cineplex.size(); x++){
            if(cineplex.get(x).getCineplexName() == cineName){
                cineplex.remove(x);
                System.out.println("Successfully removed: "+ cineName);
            }
        }
        System.out.println(cineName + " does not exist!");
    }

    // consolidate which cineplex have particular, take in movie ID and see which cineplex have that ID
    // search cineplexs for movieID

    // consolidate which cinema in that cineplex have movieID
}
