package initializer;
import java.io.File;


import enums.AgeGroup;
import enums.CinemaClass;
import enums.CinemaType;
import enums.IPriceable;
import enums.PriceType;
import enums.TimeOfDay;
import enums.TypeOfDay;

import java.util.*;
import java.io.*;



public class Price_Initializer extends GetDatabaseDirectory {
	
	public static final String DBfile = "Price_Matrix.txt";
	
	
	public Price_Initializer(){}
	
	public static void  write(HashMap<IPriceable, Double> priceMatrix) {	
		String currentDirectory = Price_Initializer.getCurrentDirectory();
		
		String fileDir = currentDirectory + DBfile;

		try {
			File pricelisting_file = new File(fileDir);
			pricelisting_file.createNewFile();
			FileWriter write_bookinglisting = new FileWriter((fileDir), false);
			BufferedWriter buffer = new BufferedWriter(write_bookinglisting);
			String ageGroupString = "";
			String cineTypeString = "";
			String priceString = "";
			String timeString ="";
			String typeString ="";
			String classString ="";

			for(Map.Entry<IPriceable, Double> set:priceMatrix.entrySet()) {
				switch(set.getKey().getClass().getSimpleName().toString().toLowerCase()){
					case "agegroup":
						ageGroupString += "[" + set.getKey() + "," + set.getValue() + "]|";
						break;
					case "cinematype":
						cineTypeString += "[" + set.getKey() + "," + set.getValue() + "]|";
						break;
					case "pricetype":
						priceString += "[" + set.getKey() + "," + set.getValue() + "]|";
						break;
					case "timeofday":
						timeString += "[" + set.getKey() + "," + set.getValue() + "]|";
						break;
					case "typeofday":
						typeString += "[" + set.getKey() + "," + set.getValue() + "]|";
						break;
					case "cinemaclass":
						classString += "[" + set.getKey() + "," + set.getValue() + "]|";
						break;
					default:
						break;
				}
			}
			buffer.write(ageGroupString);
			buffer.newLine();
			buffer.write(cineTypeString);
			buffer.newLine();
			buffer.write(priceString);
			buffer.newLine();
			buffer.write(timeString);
			buffer.newLine();
			buffer.write(typeString);
			buffer.newLine();
			buffer.write(classString);

			buffer.close();
		}catch (IOException e){
			System.out.println("Error writing price matrix!");;
		}
		
	}
	
	public static HashMap<IPriceable,Double> read() {		
		String currentDirectory = Price_Initializer.getCurrentDirectory() ;
		String fileDir = currentDirectory + DBfile;
		HashMap<IPriceable,Double> priceMatrix = new HashMap<IPriceable,Double>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileDir));


			for(int whichEnum=0; whichEnum<6; whichEnum++) {
				final String line = br.readLine();

				if(line.isBlank()) {
					continue;
				}

				String[] dataFirstSplit = line.split("\\|");
				ArrayList<String[]> data = new ArrayList<String[]>();
				for(int i =0;i<dataFirstSplit.length; i++){
					data.add(dataFirstSplit[i].replaceAll("\\[|\\]| ", "").split(","));
				}

				// Read into correct price matrix format
				
				for(int i=0; i<data.size(); i++){
						IPriceable temp = null;
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
							case 5:
								temp = CinemaClass.valueOf(val);
								break;
						}
						priceMatrix.put(temp, Double.parseDouble(data.get(i)[1]));
				}	
			} 
			br.close();
		}catch (Exception e) {
			System.out.println("Error reading PriceMatrixFile: "+e.getMessage());
		}
		return priceMatrix;
	}
}
