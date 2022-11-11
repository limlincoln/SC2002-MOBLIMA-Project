package initializer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import entities.Booking;
import entities.Movie;
import entities.Customer;
import entities.Ticket;
import enums.DayOfWeek;
import enums.Status;
import enums.TimeOfDay;
import enums.TypeOfDay;
import enums.AgeGroup;

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

	public static ArrayList<Booking> GetBooking() {

		ArrayList<Booking> bookinglist = new ArrayList<Booking>();
		
		String currentDirectory;
		String newDirectory;

		String tid;
		String movid, rating, customerid;
		String read_username, read_phonenumber, email;
		String ticketdetails;
		String cost;
		
		DayOfWeek dayofweek = null;
		TimeOfDay timeofday = null;
		AgeGroup agegroup = null;
		TypeOfDay typeOfDay = null;
		LocalDateTime exactDateTime = null;
		String seat = null;

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
					
					movid = data[1];
					int movieid = Integer.parseInt(movid);
					
					customerid = data[2];
					int customerID = Integer.parseInt(customerid);
					
					read_username = data[3];
					email = data[4];
					
					read_phonenumber = data[5];
					int phonenumber = Integer.parseInt(read_phonenumber);
					
					ticketdetails = data[6];
					String[] arr=ticketdetails.replaceAll("\\[|\\]| ", "").split(",");
			        for(int i=0;i<arr.length;i++){

			        }
			        
			        cost = data[7];
			        double totalcost = Double.parseDouble(cost);

					
					Customer customer_booking = new Customer(customerID, read_username, email, Integer.toString(phonenumber));
					
					Ticket ticket = new Ticket(dayofweek, timeofday, agegroup);
					
					ArrayList<Ticket> ticketlist = new ArrayList<Ticket>();
					ticketlist.add(ticket);
					
					bookinglist.add(new Booking(TID, movieid, customer_booking, ticketlist, totalcost));
					CountNoOfBooking++;
				
				
				System.out.println(data[0] + ": " + data[5]);
			}

			
			System.out.println("No of movies: " + CountNoOfBooking);

		} catch (Exception e) {

		}
		
		return bookinglist;
	}
	
public static void WriteBookingHistoryFile(ArrayList<Booking> bookinglist) throws Exception {
		
		String currentDirectory;
		String newDirectory;
		String new_booking; 
		
		Booking_Initializer booking_init = new Booking_Initializer();
		currentDirectory = booking_init.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		File movielisting_file = new File(newDirectory);
		
		FileWriter write_bookinglisting = new FileWriter((newDirectory + "Booking_History.txt"), true);
		
		try {
			if(movielisting_file.exists()) {
				BufferedWriter buffer = new BufferedWriter(write_bookinglisting);
				
				for(Booking booking: bookinglist) {
					new_booking = booking.getTID() + "|" + booking.getMovie() + "|" + booking.getCustomer() + "|" + booking.getTickets() + "|" + booking.getTotalCost();
					buffer.write(new_booking);
					buffer.newLine();
				}
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
