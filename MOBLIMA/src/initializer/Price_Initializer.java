package initializer;
import java.io.File;


import enums.AgeGroup;
import enums.CinemaType;
import enums.PriceType;
import enums.TimeOfDay;
import enums.TypeOfDay;


import java.util.*;
import java.io.*;



public class Price_Initializer extends GetDatabaseDirectory {
	
	public static final String DBfile = "Price_Matrix.txt";
	
	
	public Price_Initializer(){}
	
	public static void  write(HashMap<Object, Double> priceMatrix) {	
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

			for(Map.Entry<Object, Double> set:priceMatrix.entrySet()) {
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

			System.out.println("Price Matrix Write Successful!");
			buffer.close();
		}catch (IOException e){
			System.out.println("Error writing price matrix!");;
		}
		
	}
	
	public static HashMap<Object,Double> read() {		
		String currentDirectory = Price_Initializer.getCurrentDirectory() ;
		String fileDir = currentDirectory + DBfile;
		HashMap<Object,Double> priceMatrix = new HashMap<Object,Double>();

		try {
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
			br.close();
		}catch (Exception e) {
			System.out.println("Error reading PriceMatrixFile: "+e.getMessage());
		}
		return priceMatrix;
	}
}
