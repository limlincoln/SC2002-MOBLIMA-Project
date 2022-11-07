package initializer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import entities.Booking;
import entities.Movie;
import entities.Customer;

public class Booking_Initializer extends GetDatabaseDirectory {
	
	public static final String DBfile = "Booking_History.txt";

	public static void CreateBookingHistoryFile() {
		String currentDirectory;
		String newDirectory;
		boolean checkfileexists = false;
		
		Booking_Initializer booking_init = new Booking_Initializer();
		currentDirectory = booking_init.getCurrentDirectory();

		newDirectory = currentDirectory;

		File create_bookinghistory_file = new File(newDirectory);

		try {
			if(!create_bookinghistory_file.exists()) {
				create_bookinghistory_file.mkdirs();
			}
			create_bookinghistory_file = new File(newDirectory + DBfile);
			checkfileexists = create_bookinghistory_file.createNewFile();
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(create_bookinghistory_file.getPath());

	}

	public static void GetBooking() {

		ArrayList<Booking> bookinglist = new ArrayList<Booking>();
		
		String currentDirectory;
		String newDirectory;

		String tid;

		int CountNoOfBooking = 0;

		Booking_Initializer booking_init = new Booking_Initializer();
		currentDirectory = booking_init.getCurrentDirectory();

		newDirectory = currentDirectory;

		try {
			BufferedReader br = new BufferedReader(new FileReader(newDirectory + "Booking_History.txt"));

			while(true) {
				final String line = br.readLine();

				if(line == null) {
					break;
				}

				String []data = line.split("\\|");
				

				tid = data[0];
				int TID = Integer.parseInt(tid);
				
				//add into bookinglist
				
				CountNoOfBooking++;
				
				//bookinglist.add(new Booking(TID, ));
				System.out.println(data[0] + ": " + data[3]);
			}

			
			System.out.println("No of movies: " + CountNoOfBooking);

		} catch (Exception e) {

		}

	}
	
public static void WriteBookingHistoryFile(String TID, String movid, String rating, String username, String phonenumber, String email) throws Exception {
		
		String currentDirectory;
		String newDirectory;
		String new_booking; 
		
		Booking_Initializer booking_init = new Booking_Initializer();
		currentDirectory = booking_init.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		File movielisting_file = new File(newDirectory);
		
		FileWriter write_movielisting = new FileWriter((newDirectory + "Booking_History.txt"), true);
		
		try {
			if(movielisting_file.exists()) {
				BufferedWriter buffer = new BufferedWriter(write_movielisting);
				
				new_booking = TID + "|" + movid + "|" + rating + "|" + username + "|" + phonenumber + "|" + email;
				buffer.write(new_booking);
				//buffer.append(System.lineSeparator());
				
				buffer.newLine();
				buffer.close();
			}
		}catch (Exception e){
			
		}
		
	}

	public static void main(String[] args) throws Exception {

		CreateBookingHistoryFile();
		//GetNoOfBooking("testuser1", "12345678");
		//GetNoOfBooking("testuser2", "12345678");
		GetBooking();
		//WriteBookingHistoryFile("TIDXXXYYYYMMDDhhmm", "05", "0.32", "testuser3", "12345678", "test@email");
	}
}
