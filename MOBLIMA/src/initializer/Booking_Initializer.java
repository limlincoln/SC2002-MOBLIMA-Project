package initializer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import entities.Booking;
import entities.Customer;
import entities.Ticket;

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

	public static ArrayList<Booking> GetBooking(ArrayList<Ticket> tickets) {

		ArrayList<Booking> bookinglist = new ArrayList<Booking>();
		
		String currentDirectory;
		String newDirectory;

		String tid;
		String movid, ratingStr, customerid;
		String customerIDStr, userNameStr, phoneNumberStr, emailStr;
		String ticketdetails;
		String cost;

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
				
				customerIDStr = data[2];
				int customerID = Integer.parseInt(customerIDStr);

				userNameStr = data[3];
				
				phoneNumberStr = data[4];

				emailStr = data[5];
				
				ticketdetails = data[6];
				String[] arr=ticketdetails.replaceAll("\\[|\\]| ", "").split(",");

				ArrayList<Ticket> userTickets = new ArrayList<Ticket>();
				for(Ticket ticket: tickets) {
					for(int i = 0; i < arr.length; i++) {
						if(ticket.getTicketID() == Integer.parseInt(arr[i])) {
							userTickets.add(ticket);
						}
					}
				}
				cost = data[7];
				double totalcost = Double.parseDouble(cost);
 
				ratingStr = data[8];
				int rating = Integer.parseInt(ratingStr);
				
				Customer customer_booking = new Customer(customerID, userNameStr, emailStr, phoneNumberStr);
				
				bookinglist.add(new Booking(TID, movieid, customer_booking, userTickets, totalcost, rating));
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
					String ticketIDs = "";
					for(Ticket ticket: booking.getTickets()) {
						ticketIDs += Integer.toString(ticket.getTicketID()) + ",";
					}
					new_booking = booking.getTID() + "|" + booking.getMovieID() + "|" + booking.getCustomer().getCustomerID() + "|" + booking.getCustomer().getUserName() + "|" + booking.getCustomer().getPhoneNumber() + "|" + booking.getCustomer().getEmail() + "|" + "[" + ticketIDs + "]" + "|" + booking.getTotalCost();
					buffer.write(new_booking);
					buffer.newLine();
				}
			}
		}catch (Exception e){
			
		}
		
	}
}
