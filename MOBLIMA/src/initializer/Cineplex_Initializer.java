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

public class Cineplex_Initializer extends GetDatabaseDirectory{

	public static final String DBfile = "Cineplex_Seatings.txt";

	public static void CreateCineplexFile() {

		String currentDirectory;
		String newDirectory;
		boolean checkfileexists = false;

		Cineplex_Initializer cineplexseats_init = new Cineplex_Initializer();
		currentDirectory = cineplexseats_init.getCurrentDirectory();

		newDirectory = currentDirectory;

		File create_cineplexseats_file = new File(newDirectory);

		try {
			if(!create_cineplexseats_file.exists()) {
				create_cineplexseats_file.mkdirs();
			}
			create_cineplexseats_file = new File(newDirectory + DBfile);
			checkfileexists = create_cineplexseats_file.createNewFile();
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(create_cineplexseats_file.getPath());

	}
	
	public static void SaveSeats(int[][] cineplex_seats) {
		
		String currentDirectory;
		String newDirectory;
		boolean checkfileexists = false;
		
		Cineplex_Initializer cineplexseats_init = new Cineplex_Initializer();
		currentDirectory = cineplexseats_init.getCurrentDirectory();

		newDirectory = currentDirectory;
		File create_cineplexseats_file = new File(newDirectory);
		
		try {

			StringBuilder builder = new StringBuilder();
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
			
			FileWriter write_movielisting = new FileWriter((newDirectory + DBfile), true);
			BufferedWriter buffer = new BufferedWriter(write_movielisting);
			
			buffer.write(builder.toString());//save the string representation of the board
			buffer.close();

		} catch (IOException e) {

		}
		
		
	}

	public static int[][] returnSeats(){
		String currentDirectory;
		String newDirectory;
		
		int[][] cineplex_seats = new int[5][5];
		
		Cineplex_Initializer cineplexseats_init = new Cineplex_Initializer();
		currentDirectory = cineplexseats_init.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(newDirectory + DBfile));
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
		
		return cineplex_seats;
	}
	
	public static void main(String[] args) {
		int[][] cineplex_seats = {{0,0,0,0,0},
				  				  {0,0,0,0,0},
				  				  {0,0,0,0,0},
				  				  {0,0,0,0,0},
				  				  {0,0,0,0,0}};
		
		int[][] test_seats = null;
		
		Cineplex_Initializer cineplexseats_init = new Cineplex_Initializer();
		cineplexseats_init.CreateCineplexFile();
		
		test_seats = cineplexseats_init.returnSeats();
		cineplexseats_init.SaveSeats(test_seats);
	}
}
