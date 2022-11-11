package initializer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SeatsInitializer extends GetDatabaseDirectory{
	
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
	
	public static void writeSeatsToFile(int seatsID, int[][] seats) {
		
		String currentDirectory;
		String newDirectory;
		
		SeatsInitializer cineplexseats_init = new SeatsInitializer();
		currentDirectory = cineplexseats_init.getCurrentDirectory();

		newDirectory = currentDirectory;
		
		try {
			StringBuilder builder = new StringBuilder();
			for(int i = 0; i < seats.length; i++)
			{
			   for(int j = 0; j < seats[0].length; j++)
			   {
			      builder.append(seats[i][j]+"");
			      if(j < seats[0].length - 1)
			         builder.append(",");
			   }
			   builder.append("\n");
			}
			
			String SeatingsFile = setSeatingsFileName(seatsID);
			
			FileWriter write_movielisting = new FileWriter((newDirectory + SeatingsFile));
			BufferedWriter buffer = new BufferedWriter(write_movielisting);
			
			buffer.write(builder.toString());//save the string representation of the board
			buffer.close();

		} catch (IOException e) {

		}
		
		
	}

	public static int[][] readSeatsFromFile(int seatsID){
		String currentDirectory;
		String newDirectory;
		
		ArrayList<ArrayList<Integer>> seats = new ArrayList<ArrayList<Integer>>();
		
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
			   seats.add(new ArrayList<Integer>());
			   for(String  c : cols)
			   {
				  seats.get(row).add(Integer.parseInt(c));
			   }
			   row++;
			}
			br.close();
			
		} catch (Exception e) {
			
		}

		// convert arraylist to array of seats
		int[][] seatsArray = seats.stream()
		.map(l -> l.stream().mapToInt(Integer::intValue).toArray())
		.toArray(int[][]::new);

		return seatsArray;
	}
}
