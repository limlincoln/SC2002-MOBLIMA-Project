package initializer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import entities.Movie;
import entities.Seats;
import entities.ShowTime;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowTime_Initializer.
 */
public class ShowTime_Initializer extends GetDatabaseDirectory {

	/**
	 * Sets the show time file name.
	 *
	 * @param showtimeid - unique id for each showtime
	 * @return the unique file for each showtime
	 */
	public static String setShowTimeFileName(int showtimeid) {

		String seatingsfolder = "\\ShowTime\\";

		final String DBfile = "ShowTime.txt";

		return(seatingsfolder+showtimeid+DBfile);
	}

	/**
	 * @param showtimeid - unique id for each showtime
	 * Creates the individual showtime file.
	 * Checks whether the file exists
	 * Creates the file if it does not exist
	 */
	public static void CreateShowTimeListingFile(int showtimeid) {

		String currentDirectory;
		String newDirectory;
		boolean checkfileexists = false;

		ShowTime_Initializer showtime_init = new ShowTime_Initializer();
		currentDirectory = showtime_init.getCurrentDirectory();

		newDirectory = currentDirectory;
		String SeatingsFile = setShowTimeFileName(showtimeid);

		File create_showtime_file = new File(newDirectory);

		try {
			if(!create_showtime_file.exists()) {
				create_showtime_file.mkdirs();
			}
			create_showtime_file = new File(newDirectory + SeatingsFile);
			checkfileexists = create_showtime_file.createNewFile();
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(create_showtime_file.getPath());
	}
	
	/**
	 * Write show time file.
	 *
	 * @param showtimeid - unique id for each showtime
	 * @param showtime - array of showtime
	 * @param seatsID - seats ID
	 * Saves this into a unique showtimes file for individual showtimes
	 */
	public static void WriteShowTimeFile(int showtimeid, int[] showtime, int seatsID) {
		String currentDirectory;
		String newDirectory;
		String new_movie;
		
		ShowTime_Initializer showtime_init = new ShowTime_Initializer();
		currentDirectory = showtime_init.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		File movielisting_file = new File(newDirectory);
		
		String ShowTimeFile = setShowTimeFileName(showtimeid);
		
		try {
			FileWriter write_showtime = new FileWriter((newDirectory + ShowTimeFile), true);
			
			ArrayList<Integer> intlist = new ArrayList<Integer>();
			
			if(movielisting_file.exists()) {
				BufferedWriter buffer = new BufferedWriter(write_showtime);
				
				
				for(int i = 0; i < showtime.length; i++) {
					intlist.add(showtime[i]);
				}
				
				String newshowtime = showtimeid + "|" + intlist + "|" + seatsID;
				
				buffer.write(newshowtime);
				
				
				//buffer.append(System.lineSeparator());
				
				
				buffer.close();
			}
		}catch (Exception e){
			
		}
	}
	
	/**
	 * Read show time file.
	 *
	 * @param showtimeid - unique id for each showtime
	 * Read from the correct showtime file
	 * Add into respectively ArrayList
	 * ShowTime object is created with the ArrayList
	 */
	public static void ReadShowTimeFile(int showtimeid) {
		String currentDirectory;
		String newDirectory;
		String new_movie;
		
		String showid, showtime, seatid;
		
		ShowTime_Initializer showtime_init = new ShowTime_Initializer();
		currentDirectory = showtime_init.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		File movielisting_file = new File(newDirectory);
		
		String ShowTimeFile = setShowTimeFileName(showtimeid);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(newDirectory + ShowTimeFile));
			
			
			ArrayList<ShowTime> showtimelist = new ArrayList<ShowTime>();
			while(true) {
				final String line = br.readLine();

				if(line == null) {
					break;
				}

				String []data = line.split("\\|");
				
				showid = data[0];
				Integer ShowTimeID = Integer.parseInt(showid);
				
				showtime = data[1];
				ArrayList<Integer> intlist = new ArrayList<Integer>();
				String[] arr=showtime.replaceAll("\\[|\\]| ", "").split(",");
				for(int i=0;i<arr.length;i++){

					intlist.add(Integer.parseInt(arr[i]));
		        }
				
				seatid = data[2];
				ArrayList<Integer> seatlist = new ArrayList<Integer>();
				String[] arrseat=showtime.replaceAll("\\[|\\]| ", "").split(",");
				for(int i=0;i<arrseat.length;i++){

					seatlist.add(Integer.parseInt(arr[i]));
		        }
				
				//Initialize showtime here
				//showtime.add(new ShowTime(ShowTimeID, intlist, seatlist));
			} 
		} catch(Exception e) {
			
		}
	}
		

	/**
	 * The main method.
	 * Created to test the individual functions
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ShowTime_Initializer showtime_init = new ShowTime_Initializer();
		showtime_init.CreateShowTimeListingFile(9);
		
		int[] test = {2,4,6};
		int[] seats = {9};
		
		showtime_init.WriteShowTimeFile(0, test, 9);
	}

}
