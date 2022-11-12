package initializer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entities.ISeat;
import entities.Seat;
import entities.Seats;
import entities.Space;

public class SeatsInitializer extends GetDatabaseDirectory {

	public static String setSeatingsFileName(int seatid) {

		String seatingsfolder = "/Seatings/";

		String DBfile = "Seatings.txt";

		return (seatingsfolder + seatid + DBfile);
	}

	// public static void CreateCineplexFile(int seatid) {

	// String currentDirectory;
	// String newDirectory;
	// boolean checkfileexists = false;

	// Seats_Initializer cineplexseats_init = new Seats_Initializer();
	// currentDirectory = cineplexseats_init.getCurrentDirectory();

	// newDirectory = currentDirectory;

	// String SeatingsFile = setSeatingsFileName(seatid);

	// File create_cineplexseats_file = new File(newDirectory);

	// try {
	// if(!create_cineplexseats_file.exists()) {
	// create_cineplexseats_file.mkdirs();
	// }
	// create_cineplexseats_file = new File(newDirectory + SeatingsFile);
	// checkfileexists = create_cineplexseats_file.createNewFile();
	// } catch(Exception e) {
	// System.out.println(e);
	// }
	// System.out.println(create_cineplexseats_file.getPath());

	// }

	public static void writeSeatsToFile(Seats seats) {

		String currentDirectory;
		String newDirectory;

		SeatsInitializer cineplexseats_init = new SeatsInitializer();
		currentDirectory = cineplexseats_init.getCurrentDirectory();

		newDirectory = currentDirectory;

		ISeat[][] seatsArray = seats.getSeats();

		try {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < seatsArray.length; i++) {
				for (int j = 0; j < seatsArray[0].length; j++) {
					builder.append(seatsArray[i][j].getStateInt());
					if (j < seatsArray[0].length - 1)
						builder.append(",");
				}
				builder.append("\n");
			}

			String SeatingsFile = setSeatingsFileName(seats.getSeatsID());

			FileWriter writeSeats = new FileWriter((newDirectory + SeatingsFile));
			BufferedWriter buffer = new BufferedWriter(writeSeats);

			buffer.write(builder.toString());// save the string representation of the board
			buffer.close();

		} catch (IOException e) {

		}

	}

	public static Seats readSeatsFromFile(int seatsID) {
		String currentDirectory;
		String newDirectory;

		SeatsInitializer cineplexseats_init = new SeatsInitializer();
		currentDirectory = cineplexseats_init.getCurrentDirectory();

		newDirectory = currentDirectory;
		ISeat[][] seatsArray = new ISeat[0][0];

		String SeatingsFile = setSeatingsFileName(seatsID);

		try {
			BufferedReader br = new BufferedReader(new FileReader(newDirectory + SeatingsFile));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] rows = line.split("-");
				System.out.println("Row lengh: "+rows.length);
				seatsArray = new ISeat[rows.length][rows[0].length()];
				for(int i = 0; i < rows.length; i++) {
					System.out.println("Seat ID: "+seatsID);
					System.out.println("Rows: "+rows[i]);
					String[] cols = rows[i].split(",");
					for(int j = 0; j < cols.length; j++) {
						switch(cols[j]) {
							case "2":
								seatsArray[i][j] = new Space();
								break;
							case "0":
								Seat newSeat = new Seat();
								newSeat.toggleOccupied();
								seatsArray[i][j] = newSeat;
								break;
							case "1":
								seatsArray[i][j] = new Seat();
						}
					}
				}
			}
			br.close();

		} catch (Exception e) {

		}

		Seats seat = new Seats(seatsID, seatsArray);
		// System.out.println("From witihin:");
		// for (int i = 0; i < seatsArray.length; i++) {
		// 	for (int j = 0; j < seatsArray[0].length; j++) {
		// 		System.out.print(seatsArray[i][j]);
		// 	}
		// 	System.out.print("\n");
		// }

		return seat;
	}
}
