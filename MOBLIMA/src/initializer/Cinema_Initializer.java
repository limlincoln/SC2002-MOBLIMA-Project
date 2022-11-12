package initializer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import entities.Cinema;
import entities.Movie;
import entities.ShowTime;
import enums.CinemaType;
import enums.MovieType;

// TODO: Auto-generated Javadoc
/**
 * The Class Cinema_Initializer.
 */
public class Cinema_Initializer extends GetDatabaseDirectory {
	
	/**
	 * Sets the cinema file name.
	 *
	 * @param Receives the cinemaid as an argument
	 * Appending the cinemaid to the front of the text file
	 * @returns the name of the new file
	 */
	public static String setCinemaFileName(int cinemaid) {

		String seatingsfolder = "\\Cinema\\";

		final String DBfile = "Cinema.txt";

		return(seatingsfolder+cinemaid+DBfile);
	}
	
	/**
	 * Creates the cinemas file.
	 *
	 * @param Receives the cinemaid as an argument
	 * Check if a separate directory to contain the cinema files are created
	 * Creates the directory to contain all the cinema files if it does not exist
	 */
	public static void CreateCinemaFile(int cinemaid) {

		String currentDirectory;
		String newDirectory;
		boolean checkfileexists = false;

		ShowTime_Initializer showtime_init = new ShowTime_Initializer();
		currentDirectory = showtime_init.getCurrentDirectory();

		newDirectory = currentDirectory;
		String SeatingsFile = setCinemaFileName(cinemaid);

		File create_cinema_file = new File(newDirectory);

		try {
			if(!create_cinema_file.exists()) {
				create_cinema_file.mkdirs();
			}
			create_cinema_file = new File(newDirectory + SeatingsFile);
			checkfileexists = create_cinema_file.createNewFile();
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(create_cinema_file.getPath());
	}
	
	/**
	 * Read cinema file from //Database/Cinema.
	 *
	 * @param Receives the cinemaid as an argument
	 * cinemaid is used to recognize which file is to be read
	 * Initialize cinema classes with the information from text
	 */
	public static void ReadCinemaFile(int cid) {
		ArrayList<Cinema> cinemalist = new ArrayList<Cinema>();
		
		String currentDirectory;
		String newDirectory;
		String new_movie;
		
		String cinemaid, cinemaname, cinematype, stime;
		MovieType cType = null;
		
		Cinema_Initializer cinema_init = new Cinema_Initializer();
		currentDirectory = cinema_init.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		File cinema_file = new File(newDirectory);
		
		File movielisting_file = new File(newDirectory);
		
		String ShowCinemaFile = setCinemaFileName(cid);
		
		try {		
			BufferedReader br = new BufferedReader(new FileReader(newDirectory + ShowCinemaFile));
			
			while(true) {
				final String line = br.readLine();

				if(line == null) {
					break;
				}
				
				String []data = line.split("\\|");
				
				cinemaid = data[0];
				Integer CinemaID = Integer.parseInt(cinemaid);
				
				cinematype = data[1];
				switch(cinematype){
				
				case "IMAX":
					cType = MovieType.IMAX;
					break;
					
				case "_3D":
					cType = MovieType._3D;
					break;
					
				case "NORMAL":
					cType = MovieType.NORMAL;
					break;
				}
				
				ArrayList<ShowTime> showtimelist = new ArrayList<ShowTime>();
				stime = data[8];
				String[] arr=stime.replaceAll("\\[|\\]| ", "").split(",");
		        for(int i=0;i<arr.length;i++){

		        	//showtimelist.add(Integer.parseInt(arr[i]));
		        }
		        
		        //Initialize here
		        //cinemalist.add(new Cinema(CinemaID, cType, showtimelist));				
				
			}
			
		} catch (Exception e) {
			
		}
	}
		
	/**
	 * Saves the cinema classes to text file.
	 *
	 * @param cid - cinema id
	 * @param cType - the type of cinema
	 * @param sTime - ArrayList of ShowTime
	 * 
	 * With the above arguments, saves them to a text file
	 */
	public static void WriteCinemaFile(int cid, CinemaType cType, ArrayList<ShowTime> sTime) {
		String currentDirectory;
		String newDirectory;
		
		String showid, showtime, seatid;
		
		Cinema_Initializer cinema_init = new Cinema_Initializer();
		currentDirectory = cinema_init.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		File cinemalisting_file = new File(newDirectory);
		
		String ShowCinemaFile = setCinemaFileName(cid);
		
		try {
			FileWriter write_showtime = new FileWriter((newDirectory + ShowCinemaFile));
			
			if(cinemalisting_file.exists()) {
				BufferedWriter buffer = new BufferedWriter(write_showtime);
				
				String cinematype = "" + cType;
				
		        switch(cinematype){
				case "IMAX":
					cinematype = "IMAX";
					break;
					
				case "_3D":
					cinematype = "_3D";
					break;
					
				case "NORMAL":
					cinematype = "NORMAL";
					break;
				}
				
				String newcinema = cid + "|" + cinematype + "|" + sTime;
				
				buffer.write(newcinema);
				buffer.close();
				
			}
		} catch (Exception e) {
			
		}
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * 
	 * Created to test the individual functions
	 */
	public static void main(String[] args) {
		
		Cinema_Initializer cinema_init = new Cinema_Initializer();
		
		cinema_init.CreateCinemaFile(7);
	}

}
