package initializer;
import java.io.File;
import managers.SettingsManager;
import menus.ITop5Menu;
import menus.Top5ByRatingMenu;
import menus.Top5BySalesMenu;
import menus.Top5OptionsMenu;

import java.io.*;



public class Settings_Initializer extends GetDatabaseDirectory {
	
	public static final String DBfile = "settings.txt";
	
	public Settings_Initializer(){}
	
	public static void write(SettingsManager settings) {	
		String currentDirectory = Settings_Initializer.getCurrentDirectory();
		String fileDir = currentDirectory + DBfile;

		try {
			File settings_file = new File(fileDir);
			settings_file.createNewFile();
			FileWriter write_settings = new FileWriter((fileDir), false);
			BufferedWriter buffer = new BufferedWriter(write_settings);
			
      String classname = settings.getCustomerTop5MenuClass().getClass().getSimpleName().toString().toLowerCase();
			// buffer.write(settings.getCustomerTop5MenuClass());
			String result = "";
			switch(classname){
				case "top5bysalesmenu":
					result = "0";
					break;
				case "top5byratingmenu":
					result = "1";
					break;
				case "top5optionsmenu":
				default:	
					result = "2";
					break;
			}
			buffer.write(result);
			System.out.println("Settings Write Successful!");
			buffer.close();
		}catch (IOException e){
			System.out.println("Error writing settings! : " + e.getMessage());;
		}
		
	}
	
	public static void read() {		
		String currentDirectory = Settings_Initializer.getCurrentDirectory();
		String fileDir = currentDirectory + DBfile;

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileDir));

			Integer menuOption = Integer.parseInt(br.readLine());

			ITop5Menu menu = null;
			switch(menuOption){
				case 0:
					menu = Top5BySalesMenu.getInstance();
					break;
				case 1:
					menu = Top5ByRatingMenu.getInstance();
					break;
				case 2:
				default:	
					menu = Top5OptionsMenu.getInstance();
					break;
			}

			SettingsManager.initialize(menu);
			System.out.println("Settings Manager Initialized successfully");
 
			br.close();
		}catch (Exception e) {
			System.out.println("Error reading PriceMatrixFile: "+e.getMessage());
		}
		return;
	}
}
