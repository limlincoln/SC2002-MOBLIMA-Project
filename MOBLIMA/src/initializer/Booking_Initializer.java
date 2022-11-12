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

	public static ArrayList<Booking> read() {

		ArrayList<Booking> bookinglist = new ArrayList<Booking>();
		
		String currentDirectory;

		String tid;
		String movid, ratingStr;
		String customerIDStr, userNameStr, phoneNumberStr, emailStr;
		String ticketdetails;
		String cost;

		currentDirectory = Booking_Initializer.getCurrentDirectory();

		String fileDir = currentDirectory + DBfile;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileDir));

			while(true) {
				final String line = br.readLine();

				if(line == null) {
					br.close();
					return bookinglist;
				}

				String []data = line.split("\\|");
				
				// TID
				tid = data[0];
				
				// MOVIE ID
				movid = data[1];
				int movieid = Integer.parseInt(movid);
				
				// CUSTOMER ID
				customerIDStr = data[2];
				int customerID = Integer.parseInt(customerIDStr);

				// CUSTOMER NAME
				userNameStr = data[3];
				// CUSTOMER HP NO.
				phoneNumberStr = data[4];
				// CUSTOMER EMAIL
				emailStr = data[5];
				
				// TICKET ID ARRAY
				ticketdetails = data[6];
				String[] arr=ticketdetails.replaceAll("\\[|\\]| ", "").split(",");

				ArrayList<Ticket> userTickets = new ArrayList<Ticket>();
				for(int i = 0; i < arr.length; i++) {
					Ticket temp = null;
					temp = TicketInitializer.read(arr[i]);
					if(temp!=null){
						userTickets.add(temp);
					}
				}
				
				cost = data[7];
				double totalcost = Double.parseDouble(cost);
 
				ratingStr = data[8];
				int rating = Integer.parseInt(ratingStr);
				
				Customer customer_booking = new Customer(customerID, userNameStr, emailStr, phoneNumberStr);
				
				bookinglist.add(new Booking(tid, movieid, customer_booking, userTickets, totalcost, rating));
				
		}
		} catch (Exception e) {
			System.out.println("Error in booking initializer : " +e.getMessage());
		}
		return bookinglist;
	}
	
public static void write(ArrayList<Booking> bookinglist) {
		
		String currentDirectory;
		String new_booking; 
		
		currentDirectory = Booking_Initializer.getCurrentDirectory();
		
		String fileDir = currentDirectory + DBfile;
		File movielisting_file = new File(fileDir);
		try {
			FileWriter write_bookinglisting = new FileWriter((movielisting_file), false);
			BufferedWriter buffer = new BufferedWriter(write_bookinglisting);
			
			for(Booking booking: bookinglist) {
				String ticketIDs = "";
				TicketInitializer.write(booking.getTickets());
				for(Ticket ticket: booking.getTickets()) {
					ticketIDs += Integer.toString(ticket.getTicketID()) + ",";
				}
				ticketIDs = ticketIDs.substring(0, ticketIDs.length()-1);
				new_booking = booking.getTID() + "|" 
										+ booking.getMovieID() + "|" 
										+ booking.getCustomer().getCustomerID() + "|" 
										+ booking.getCustomer().getUserName() + "|" 
										+ booking.getCustomer().getPhoneNumber() + "|" 
										+ booking.getCustomer().getEmail() + "|" 
										+ "[" + ticketIDs + "]" + "|" 
										+ booking.getTotalCost() + "|"
										+ booking.getRating();

				buffer.write(new_booking);
				buffer.newLine();
			}
			buffer.close();
			
		}catch (Exception e){
			System.out.println("Error writing bookings : " + e.getMessage());
		}
	}
}
