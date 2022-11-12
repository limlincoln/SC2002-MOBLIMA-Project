package initializer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import entities.Cinema;
import entities.Cineplex;

public class CineplexIntializer extends GetDatabaseDirectory {

	public static final String DBfile = "Cineplex.txt";

	// public static void CreateCineplexFile() {
	// String currentDirectory;
	// String newDirectory;
	// boolean checkfileexists = false;

	// CineplexIntializer cineplex_init = new CineplexIntializer();
	// currentDirectory = cineplex_init.getCurrentDirectory();

	// newDirectory = currentDirectory;

	// File create_cineplex_file = new File(newDirectory);

	// try {
	// if(!create_cineplex_file.exists()) {
	// create_cineplex_file.mkdirs();
	// }
	// create_cineplex_file = new File(newDirectory + DBfile);
	// checkfileexists = create_cineplex_file.createNewFile();
	// } catch(Exception e) {
	// System.out.println(e);
	// }
	// System.out.println(create_cineplex_file.getPath());

	// }
	public static void writeCineplexListToFile(ArrayList<Cineplex> cineplexlist) throws Exception {

		String currentDirectory;
		String newDirectory;
		String new_cineplex;

		CineplexIntializer cineplex_init = new CineplexIntializer();
		currentDirectory = cineplex_init.getCurrentDirectory();

		newDirectory = currentDirectory;
		File cineplexlisting_file = new File(newDirectory);

		FileWriter write_cineplexlisting = new FileWriter((newDirectory + DBfile), true);

		try {
			if (cineplexlisting_file.exists()) {
				BufferedWriter buffer = new BufferedWriter(write_cineplexlisting);

				for (Cineplex cineplex : cineplexlist) {
					String cinemaIDs = "";
					for (Cinema cinema : cineplex.getCinemas()) {
						cinemaIDs += cinema.getCinemaID() + ",";
						CinemaInitializer.writeCinemaToFile(cinema);
					}
					new_cineplex = cineplex.getCineplexID() + "|" + cineplex.getCineplexName() + "|" + "[" + cinemaIDs
							+ "]";
					buffer.write(new_cineplex);
					buffer.newLine();
				}
				buffer.close();
			}
		} catch (Exception e) {

		}

	}

	public ArrayList<Cineplex> readCineplexListFromFile() {

		ArrayList<Cineplex> cineplexlist = new ArrayList<Cineplex>();

		String currentDirectory;
		String newDirectory;

		String cineplexid, cineplexname;

		CineplexIntializer cineplex_init = new CineplexIntializer();
		currentDirectory = cineplex_init.getCurrentDirectory();

		newDirectory = currentDirectory;

		try {
			BufferedReader br = new BufferedReader(new FileReader(newDirectory + DBfile));

			while (true) {
				final String line = br.readLine();

				if (line == null) {
					break;
				}

				String[] data = line.split("\\|");

				cineplexid = data[0];
				int cineid = Integer.parseInt(cineplexid);

				cineplexname = data[1];

				String arrayOfCinemaIDs = data[2];
				String[] arr = arrayOfCinemaIDs.replaceAll("\\[|\\]| ", "").split(",");

				ArrayList<Cinema> cinemalist = new ArrayList<Cinema>();
				for (int i = 0; i < arr.length; i++) {
					cinemalist.add(CinemaInitializer.readCinemaFromFile(Integer.parseInt(arr[i])));
				}
				cineplexlist.add(new Cineplex(cineid, cineplexname, cinemalist));
			}

		} catch (Exception e) {
			System.out.print(e);
		}

		return cineplexlist;

	}

}
