package initializer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import enums.Status;
import entities.Movie;
import enums.MovieType;

public class Movie_Initializer extends GetDatabaseDirectory {
	
	public static final String DBfile = "Movie_Listing.txt";
	
	public static void CreateMovieListingFile() {
		
		String currentDirectory;
		String newDirectory;
		boolean checkfileexists = false;
		
		Movie_Initializer movie_init = new Movie_Initializer();
		currentDirectory = movie_init.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		
		File create_movielisting_file = new File(newDirectory);
		
		try {
			if(!create_movielisting_file.exists()) {
				create_movielisting_file.mkdirs();
			}
			create_movielisting_file = new File(newDirectory + DBfile);
			checkfileexists = create_movielisting_file.createNewFile();
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(create_movielisting_file.getPath());
		
	}
	
	public static void WriteMovieListingFile(ArrayList<Movie> movielist) throws Exception {
		
		String currentDirectory;
		String newDirectory;
		String new_movie;
		
		Movie_Initializer movie_init = new Movie_Initializer();
		currentDirectory = movie_init.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		File movielisting_file = new File(newDirectory);
		
		FileWriter write_movielisting = new FileWriter((newDirectory + DBfile), true);
		
		try {
			if(movielisting_file.exists()) {
				BufferedWriter buffer = new BufferedWriter(write_movielisting);
				
				
				for(Movie movies: movielist) {
					new_movie = movies.getMovieID() + "|" + movies.getMovieName() + "|" + movies.getMovieType() + "|" + movies.getStatus() + "|" + movies.getDirector() + "|" + movies.getSypnopsis() + "|" + movies.getCasts() + "|" + movies.getTotalSales() + "|" + movies.getRatings();
					buffer.write(new_movie);
					buffer.newLine();
				}
				
				
				//buffer.append(System.lineSeparator());
				
				
				buffer.close();
			}
		}catch (Exception e){
			
		}
		
	}
	
	public ArrayList<Movie> GetMovieListing() {
		
		ArrayList<Movie> movielist = new ArrayList<Movie>();
		
		String currentDirectory;
		String newDirectory;
		
		String movid, movietitle, type, status;
		String director, synposis, cast1, cast2;
		String totalsales, NoOfRating, AvgRating;
		
		MovieType genre = null;
		Status moviestatus = null;
		
		int CountNoOfMovies = 0;
		
		Movie_Initializer movie_init = new Movie_Initializer();
		currentDirectory = movie_init.getCurrentDirectory();
		
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
				
				type = data[2];
				switch(type) {
				
				case "IMAX":
					genre = MovieType.IMAX;
					break;
					
				case "_3D":
					genre = MovieType._3D;
					break;
					
				case "NORMAL":
					genre = MovieType.NORMAL;
					break;
				}
				
				status = data[3];
				switch(status) {
				
				case "Showing":
					moviestatus = Status.Showing;
					break;
					
				case "ComingSoon":
					moviestatus = Status.ComingSoon;
					break;
				}
				
				director = data[4];
				synposis = data[5];
				
				ArrayList<String> castlist = new ArrayList<String>();
				cast1 = data[6];
				castlist.add(cast1);
				
				totalsales = data[7];
				double newsales = Double.parseDouble(totalsales);
				
				ArrayList<Integer> ratinglist = new ArrayList<Integer>();
				NoOfRating = data[8];
				String[] arr=NoOfRating.replaceAll("\\[|\\]| ", "").split(",");
		        for(int i=0;i<arr.length;i++){

		        	ratinglist.add(Integer.parseInt(arr[i]));
		        }
				
				//ratinglist.add(Integer.parseInt(NoOfRating));
								
				movielist.add(new Movie(movieid, movietitle, genre, moviestatus, castlist, director, synposis, ratinglist, newsales));
				
				CountNoOfMovies++;
			}
			
		} catch (Exception e) {
			System.out.print(e);
		}
		
		return movielist;
		
	}

	public static void InitializeMovies() {
		
		ArrayList<Movie> moviearray = new ArrayList<Movie>();
		
		ArrayList<String> castlist = new ArrayList<String>();
		ArrayList<Integer> ratinglist = new ArrayList<Integer>();
		
		String currentDirectory;
		String newDirectory;
		
		String movid, movietitle, type, status;
		String director, synposis, cast1, cast2;
		String totalsales, NoOfRating, AvgRating;
		
		MovieType genre = MovieType.NORMAL;
		Status moviestatus = Status.Showing;
		
		int CountNoOfMovies = 0;
		
		Movie_Initializer movie_init = new Movie_Initializer();
		currentDirectory = movie_init.getCurrentDirectory();
		
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
				
				type = data[2];
				genre.valueOf(type);
				
				status = data[3];
				moviestatus.valueOf(status);
				
				status = data[3];
				director = data[4];
				synposis = data[5];
				
				cast1 = data[6];				
				castlist.add(cast1);
								
				totalsales = data[7];
				double newsales = Double.parseDouble(totalsales);
				
				NoOfRating = data[8];
				ratinglist.add(Integer.parseInt(NoOfRating));
				
				moviearray.add(new Movie(movieid, movietitle, genre, moviestatus, castlist, director, synposis, ratinglist, newsales));
				
				CountNoOfMovies++;
			}
			
		} catch (Exception e) {
			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		int NoOfMovie = 0;
		
		//System.out.println(getCurrentDirectory());
		
		CreateMovieListingFile();
		//WriteMovieListingFile(1, "Buzz Light Year", "NORMAL", "Showing", "DIRECTOR", "SYPNOSIS", "CAST1", "CAST2", 986.3, 102, 4.98);
		//WriteMovieListingFile(2, "Whzz Light Year", "TYPE", "STATUS", "DIRECTOR", "SYPNOSIS", "CAST1", "CAST2", 986.3, 102, 4.98);
		//WriteMovieListingFile(3, "Nazz Light Year", "TYPE", "STATUS", "DIRECTOR", "SYPNOSIS", "CAST1", "CAST2", 986.3, 102, 4.98);
		
		Movie_Initializer movie_init = new Movie_Initializer();
		ArrayList <Movie> capmovie = movie_init.GetMovieListing();
		
		movie_init.WriteMovieListingFile(capmovie);
	
	}
}