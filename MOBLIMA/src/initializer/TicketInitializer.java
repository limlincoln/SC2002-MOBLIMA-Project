package initializer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import entities.Ticket;
import enums.DayOfWeek;
import enums.TimeOfDay;
import enums.TypeOfDay;
import enums.AgeGroup;

public class TicketInitializer extends GetDatabaseDirectory {
	public static final String DBFolder = "Tickets";
	public static final String DBfile = "Tickets.txt";

	
	/** 
	 * @param ticketid
	 * @return Ticket
	 */
	public static Ticket read(String ticketid) {
		String currentDirectory;
		String fileDir;
		String tid;
		DayOfWeek dayofweek = null;
		TimeOfDay timeofday = null;
		TypeOfDay typeofday = null;
		AgeGroup agegroup = null;
		Ticket result = null;

		currentDirectory = TicketInitializer.getCurrentDirectory();

		fileDir = currentDirectory+DBFolder+separator+ticketid+DBfile;

		File ticket_file = new File(fileDir);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(ticket_file));

				final String line = br.readLine();

				if(line == null) {
					br.close();
					return result;
				}
				String []data = line.split("\\|");

				// ID
				tid = data[0];
				Integer TicketID = Integer.parseInt(tid);
				
				// day of week
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

				// time of day
				switch(data[2]) {
				case "BEFORE_6":
					timeofday = TimeOfDay.BEFORE_6;
					break;

				case "AFTER_6":
					timeofday = TimeOfDay.AFTER_6;
					break;	
				}

				// agegroup
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
				
				// type of day
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

				// excat date time
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
				LocalDateTime exactDateTime = LocalDateTime.parse(data[5], formatter);

				// seat string
				String seat = data[6];
				
				result = new Ticket(TicketID, dayofweek,timeofday, agegroup, typeofday, exactDateTime, seat);
		}catch (Exception e) {
			System.out.println("Error in ticket initializer: " + e.getMessage());
		}
		return result;
	}
			
	
		
		/** 
		 * @param tickets
		 */
		public static void write(ArrayList<Ticket> tickets) {
			String currentDirectory = TicketInitializer.getCurrentDirectory();
			

			for(Ticket ticket : tickets){
				try {
					// get filepath name for the ticket
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
					String fileDir = currentDirectory+DBFolder+separator+ticket.getTicketID()+DBfile;
					File ticket_file = new File(fileDir);
					ticket_file.createNewFile();
					FileWriter write_ticket = new FileWriter(ticket_file, false);
					BufferedWriter buffer = new BufferedWriter(write_ticket);
						
					String newticket = ticket.getTicketID() + "|" + 
														ticket.getDayOfWeek() + "|" + 
														ticket.getTimeOfDay() + "|" + 
														ticket.getAgeGroup() + "|" + 
														ticket.getTypeOfDay() + "|" + 
														ticket.getExactDateTime().format(formatter) + "|" +
														ticket.getSeat();
					buffer.write(newticket);
					buffer.close();
				} catch(Exception e) {
					System.out.println("Error when writing tickets :"+ e.getMessage());
				}
			}
		}

		// public static void main(String[] args) {
		// 	// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
		// 	LocalDateTime exactDateTime = LocalDateTime.of(1986, 4, 8, 10 , 10);
		// 	System.out.println(exactDateTime);
		// 	// String datestring = exactDateTime.format(formatter);
		// 	// System.out.println(datestring);

		// 	// LocalDateTime test = LocalDateTime.parse(datestring, formatter);
		// 	// System.out.println(test);

		// 	// System.out.println(exactDateTime);
		// 	Ticket tic = new Ticket(15, DayOfWeek.FRI, TimeOfDay.AFTER_6, AgeGroup.ADULT, TypeOfDay.PUBLIC_HOLIDAY, exactDateTime ,"A1");
		// 	Ticket tic1 = new Ticket(10, DayOfWeek.FRI, TimeOfDay.AFTER_6, AgeGroup.ADULT, TypeOfDay.PUBLIC_HOLIDAY, exactDateTime , "A5");
		// 	ArrayList<Ticket> tics = new ArrayList<Ticket>();
		// 	tics.add(tic);
		// 	tics.add(tic1);

		// 	TicketInitializer.write(tics);

		// 	System.out.println(TicketInitializer.read("10").getExactDateTime());
		// 	System.out.println(TicketInitializer.read("15"));
		// }
}
