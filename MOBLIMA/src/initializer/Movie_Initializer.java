package initializer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import enums.Status;
import entities.Movie;
import enums.CinemaType;
import enums.MovieGenre;

public class Movie_Initializer extends GetDatabaseDirectory {
	
	public static final String DBfile = "Movie_Listing.txt";
	
	public static void CreateMovieListingFile() {
		
		String currentDirectory;
		String newDirectory;
		
		currentDirectory = Movie_Initializer.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		
		File create_movielisting_file = new File(newDirectory);
		
		try {
			if(!create_movielisting_file.exists()) {
				create_movielisting_file.mkdirs();
			}
			create_movielisting_file = new File(newDirectory + DBfile);
		} catch(Exception e) {
			System.out.println(e);
		}		
	}
	
	public static void WriteMovieListingFile(ArrayList<Movie> movielist) throws Exception {		
		String currentDirectory;
		String newDirectory;
		String new_movie;
		
		currentDirectory = Movie_Initializer.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		File movielisting_file = new File(newDirectory);
		
		FileWriter write_movielisting = new FileWriter((newDirectory + DBfile));
		
		try {
			if(movielisting_file.exists()) {
				BufferedWriter buffer = new BufferedWriter(write_movielisting);
				
				
				for(Movie movies: movielist) {
					new_movie = movies.getMovieID() + "|" 
										+ movies.getMovieName() + "|"
										+ movies.getCinemaTypes() + "|" 
										+ movies.getStatus() + "|" 
										+ movies.getDirector() + "|"
										+ movies.getSypnopsis() + "|" 
										+ movies.getCasts() + "|" 
										+ movies.getTotalSales() + "|" 
										+ movies.getRatings() + "|" 
										+ movies.getMovieType();
					buffer.write(new_movie);
					buffer.newLine();
				}
				buffer.close();
			}
			buffer.close();
		}catch (Exception e){
			
		}
		
	}
	
	public static ArrayList<Movie> GetMovieListing() {
		
		ArrayList<Movie> movielist = new ArrayList<Movie>();
		
		String currentDirectory;
		String newDirectory;
		
		String movid, movietitle, types, status;
		String director, synposis, cast1;
		String totalsales, NoOfRating, AvgRating;
		
		MovieGenre genre = null;
		Status moviestatus = null;
		
		
		currentDirectory = Movie_Initializer.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(newDirectory + DBfile));
			
			while(true) {
				final String line = br.readLine();
				
				if(line == null) {
					break;
				}
				
				String []data = line.split("\\|");
				
				movid = data[0];
				int movieid = Integer.parseInt(movid);
				
				movietitle = data[1];
				
				types = data[2];
				String[] typesArr=types.replaceAll("\\[|\\]|", "").split(",");
				ArrayList<CinemaType> cinemaTypes = new ArrayList<CinemaType>();
				for(String type :typesArr){	
					CinemaType temp = null;
					switch(type) {
						case "IMAX":
							temp = CinemaType.IMAX;
							break;
						case "_3D":
							temp = CinemaType._3D;
							break;
						case "NORMAL":
							temp = CinemaType.NORMAL;
							break;
						}
						cinemaTypes.add(temp);
					}
				
				status = data[3];
				switch(status) {
				
				case "Showing":
					moviestatus = Status.Showing;
					break;
				case "ComingSoon":
					moviestatus = Status.ComingSoon;
					break;
				case "EndOfShowing":
					moviestatus = Status.EndOfShowing;
					break;
				case "Preview":
					moviestatus = Status.Preview;
					break;
				}
				
				director = data[4];
				synposis = data[5];
				
				ArrayList<String> castlist = new ArrayList<String>();
				cast1 = data[6];
				castlist.add(cast1);
				
				totalsales = data[7];
				double newsales = Float.parseFloat(totalsales);
				
				ArrayList<Integer> ratinglist = new ArrayList<Integer>();
				NoOfRating = data[8];
				String[] arr=NoOfRating.replaceAll("\\[|\\]|", "").split(",");
		        for(int i=0;i<arr.length;i++){

		        	ratinglist.add(Integer.parseInt(arr[i]));
		        }
		        
		        AvgRating = data[9];
		        Float avgrating = Float.parseFloat(AvgRating);
								
				String movieType = data[10];
					switch(movieType) {
						case "ACTION":
							genre = MovieGenre.ACTION;
							break;
							
						case "COMEDY":
							genre = MovieGenre.COMEDY;
							break;
					}
				movielist.add(new Movie(movieid, movietitle, genre, moviestatus, castlist, director, synposis, ratinglist, newsales, avgrating, cinemaTypes));
			}	
			
		} catch (Exception e) {
			System.out.print("Read movie error: "+ e.getMessage());
		}
		return movielist;
	}
}