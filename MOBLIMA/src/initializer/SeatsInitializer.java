package initializer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import entities.ISeat;
import entities.Seat;
import entities.Seats;
import entities.Space;

// TODO: Auto-generated Javadoc
/**
 * The Class SeatsInitializer.
 */
public class SeatsInitializer extends GetDatabaseDirectory{
	
	/**
	 * Sets the seatings file name.
	 *
	 * @param seatid the seatid
	 * @return the string
	 */
	public static String setSeatingsFileName(int seatid) {
		
		String seatingsfolder = "/Seatings/";
		
		String DBfile = "Seatings.txt";
		
		return(seatingsfolder+seatid+DBfile);
	}

	// public static void CreateCineplexFile(int seatid) {

	// 	String currentDirectory;
	// 	String newDirectory;
	// 	boolean checkfileexists = false;

	// 	Seats_Initializer cineplexseats_init = new Seats_Initializer();
	// 	currentDirectory = cineplexseats_init.getCurrentDirectory();

	// 	newDirectory = currentDirectory;
		
	// 	String SeatingsFile = setSeatingsFileName(seatid);

	// 	File create_cineplexseats_file = new File(newDirectory);

	// 	try {
	// 		if(!create_cineplexseats_file.exists()) {
	// 			create_cineplexseats_file.mkdirs();
	// 		}
	// 		create_cineplexseats_file = new File(newDirectory + SeatingsFile);
	// 		checkfileexists = create_cineplexseats_file.createNewFile();
	// 	} catch(Exception e) {
	// 		System.out.println(e);
	// 	}
	// 	System.out.println(create_cineplexseats_file.getPath());

	// }
	
	/**
	 * Write seats to file.
	 *
	 * @param seats the seats
	 */
	public static void writeSeatsToFile(Seats seats) {
		
		String currentDirectory;
		String newDirectory;
		
		SeatsInitializer cineplexseats_init = new SeatsInitializer();
		currentDirectory = cineplexseats_init.getCurrentDirectory();

		newDirectory = currentDirectory;

		ISeat[][] seatsArray = seats.getSeats();
		
		try {
			StringBuilder builder = new StringBuilder();
			for(int i = 0; i < seatsArray.length; i++)
			{
			   for(int j = 0; j < seatsArray[0].length; j++)
			   {
			      builder.append(seatsArray[i][j].getState());
			      if(j < seatsArray[0].length - 1)
			         builder.append(",");
			   }
			   builder.append("\n");
			}
			
			String SeatingsFile = setSeatingsFileName(seats.getSeatsID());
			
			FileWriter write_movielisting = new FileWriter((newDirectory + SeatingsFile));
			BufferedWriter buffer = new BufferedWriter(write_movielisting);
			
			buffer.write(builder.toString());//save the string representation of the board
			buffer.close();

		} catch (IOException e) {

		}
		
		
	}

	/**
	 * Read seats from file.
	 *
	 * @param seatsID the seats ID
	 * @return the seats
	 */
	public static Seats readSeatsFromFile(int seatsID){
		String currentDirectory;
		String newDirectory;
		
		ArrayList<ArrayList<ISeat>> seats = new ArrayList<ArrayList<ISeat>>();
		
		SeatsInitializer cineplexseats_init = new SeatsInitializer();
		currentDirectory = cineplexseats_init.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		
		String SeatingsFile = setSeatingsFileName(seatsID);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(newDirectory + SeatingsFile));
			String line = "";
			int row = 0;
			while((line = br.readLine()) != null)
			{	
			   String[] cols = line.split(",");
			   seats.add(new ArrayList<ISeat>());
			   for(String  c : cols)
			   {
				  Space space = null;
				  Seat seat = null;
				  switch (c) {
					case " ":
						space = new Space();
						seats.get(row).add(space);
						break;
					case "X":
						seat = new Seat();
						seat.toggleOccupied();
						seats.get(row).add(seat);
					case "_":
						seat = new Seat();
						seats.get(row).add(seat);
						break;
				  }
			   }
			   row++;
			}
			br.close();
			
		} catch (Exception e) {
			
		}

		// convert arraylist to array of seats
		ISeat[][] seatsArray = new ISeat[seats.size()][seats.get(0).size()];

		for(int i = 0; i < seatsArray.length; i++) {
			for(int j = 0; j < seatsArray.length; j++) {
				seatsArray[i][j] = seats.get(i).get(j);
			}
		}

		// ISSUE: I NEED ISEATLAYOUT TO CREATE A SEAT CLASS
		Seats seat = new Seats(seatsID, seatsArray);

		return seat;
	}
}
