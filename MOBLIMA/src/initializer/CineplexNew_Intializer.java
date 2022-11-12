package initializer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import entities.Booking;
import entities.Cinema;
import entities.Cineplex;
import entities.Customer;
import entities.Movie;
import entities.ShowTime;
import enums.AgeGroup;
import enums.CinemaType;
import enums.DayOfWeek;
import enums.Status;
import enums.TimeOfDay;

// TODO: Auto-generated Javadoc
/**
 * The Class CineplexNew_Intializer.
 */
public class CineplexNew_Intializer extends GetDatabaseDirectory {
	
	/** The Constant DBfile - name of the text file to be read from. */
	public static final String DBfile = "Cineplex.txt";

	/**
	 * Creates the cineplex file.
	 * 
	 * Check if the file exists
	 * Creates the file if it does not exist
	 */
	public static void CreateCineplexFile() {
		String currentDirectory;
		String newDirectory;
		boolean checkfileexists = false;
		
		CineplexNew_Intializer cineplex_init = new CineplexNew_Intializer();
		currentDirectory = cineplex_init.getCurrentDirectory();

		newDirectory = currentDirectory;

		File create_cineplex_file = new File(newDirectory);

		try {
			if(!create_cineplex_file.exists()) {
				create_cineplex_file.mkdirs();
			}
			create_cineplex_file = new File(newDirectory + DBfile);
			checkfileexists = create_cineplex_file.createNewFile();
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(create_cineplex_file.getPath());

	}
	 
 	/**
	 * Write cineplex listing file.
	 *
	 * @param ArrayList of Cineplex
	 * Saves the ArrayList into read-able format
	 * @throws Exception the exception
	 */
 	public static void WriteCineplexListingFile(ArrayList<Cineplex> cineplexlist) throws Exception { 
		   
		  String currentDirectory; 
		  String newDirectory; 
		  String new_cineplex; 
		   
		  CineplexNew_Intializer cineplex_init = new CineplexNew_Intializer(); 
		  currentDirectory = cineplex_init.getCurrentDirectory(); 
		   
		  newDirectory = currentDirectory; 
		  File cineplexlisting_file = new File(newDirectory); 
		   
		  FileWriter write_cineplexlisting = new FileWriter((newDirectory + DBfile), true); 
		   
		  try { 
		   if(cineplexlisting_file.exists()) { 
		    BufferedWriter buffer = new BufferedWriter(write_cineplexlisting); 
		     
		     
		    for(Cineplex cineplex: cineplexlist) { 
		     new_cineplex = cineplex.getCineplexID() + "|" + cineplex.getCineplexName() + "|" + cineplex.getCinemas(); 
		     buffer.write(new_cineplex); 
		     buffer.newLine(); 
		    } 
		     
		     
		    //buffer.append(System.lineSeparator()); 
		     
		     
		    buffer.close(); 
		   } 
		  }catch (Exception e){ 
		    
		  } 
		   
		 } 
		  
		 /**
		 * Reads back from the Cineplex file
		 * Create individual Cineplex object from each line
		 * Adds the object back into the ArrayList
		 * @return the array list
		 */
 		public ArrayList<Cineplex> GetCineplexListing() { 
		   
		  ArrayList<Cineplex> cineplexlist = new ArrayList<Cineplex>(); 
		   
		  String currentDirectory; 
		  String newDirectory; 
		   
		  String cineplexid, cineplexname; 
		  
		  //String totalsales, NoOfRating, AvgRating; 
		   
		   
		  int CountNoOfCinplex = 0; 
		   
		  Cineplex_Initializer cineplex_init = new Cineplex_Initializer(); 
		  currentDirectory = cineplex_init.getCurrentDirectory(); 
		   
		  newDirectory = currentDirectory; 
		   
		  try { 
		   BufferedReader br = new BufferedReader(new FileReader(newDirectory + DBfile)); 
		    
		   while(true) { 
		    final String line = br.readLine(); 
		     
		    if(line == null) { 
		     break; 
		    } 
		     
		    String []data = line.split("\\|"); 
		     
		    cineplexid = data[0]; 
		    int cineid = Integer.parseInt(cineplexid); 
		     
		    cineplexname = data[1]; 
		     		    
		   //cinematype = new CinemaType[3];
		     
		    String arrayofgenre = data[2];
			String[] arr=arrayofgenre.replaceAll("\\[|\\]| ", "").split(",");
		    

			ArrayList<Cinema> cinemalist = new ArrayList<Cinema>();
		    for(int i=0;i<arr.length;i++){ 
		    		  
		    		  Cinema test = null; 
		    		  test = test.getCinemaByID(Integer.parseInt(arr[i]));
		    		  cinemalist.add(new Cinema(test.getCinemaID(),test.getCinemaType(),test.getShowtimes()));		    		  
		    		  //
		               //ratinglist.add(Integer.parseInt(arr[i])); 
		              } 
		    cineplexlist.add(new Cineplex(cineid,cineplexname,cinemalist));
			
			
		    

	        //Cineplex cineplexadd = new Cineplex(cineid,cineplexname,cinematype);
 
		         
		    //movielist.add(new Movie(movieid, movietitle, genre, moviestatus, castlist, director, synposis, ratinglist, newsales, avgrating)); 
		     
			CountNoOfCinplex++; 
		   } 
		    
		  } catch (Exception e) { 
		   System.out.print(e); 
		  } 
		   
		  return cineplexlist; 
		   
		 } 
		  
		 /**
		 * The main method.
		 *
		 * @param args the arguments
		 * @throws Exception the exception
		 */
 		public static void main(String[] args) throws Exception { 
		   
		  int NoOfMovie = 0; 
		   
		  //System.out.println(getCurrentDirectory()); 
		   
		  CreateCineplexFile(); 
		  //WriteMovieListingFile(1, "Buzz Light Year", "NORMAL", "Showing", "DIRECTOR", "SYPNOSIS", "CAST1", "CAST2", 986.3, 102, 4.98); 
		  //WriteMovieListingFile(2, "Whzz Light Year", "TYPE", "STATUS", "DIRECTOR", "SYPNOSIS", "CAST1", "CAST2", 986.3, 102, 4.98); 
		  //WriteMovieListingFile(3, "Nazz Light Year", "TYPE", "STATUS", "DIRECTOR", "SYPNOSIS", "CAST1", "CAST2", 986.3, 102, 4.98); 
		   
		  CineplexNew_Intializer cineplex_init = new CineplexNew_Intializer(); 
		  ArrayList <Cineplex> capcineplex = cineplex_init.GetCineplexListing(); 
		   
		  cineplex_init.WriteCineplexListingFile(capcineplex); 
		  
		 } 

}
