package initializer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import entities.Seats;
import entities.ShowTime;

public class ShowTimeInitializer extends GetDatabaseDirectory {

	public static String setShowTimeFileName(int seatid) {

		String seatingsfolder = "/ShowTime/";

		final String DBfile = "ShowTime.txt";

		return(seatingsfolder+seatid+DBfile);
	}

	// public static void readShowTimeFromFile(int showTimeID) {

	// 	String currentDirectory;
	// 	String newDirectory;
	// 	boolean checkfileexists = false;

	// 	ShowTimeInitializer showtime_init = new ShowTimeInitializer();
	// 	currentDirectory = showtime_init.getCurrentDirectory();

	// 	newDirectory = currentDirectory;
	// 	String SeatingsFile = setShowTimeFileName(showTimeID);

	// 	File create_showtime_file = new File(newDirectory);

	// 	try {
	// 		if(!create_showtime_file.exists()) {
	// 			create_showtime_file.mkdirs();
	// 		}
	// 		create_showtime_file = new File(newDirectory + SeatingsFile);
	// 		checkfileexists = create_showtime_file.createNewFile();
	// 	} catch(Exception e) {
	// 		System.out.println(e);
	// 	}
	// 	System.out.println(create_showtime_file.getPath());
	// }
	
	public static void writeShowTimeToFile(ShowTime showTime) {
		String currentDirectory;
		String newDirectory;
		String new_movie;
		
		ShowTimeInitializer showtime_init = new ShowTimeInitializer();
		currentDirectory = showtime_init.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		File movielisting_file = new File(newDirectory);
		
		String ShowTimeFile = setShowTimeFileName(showTime.getShowTimeID());

		
		try {
			FileWriter write_showtime = new FileWriter((newDirectory + ShowTimeFile), true);
			
			ArrayList<Integer> intlist = new ArrayList<Integer>();
			
			if(movielisting_file.exists()) {
				BufferedWriter buffer = new BufferedWriter(write_showtime);
				
				
				for(int i = 0; i < showTime.getShowTime().length; i++) {
					intlist.add(showTime.getShowTime()[i]);
				}
				
				String seatIDs = "";
				for(Seats seats: showTime.getSeats()) {
					SeatsInitializer.writeSeatsToFile(seats);
					seatIDs += seats.getSeatsID() + ",";
				}

				String newshowtime = showTime.getShowTimeID() + "|" + intlist + "|" + seatIDs;
				
				buffer.write(newshowtime);
			
				buffer.close();
			}
		}catch (Exception e){
			
		}
	}
	
	public static ShowTime readShowTimeFromFile(int showTimeID) {
		String currentDirectory;
		String newDirectory;
		String new_movie;
		
		String showid, showtime, seatid;
		
		ShowTimeInitializer showtime_init = new ShowTimeInitializer();
		currentDirectory = showtime_init.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		File movielisting_file = new File(newDirectory);
		
		String ShowTimeFile = setShowTimeFileName(showTimeID);
		
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
}
