package initializer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import entities.Seats;
import entities.ShowTime;

public class ShowTimeInitializer extends GetDatabaseDirectory {

	public static String setShowTimeFileName(int seatid) {

		String seatingsfolder = "ShowTime"+separator;

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
		
		currentDirectory = ShowTimeInitializer.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		String ShowTimeFile = setShowTimeFileName(showTime.getShowTimeID());
		
		try {
			FileWriter write_showtime = new FileWriter((newDirectory + ShowTimeFile));
			
			ArrayList<Integer> intlist = new ArrayList<Integer>();

			BufferedWriter buffer = new BufferedWriter(write_showtime);
			
			for(int i = 0; i < showTime.getShowTime().length; i++) {
				intlist.add(showTime.getShowTime()[i]);
			}
			
			String seatIDs = "";
			for(Seats seats: showTime.getSeats()) {
				SeatsInitializer.writeSeatsToFile(seats);
				seatIDs += seats.getSeatsID() + ",";
			}

			String newshowtime = showTime.getShowTimeID() + "|" + intlist + "|" + "[" + seatIDs + "]";
			
			buffer.write(newshowtime);
		
			buffer.close();
		}catch (Exception e){
			
		}
	}
	
	public static ShowTime readShowTimeFromFile(int showTimeID) {
		String currentDirectory;
		String newDirectory;
		
		String showTimeStr, seatIDStr;
		
		currentDirectory = ShowTimeInitializer.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		
		String ShowTimeFile = setShowTimeFileName(showTimeID);

		ArrayList<Integer> intlist = new ArrayList<Integer>();
		ArrayList<Integer> seatlist = new ArrayList<Integer>();
		ArrayList<Seats> seats = new ArrayList<Seats>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(newDirectory + ShowTimeFile));
			
			while(true) {
				final String line = br.readLine();

				if(line == null) {
					break;
				}

				String []data = line.split("\\|");
				
				
				showTimeStr = data[1];
				String[] arr=showTimeStr.replaceAll("\\[|\\]| ", "").split(",");
				for(int i=0;i<arr.length;i++){

					intlist.add(Integer.parseInt(arr[i]));
		        }
				
				seatIDStr = data[2];
				String[] arrseat=seatIDStr.replaceAll("\\[|\\]| ", "").split(",");
				for(int i=0;i<arrseat.length;i++){
					seatlist.add(Integer.parseInt(arrseat[i]));
		        }

				for(Integer seatID: seatlist) {
					seats.add(SeatsInitializer.readSeatsFromFile(seatID));
				}
			} 
		} catch(Exception e) {
			System.out.println("Showtime initializer error: "+e.getMessage());
		}

		// convert ArrayList to array
		int[] showTimeArray = new int[intlist.size()];
		for(int i = 0; i < showTimeArray.length; i++) {
			showTimeArray[i] = intlist.get(i);
		}

		Seats[] showTimeSeatsArray = new Seats[seats.size()];
		for(int i = 0; i < showTimeSeatsArray.length; i++) {
			showTimeSeatsArray[i] = seats.get(i);
		}

		ShowTime newShowtime = new ShowTime(showTimeID, showTimeArray, showTimeSeatsArray);
		return newShowtime;
	}
}
