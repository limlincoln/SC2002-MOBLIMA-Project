package initializer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import enums.DayOfWeek;
import entities.Holiday;

public class Holiday_Initializer extends GetDatabaseDirectory {

	public static final String DBfile = "Holidays.txt";

	public static void CreateHolidayFile() {

		String currentDirectory;
		String newDirectory;

		currentDirectory = Holiday_Initializer.getCurrentDirectory();

		newDirectory = currentDirectory;

		File create_holiday_file = new File(newDirectory);

		try {
			if(!create_holiday_file.exists()) {
				create_holiday_file.mkdirs();
			}
			create_holiday_file = new File(newDirectory + DBfile);
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(create_holiday_file.getPath());
	}

	public ArrayList<Holiday> GetHolidayListing() {

		ArrayList<Holiday> holidaylist = new ArrayList<Holiday>();

		String currentDirectory;
		String newDirectory;

		String date;

		int CountNoOfHolidays = 0;

		Holiday_Initializer holiday_init = new Holiday_Initializer();
		currentDirectory = holiday_init.getCurrentDirectory();

		newDirectory = currentDirectory;

		try {
			BufferedReader br = new BufferedReader(new FileReader(newDirectory + DBfile));

			while(true) {
				final String line = br.readLine();

				if(line == null) {
					break;
				}

				String []data = line.split("\\|");

				event = data[0];

				date = data[1];
				int dates = Integer.parseInt(date);

				switch(data[2]) {
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

				//holidaylist.add(new Holiday(event, dates, dayofweek));
				//holidaylist.add(new Holiday(event, dates, 1));
			}
		} catch (Exception e) {

		}
		
		return holidaylist;
	}


	public void NewHolidayListing(ArrayList<Holiday> holidaylist) {

		String currentDirectory;
		String newDirectory;

		String new_holiday;
		String date;
		DayOfWeek dayofweek = null;

		int CountNoOfHolidays = 0;

		Holiday_Initializer holiday_init = new Holiday_Initializer();
		currentDirectory = holiday_init.getCurrentDirectory();

		newDirectory = currentDirectory;

		File holiday_file = new File(newDirectory);

		

		try {
			if(holiday_file.exists()) {
				FileWriter write_holiday= new FileWriter((newDirectory + DBfile), true);
				BufferedWriter buffer = new BufferedWriter(write_holiday);


				for(Holiday holidays: holidaylist) {
					new_holiday = holidays.getName() + "|" + holidays.getDate() + "|" + holidays.getDayOfWeek();
					buffer.write(new_holiday);
					buffer.newLine();
				}

				//buffer.append(System.lineSeparator());

				buffer.close();
			}
		}catch (Exception e){

		}
	}

	public static void main(String[] args) {

		Holiday_Initializer holiday_init = new Holiday_Initializer();

		//holiday_init.CreateHolidayFile();
		
		ArrayList<Holiday> holidaylist = holiday_init.GetHolidayListing();
		
		holiday_init.NewHolidayListing(holidaylist);
	}

}
