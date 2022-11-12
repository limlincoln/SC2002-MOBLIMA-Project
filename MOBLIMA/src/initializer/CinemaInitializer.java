package initializer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import entities.Cinema;
import entities.ShowTime;
import enums.CinemaClass;
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
		
		String stime;
		CinemaType cType = null;
		CinemaClass cc = null;
		
		currentDirectory = CinemaInitializer.getCurrentDirectory();
		
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
								
				cType = CinemaType.valueOf(data[1]);
				
				stime = data[2];
				String[] arr=stime.replaceAll("\\[|\\]| ", "").split(",");
		        for(int i=0;i<arr.length;i++){
		        	showtimelist.add(ShowTimeInitializer.readShowTimeFromFile(Integer.parseInt(arr[i])));
		        }
						
				String c = data[3];
				cc = CinemaClass.valueOf(c);

			}
			
		} catch (Exception e) {
			
		}

		return new Cinema(cid, cType, showtimelist,cc);
	}
		
	public static void writeCinemaToFile(Cinema cinema) {
		String currentDirectory;
		String newDirectory;
		
		currentDirectory = CinemaInitializer.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		
		String ShowCinemaFile = setCinemaFileName(cinema.getCinemaID());
		
		try {
			FileWriter write_cinema = new FileWriter((newDirectory + ShowCinemaFile));
			
			BufferedWriter buffer = new BufferedWriter(write_cinema);
			
			String showTimeIDs = "";
			for(ShowTime showtime: cinema.getShowtimes()) {
				ShowTimeInitializer.writeShowTimeToFile(showtime);
				showTimeIDs += showtime.getShowTimeID() + ",";
			}
			String newcinema = cinema.getCinemaID() + "|" + cinema.getCinemaType() + "|" + "[" + showTimeIDs + "]" + "|" + cinema.getCinemaClass();
			
			buffer.write(newcinema);
			buffer.close();
				
		} catch (Exception e) {
			
		}
	}
}
