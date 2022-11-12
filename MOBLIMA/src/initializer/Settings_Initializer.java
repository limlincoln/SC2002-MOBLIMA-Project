package initializer;
import java.io.File;


import enums.AgeGroup;
import enums.CinemaType;
import enums.PriceType;
import enums.TimeOfDay;
import enums.TypeOfDay;
import managers.SettingsManager;

import java.util.*;
import java.io.*;



public class Settings_Initializer extends GetDatabaseDirectory {
	
	public static final String DBfile = "settings.txt";
	
	
	public Settings_Initializer(){}
	
	public void write(SettingsManager settings) {	
		Settings_Initializer settings_init = new Settings_Initializer();
		String currentDirectory = settings_init.getCurrentDirectory();
		
		String fileDir = currentDirectory + DBfile;

		try {
			File settings_file = new File(fileDir);
			settings_file.createNewFile();
			FileWriter write_settings = new FileWriter((fileDir), false);
			BufferedWriter buffer = new BufferedWriter(write_settings);
			
      System.out.println(settings.getCustomerTop5MenuClass().getClass().getSimpleName().toString().toLowerCase());
			// buffer.write(settings.getCustomerTop5MenuClass());
			
			System.out.println("Settings Write Successful!");
			buffer.close();
		}catch (IOException e){
			System.out.println("Error writing settings! : " + e.getMessage());;
		}
		
	}
	
	public void read() {		
		Price_Initializer price_init = new Price_Initializer();
		String currentDirectory = price_init.getCurrentDirectory() ;
		String fileDir = currentDirectory + DBfile;
		HashMap<Object,Double> priceMatrix = new HashMap<Object,Double>();

		try {
			File pricematrix_file = new File(fileDir);
			
			FileInputStream fis = new FileInputStream (pricematrix_file);
			
			Scanner sc = new Scanner(fis);
			
			HashMap<Object,Double> mapInFile = new HashMap<Object,Double>();
			
			BufferedReader br = new BufferedReader(new FileReader(fileDir));


			for(int whichEnum=0; whichEnum<5; whichEnum++) {
				final String line = br.readLine();

				if(line.isBlank()) {
					continue;
				}
				System.out.println("Which enum: " + whichEnum);
				System.out.println("Line: " + line);

				String[] dataFirstSplit = line.split("\\|");
				ArrayList<String[]> data = new ArrayList<String[]>();
				for(int i =0;i<dataFirstSplit.length; i++){
					data.add(dataFirstSplit[i].replaceAll("\\[|\\]| ", "").split(","));
				}

				// Read into correct price matrix format
				
				for(int i=0; i<data.size(); i++){
						Object temp = null;
						String val = data.get(i)[0];
						switch(whichEnum){
							case 0:
								temp = AgeGroup.valueOf(val);
								break;
							case 1:
								temp = CinemaType.valueOf(val);
								break;
							case 2:
								temp = PriceType.valueOf(val);
								break;
							case 3:
								temp = TimeOfDay.valueOf(val);
								break;
							case 4:
								temp = TypeOfDay.valueOf(val);
								break;
						}
						priceMatrix.put(temp, Double.parseDouble(data.get(i)[1]));
				}	
			} 
			sc.close();
			br.close();
		}catch (Exception e) {
			System.out.println("Error reading PriceMatrixFile: "+e.getMessage());
		}
		return;
	}

  public static void main(String[] args) {
    SettingsManager test 
  }
}
