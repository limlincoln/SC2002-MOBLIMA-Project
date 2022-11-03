//import java.util.ArrayList;
import java.util.List;

public class Cineplex {
    private int CineplexID;
    private String CineplexName;
    private Cinema[] CinemaType;
    private List<Cinema> cinemas;
	private List<String> cinemaIDs;

    public Cineplex(int cID, String cName, Cinema[] cType){
        this.CineplexID = cID;
        this.CineplexName = cName;
        this.CinemaType = cType;
    }

    //get
    public int getCineplexID(){
        return this.CineplexID;
    }
    public String getCineplexName(){
        return this.CineplexName;
    }
    public Cinema[] getCinemaType(){
        return this.CinemaType;
    }
    public List<Cinema> getCinemas() {
        return this.cinemas;
    }
	public List<String> getCinemaIDs() {
        return this.cinemaIDs;
    }

    //set
    public void setCineplexID(int cID){
        this.CineplexID = cID;
    }
    public void setCineplexName(String cName){
        this.CineplexName = cName;
    }
    public void setCinemaType(Cinema[] cType){
        this.CinemaType = cType;
    }
}

