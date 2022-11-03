package initializer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Booking_Initializer implements IGetCurrentDirectory {

	public String getCurrentDirectory() {
		String executionPath = System.getProperty("user.dir");

		return executionPath;
	}

	public static void CreateBookingHistoryFile() {
		String currentDirectory;
		String newDirectory;
		boolean checkfileexists = false;
		
		Booking_Initializer booking_init = new Booking_Initializer();
		currentDirectory = booking_init.getCurrentDirectory();

		newDirectory = currentDirectory + "\\Database\\";

		File create_bookinghistory_file = new File(newDirectory);

		try {
			if(!create_bookinghistory_file.exists()) {
				create_bookinghistory_file.mkdirs();
			}
			create_bookinghistory_file = new File(newDirectory + "Booking_History.txt");
			checkfileexists = create_bookinghistory_file.createNewFile();
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(create_bookinghistory_file.getPath());

	}

	public static void GetNoOfBooking(String username, String phonenumber) {

		String currentDirectory;
		String newDirectory;

		String TID, movid, rating;
		String read_username, read_phonenumber, email;

		int CountNoOfBooking = 0;

		Booking_Initializer booking_init = new Booking_Initializer();
		currentDirectory = booking_init.getCurrentDirectory();

		newDirectory = currentDirectory + "\\Database\\";

		try {
			BufferedReader br = new BufferedReader(new FileReader(newDirectory + "Booking_History.txt"));

			while(true) {
				final String line = br.readLine();

				if(line == null) {
					break;
				}

				String []data = line.split("\\|");
				
				if(data[3].contentEquals(username) && data[4].contentEquals(phonenumber)) {
					TID = data[0];
					movid = data[1];
					rating = data[2];
					read_username = data[3];
					read_phonenumber = data[4];
					email = data[5];
					CountNoOfBooking++;
				}


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
		
		newDirectory = currentDirectory + "\\Database\\";
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
		GetNoOfBooking("testuser3", "12345678");
		//WriteBookingHistoryFile("TIDXXXYYYYMMDDhhmm", "05", "0.32", "testuser3", "12345678", "test@email");
	}
}
