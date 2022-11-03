package entities;
//import java.util.ArrayArrayList;
import java.util.ArrayList;

public class Cineplex {
    private int CineplexID;
    private String CineplexName;
    private Cinema[] CinemaType;
    private ArrayList<Cinema> cinemas;
	private ArrayList<String> cinemaIDs;

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
    public ArrayList<Cinema> getCinemas() {
        return this.cinemas;
    }
	public ArrayList<String> getCinemaIDs() {
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

