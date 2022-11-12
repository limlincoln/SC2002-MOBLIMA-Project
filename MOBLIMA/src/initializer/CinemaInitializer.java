package initializer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import entities.Cinema;
import entities.ShowTime;
import enums.CinemaType;

public class CinemaInitializer extends GetDatabaseDirectory {
	
	public static String setCinemaFileName(int cinemaid) {

		String seatingsfolder = "Cinema" + separator;

		final String DBfile = "Cinema.txt";

		return(seatingsfolder+cinemaid+DBfile);
	}
		
	public static Cinema readCinemaFromFile(int cid) {
		String currentDirectory;
		String newDirectory;
		
		String cinemaid, stime;
		CinemaType cType = null;
		
		CinemaInitializer cinema_init = new CinemaInitializer();
		currentDirectory = cinema_init.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		
		String ShowCinemaFile = setCinemaFileName(cid);
		ArrayList<ShowTime> showtimelist = new ArrayList<ShowTime>();
		
		try {		
			BufferedReader br = new BufferedReader(new FileReader(newDirectory + ShowCinemaFile));
			
			while(true) {
				final String line = br.readLine();

				if(line == null) {
					break;
				}
				
				String []data = line.split("\\|");
				
				cinemaid = data[0];
				Integer CinemaID = Integer.parseInt(cinemaid);
				
				cType = CinemaType.valueOf(data[1]);
				
				stime = data[2];
				String[] arr=stime.replaceAll("\\[|\\]| ", "").split(",");
		        for(int i=0;i<arr.length;i++){
		        	showtimelist.add(ShowTimeInitializer.readShowTimeFromFile(Integer.parseInt(arr[i])));
		        }							
			}
			
		} catch (Exception e) {
			
		}

		return new Cinema(cid, cType, showtimelist);
	}
		
	public static void writeCinemaToFile(Cinema cinema) {
		String currentDirectory;
		String newDirectory;
		
		CinemaInitializer showtime_init = new CinemaInitializer();
		currentDirectory = showtime_init.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		File cinemalisting_file = new File(newDirectory);
		
		String ShowCinemaFile = setCinemaFileName(cinema.getCinemaID());
		
		try {
			FileWriter write_cinema = new FileWriter((newDirectory + ShowCinemaFile));
			
			BufferedWriter buffer = new BufferedWriter(write_cinema);
			
			String showTimeIDs = "";
			for(ShowTime showtime: cinema.getShowtimes()) {
				ShowTimeInitializer.writeShowTimeToFile(showtime);
				showTimeIDs += showtime.getShowTimeID() + ",";
			}
			String newcinema = cinema.getCinemaID() + "|" + cinema.getCinemaType() + "|" + "[" + showTimeIDs + "]";
			
			buffer.write(newcinema);
			buffer.close();
				
		} catch (Exception e) {
			
		}
	}
}
