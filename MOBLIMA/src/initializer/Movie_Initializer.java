package initializer;
import java.io.IOException;  
import java.nio.file.*;
import java.io.File;
import java.util.*;
import java.io.*;

public class Movie_Initializer implements IGetCurrentDirectory {
	
	public String getCurrentDirectory() {
		String executionPath = System.getProperty("user.dir");
		
		return executionPath;
	}
	
	public static void CreateMovieListingFile() {
		String currentDirectory;
		String newDirectory;
		boolean checkfileexists = false;
		
		Movie_Initializer movie_init = new Movie_Initializer();
		currentDirectory = movie_init.getCurrentDirectory();
		
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
	
	public static void WriteMovieListingFile(int id, String movietitle, String type, String status, String director, String sypnosis, String cast1, String cast2, double totalsales, int NoOfRating, double AvgRating) throws Exception {
		
		String currentDirectory;
		String newDirectory;
		String new_movie; 
		
		Movie_Initializer movie_init = new Movie_Initializer();
		currentDirectory = movie_init.getCurrentDirectory();
		
		newDirectory = currentDirectory + "\\Database\\";
		File movielisting_file = new File(newDirectory);
		
		FileWriter write_movielisting = new FileWriter((newDirectory + "Movie_Listing.txt"), true);
		
		try {
			if(movielisting_file.exists()) {
				BufferedWriter buffer = new BufferedWriter(write_movielisting);
				
				new_movie = id + "|" + movietitle + "|" + type + "|" + status + "|" + director + "|" + sypnosis + "|" + cast1 + "|" + cast2 + "|" + totalsales + "|" + NoOfRating + "|" + AvgRating;
				buffer.write(new_movie);
				//buffer.append(System.lineSeparator());
				
				buffer.newLine();
				buffer.close();
			}
		}catch (Exception e){
			
		}
		
	}
	
	public static void GetNoOfMovieListing() {
		
		String currentDirectory;
		String newDirectory;
		
		String movid, movietitle, type, status;
		String director, synposis, cast1, cast2;
		String totalsales, NoOfRating, AvgRating;
		
		int CountNoOfMovies = 0;
		
		Movie_Initializer movie_init = new Movie_Initializer();
		currentDirectory = movie_init.getCurrentDirectory();
		
		newDirectory = currentDirectory + "\\Database\\";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(newDirectory + "Movie_Listing.txt"));
			
			while(true) {
				final String line = br.readLine();
				
				if(line == null) {
					break;
				}
				
				String []data = line.split("\\|");
				
				movid = data[0];
				movietitle = data[1];
				type = data[2];
				status = data[3];
				director = data[4];
				synposis = data[5];
				cast1 = data[6];
				cast2 = data[7];
				totalsales = data[8];
				NoOfRating = data[9];
				AvgRating = data[10];
				
				
				System.out.println(data[0] + ": " + data[1]);
				
				CountNoOfMovies++;
			}
			
			InitializeMovies(CountNoOfMovies);
			System.out.println("No of movies: " + CountNoOfMovies);
			
		} catch (Exception e) {
			
		}
		
	}

	public static void InitializeMovies(int NoOfMovies) {
		
		Object[][] moviearray = new Object[NoOfMovies][11];
		
		String currentDirectory;
		String newDirectory;
		
		String movid, movietitle, type, status;
		String director, synposis, cast1, cast2;
		String totalsales, NoOfRating, AvgRating;
		
		int CountNoOfMovies = 0;
		
		Movie_Initializer movie_init = new Movie_Initializer();
		currentDirectory = movie_init.getCurrentDirectory();
		
		newDirectory = currentDirectory + "\\Database\\";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(newDirectory + "Movie_Listing.txt"));
			
			while(true) {
				final String line = br.readLine();
				
				if(line == null) {
					break;
				}
				
				String []data = line.split("\\|");
				
				movid = data[0];
				movietitle = data[1];
				type = data[2];
				status = data[3];
				director = data[4];
				synposis = data[5];
				cast1 = data[6];
				cast2 = data[7];
				totalsales = data[8];
				NoOfRating = data[9];
				AvgRating = data[10];
				
				
				//System.out.println(data[0] + ": " + data[1]);
				
				moviearray[CountNoOfMovies][0] = movid;
				moviearray[CountNoOfMovies][1] = movietitle;
				moviearray[CountNoOfMovies][2] = type;
				moviearray[CountNoOfMovies][3] = status;
				moviearray[CountNoOfMovies][4] = director;
				moviearray[CountNoOfMovies][5] = synposis;
				moviearray[CountNoOfMovies][6] = cast1;
				moviearray[CountNoOfMovies][7] = cast2;
				moviearray[CountNoOfMovies][8] = totalsales;
				moviearray[CountNoOfMovies][9] = NoOfRating;
				moviearray[CountNoOfMovies][10] = AvgRating;
				
				CountNoOfMovies++;
			}
			
			//Initialize Movies with loop -->
			for(int i = 0; i < NoOfMovies; i ++) {
				System.out.println("");
				System.out.println("--- Initialize Movie class ---");
				System.out.println("Movie title: " + moviearray[i][1]);
				System.out.println("--- --- --- --- --- --- --- ---");
				System.out.println("");
			}
			
		} catch (Exception e) {
			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		int NoOfMovie = 0;
		
		//System.out.println(getCurrentDirectory());
		
		CreateMovieListingFile();
		//WriteMovieListingFile(1, "Buzz Light Year", "TYPE", "STATUS", "DIRECTOR", "SYPNOSIS", "CAST1", "CAST2", 986.3, 102, 4.98);
		//WriteMovieListingFile(2, "Whzz Light Year", "TYPE", "STATUS", "DIRECTOR", "SYPNOSIS", "CAST1", "CAST2", 986.3, 102, 4.98);
		//WriteMovieListingFile(3, "Nazz Light Year", "TYPE", "STATUS", "DIRECTOR", "SYPNOSIS", "CAST1", "CAST2", 986.3, 102, 4.98);
		GetNoOfMovieListing();
		
	}
}