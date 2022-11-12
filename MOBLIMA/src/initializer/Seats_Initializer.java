package initializer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Seats_Initializer.
 */
public class Seats_Initializer extends GetDatabaseDirectory{
	
	/**
	 * Sets the seatings file name.
	 *
	 * @param seatid the seatid
	 * @return the string
	 */
	public static String setSeatingsFileName(int seatid) {
		
		String seatingsfolder = "\\Seatings\\";
		
		String DBfile = "Seatings.txt";
		
		return(seatingsfolder+seatid+DBfile);
	}

	/**
	 * Creates the cineplex file.
	 *
	 * @param seatid the seatid
	 */
	public static void CreateCineplexFile(int seatid) {

		String currentDirectory;
		String newDirectory;
		boolean checkfileexists = false;

		Seats_Initializer cineplexseats_init = new Seats_Initializer();
		currentDirectory = cineplexseats_init.getCurrentDirectory();

		newDirectory = currentDirectory;
		
		String SeatingsFile = setSeatingsFileName(seatid);

		File create_cineplexseats_file = new File(newDirectory);

		try {
			if(!create_cineplexseats_file.exists()) {
				create_cineplexseats_file.mkdirs();
			}
			create_cineplexseats_file = new File(newDirectory + SeatingsFile);
			checkfileexists = create_cineplexseats_file.createNewFile();
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(create_cineplexseats_file.getPath());

	}
	
	/**
	 * Save seats.
	 *
	 * @param seatsID        the seats ID
	 * @param cineplex_seats the cineplex seats
	 */
	public static void SaveSeats(int seatsID, int[][] cineplex_seats) {
		
		String currentDirectory;
		String newDirectory;
		boolean checkfileexists = false;
		
		Seats_Initializer cineplexseats_init = new Seats_Initializer();
		currentDirectory = cineplexseats_init.getCurrentDirectory();

		newDirectory = currentDirectory;
		File create_cineplexseats_file = new File(newDirectory);
		
		try {

			StringBuilder builder = new StringBuilder();
			//builder.append(seatsID + "|");
			for(int i = 0; i < cineplex_seats.length; i++)//for each row
			{
			   for(int j = 0; j < cineplex_seats.length; j++)//for each column
			   {
			      builder.append(cineplex_seats[i][j]+"");//append to the output string
			      if(j < cineplex_seats.length - 1)//if this is not the last row element
			         builder.append(",");//then add comma (if you don't like commas you can use spaces)
			   }
			   builder.append("\n");//append new line at the end of the row
			}
			
			String SeatingsFile = setSeatingsFileName(seatsID);
			
			FileWriter write_movielisting = new FileWriter((newDirectory + SeatingsFile));
			BufferedWriter buffer = new BufferedWriter(write_movielisting);
			
			buffer.write(builder.toString());//save the string representation of the board
			buffer.close();

		} catch (IOException e) {

		}
		
		
	}

	/**
	 * Return seats.
	 *
	 * @param seatsID the seats ID
	 * @return the int[][]
	 */
	public static int[][] returnSeats(int seatsID){
		String currentDirectory;
		String newDirectory;
		
		int[][] cineplex_seats = new int[8][8];
		
		String seatid;
		int SeatID = 0;
		
		Seats_Initializer cineplexseats_init = new Seats_Initializer();
		currentDirectory = cineplexseats_init.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		
		String SeatingsFile = setSeatingsFileName(seatsID);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(newDirectory + SeatingsFile));
			String line = "";
			int row = 0;
			while((line = br.readLine()) != null)
			{	
			   String[] cols = line.split(","); //note that if you have used space as separator you have to split on " "
			   int col = 0;
			   for(String  c : cols)
			   {
				   cineplex_seats[row][col] = Integer.parseInt(c);
			      col++;
			   }
			   row++;
			}
			br.close();
			
		} catch (Exception e) {
			
		}
		//initialize seats here -->
		return cineplex_seats;
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int seatsID = 1;
		int[][] cineplex_seats = {{0,8,0,0,0},
				  				  {0,0,0,0,0},
				  				  {0,0,2,0,0},
				  				  {0,0,0,9,0},
				  				  {0,0,0,0,0}};
		
		int[][] test_seats = null;
		
		Seats_Initializer cineplexseats_init = new Seats_Initializer();
		cineplexseats_init.CreateCineplexFile(2);
		cineplexseats_init.SaveSeats(2, cineplex_seats);
		
		test_seats = cineplexseats_init.returnSeats(2);
		cineplexseats_init.SaveSeats(9, test_seats);
	}
}
