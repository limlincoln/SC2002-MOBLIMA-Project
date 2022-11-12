package initializer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import entities.Booking;
import entities.Movie;
import entities.Customer;
import entities.Ticket;
import enums.DayOfWeek;
import enums.Status;
import enums.TimeOfDay;
import enums.TypeOfDay;
import enums.AgeGroup;

// TODO: Auto-generated Javadoc
/**
 * The Class TicketInitializer.
 */
public class TicketInitializer extends GetDatabaseDirectory {

	/**
	 * Sets the ticket name.
	 *
	 * @param ticketid the ticketid
	 * @return the string
	 */
	public static String setTicketName(int ticketid) {

		String seatingsfolder = "\\Tickets\\";

		final String DBfile = "Tickets.txt";

		return(seatingsfolder+ticketid+DBfile);
	}

	/**
	 * Creates the ticket file.
	 *
	 * @param ticketid the ticketid
	 */
	public static void CreateTicketFile(int ticketid) {

		String currentDirectory;
		String newDirectory;
		boolean checkfileexists = false;

		TicketInitializer ticket_init = new TicketInitializer();
		currentDirectory = ticket_init.getCurrentDirectory();

		newDirectory = currentDirectory;
		String SeatingsFile = setShowTicketName(ticketid);

		File create_ticket_file = new File(newDirectory);

		try {
			if(!create_ticket_file.exists()) {
				create_ticket_file.mkdirs();
			}
			create_ticket_file = new File(newDirectory + SeatingsFile);
			checkfileexists = create_ticket_file.createNewFile();
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(create_ticket_file.getPath());
	}

	/**
	 * Read tickets.
	 *
	 * @param ticketid the ticketid
	 * @return the array list
	 */
	public static ArrayList<Ticket> ReadTickets(int ticketid) {

		ArrayList<Ticket> ticketlist = new ArrayList<Ticket>();

		String currentDirectory;
		String newDirectory;

		String tid;
		Integer seats;

		DayOfWeek dayofweek = null;
		TimeOfDay timeofday = null;
		TypeOfDay typeofday = null;
		AgeGroup agegroup = null;

		int CountNoOfBooking = 0;

		TicketInitializer ticket_init = new TicketInitializer();
		currentDirectory = ticket_init.getCurrentDirectory();

		newDirectory = currentDirectory;

		File ticket_file = new File(newDirectory);

		String ShowTicketFile = setTicketName(ticketid);

		try {
			BufferedReader br = new BufferedReader(new FileReader(newDirectory + ShowTicketFile));

			while(true) {
				final String line = br.readLine();

				if(line == null) {
					break;
				}
				String []data = line.split("\\|");

				tid = data[0];
				Integer TicketID = Integer.parseInt(tid);

				switch(data[1]) {
				case "SUN":
					dayofweek = DayOfWeek.SUN;
					break;

				case "MON":
					dayofweek = DayOfWeek.MON;
					break;

				case "TUE":
					dayofweek = DayOfWeek.TUE;
					break;

				case "WED":
					dayofweek = DayOfWeek.WED;
					break;

				case "THU":
					dayofweek = DayOfWeek.THU;
					break;

				case "FRI":
					dayofweek = DayOfWeek.FRI;
					break;

				case "SAT":
					dayofweek = DayOfWeek.SAT;
					break;	
				}

				switch(data[2]) {
				case "BEFORE_6":
					timeofday = TimeOfDay.BEFORE_6;
					break;

				case "AFTER_6":
					timeofday = TimeOfDay.AFTER_6;
					break;	
				}

				switch(data[3]) {
				case "ADULT":
					agegroup = AgeGroup.ADULT;
					break;

				case "SENIOR":
					agegroup = AgeGroup.SENIOR;
					break;

				case "STUDENT":
					agegroup = AgeGroup.STUDENT;
					break;
				}
				switch(data[4]) {
				case "WEEKEND":
					typeofday = TypeOfDay.WEEKEND;
					break;

				case "WEEKDAY":
					typeofday = TypeOfDay.WEEKDAY;
					break;	
				case "PUBLIC_HOLIDAY":
					typeofday = TypeOfDay.PUBLIC_HOLIDAY;
					break;
				}

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddhhmm");
				LocalDateTime exactDateTime = LocalDateTime.parse(data[5], formatter);

				String seat = data[6];
				seats = Integer.parseInt(seat);
				
				ticketlist.add(new Ticket(TicketID, dayofweek, agegroup, typeofday, exactDateTime, seat));
			}

		}catch (Exception e) {

			}
		
		return ticketlist;
		}
	
		/**
		 * Creates the ticket.
		 *
		 * @param ticketid      the ticketid
		 * @param dayofweek     the dayofweek
		 * @param timeofday     the timeofday
		 * @param exactdatetime the exactdatetime
		 * @param agegroup      the agegroup
		 * @param seat          the seat
		 */
		public static void CreateTicket(int ticketid, DayOfWeek dayofweek, TimeOfDay timeofday, LocalDateTime exactdatetime, AgeGroup agegroup, String seat) {
			
			String currentDirectory;
			String newDirectory;
			
			Cinema_Initializer showtime_init = new Cinema_Initializer();
			currentDirectory = showtime_init.getCurrentDirectory();
			
			newDirectory = currentDirectory;
			File ticket_file = new File(newDirectory);
			
			String ShowTicketFile = setTicketName(ticketid);
			
			File create_ticket_file = new File(newDirectory);
			
			try {
				FileWriter write_ticket = new FileWriter((newDirectory + ShowTicketFile), true);
				
				if(create_ticket_file.exists()) {
					BufferedWriter buffer = new BufferedWriter(write_ticket);
					
					String newticket = ticketid + "|" + dayofweek + "|" + timeofday + "|" + exactdatetime + "|" + agegroup + "|" + seat;
					
					buffer.write(newticket);
					buffer.newLine();
				}
				
			} catch(Exception e) {
				
			}
			
		}
    }

