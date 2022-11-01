import java.io.IOException;  
import java.nio.file.*;
import java.io.File;
import java.util.*;
import java.io.*;

public class Movie_Initializer {
	
	public static String getCurrentDirectory() {
		String executionPath = System.getProperty("user.dir");
		
		return executionPath;
	}
	
	public static void CreateMovieListingFile() {
		String currentDirectory;
		String newDirectory;
		boolean checkfileexists = false;
		
		currentDirectory = getCurrentDirectory();
		
		newDirectory = currentDirectory + "\\Database\\";
		
		File create_movielisting_file = new File(newDirectory);
		
		try {
			if(!create_movielisting_file.exists()) {
				create_movielisting_file.mkdirs();
			}
			create_movielisting_file = new File(newDirectory + "Movie_Listing.txt");
			checkfileexists = create_movielisting_file.createNewFile();
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(create_movielisting_file.getPath());
		
	}
	
	public static void WriteMovieListingFile(String id, String movietitle) throws Exception {
		
		String currentDirectory;
		String newDirectory;
		String new_movie;
		
		currentDirectory = getCurrentDirectory();
		
		newDirectory = currentDirectory + "\\Database\\";
		File movielisting_file = new File(newDirectory);
		
		FileWriter write_movielisting = new FileWriter((newDirectory + "Movie_Listing.txt"), true);
		
		try {
			if(movielisting_file.exists()) {
				BufferedWriter buffer = new BufferedWriter(write_movielisting);
				
				new_movie = id + " | " + movietitle;
				buffer.write(new_movie);
				//buffer.append(System.lineSeparator());
				
				buffer.newLine();
				buffer.close();
			}
		}catch (Exception e){
			
		}
		
	}
	
	public static void ReadMovieListing() {
		
		String currentDirectory;
		String newDirectory;
		
		String movid;
		String movietitle;
		
		currentDirectory = getCurrentDirectory();
		
		newDirectory = currentDirectory + "\\Database\\";
		try {
			Scanner read = new Scanner(new File(newDirectory + "Movie_Listing.txt"));
			
			read.useDelimiter("|");
			while(read.hasNext()) {
				
				movid = read.next();
				movietitle = read.nextLine();
				System.out.println(movid + ", " + movietitle);
				
			}
			
			read.close();
		} catch (Exception e) {
			
		}
		
	}

	
	public static void main(String[] args) throws Exception {
		System.out.println(getCurrentDirectory());
		
		CreateMovieListingFile();
		//WriteMovieListingFile("1", "Buzz Light Year");
		//WriteMovieListingFile("2", "Star Wars");
		ReadMovieListing();
	}
}
