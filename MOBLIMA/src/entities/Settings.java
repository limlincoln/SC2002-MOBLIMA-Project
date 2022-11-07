//import utils.ProjectRootPathFinder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//settings class
public class Settings implements Serializable {
	// Attributes
	private Map<String, Map<Object, Object>> systemInfoHash;	
	private List<String> systemInfoList;

	// Constructor
	public Settings() {
		this.setsystemInfoList();
		this.setSystemInfoHash();
	}	
	
	// Get
	public List<String> getsystemInfoList(){
		return this.systemInfoList;
	}

	public Map<String, Map<Object, Object>> getSystemInfoHash(){
		return this.systemInfoHash;
	}

	public double getPrice(String key){
		return (double) this.getSystemInfoHash().get("priceReference").get(key);
	}
	
	public boolean isHoliday(LocalDate key) {
		String temp = (String) this.getSystemInfoHash().get("holidayReference").get(key);
		if (temp==null) {
			return false;
		} 
		else {
			return true;
		}
	}
	 
	// CRUD methods
	public void viewSetting(String infoType) {
		System.out.println(this.getSystemInfoHash().get(infoType));
	}
	
	public void addSetting(String infoType, Object key, Object value) {
		if (infoType.equals("holidayReference")) {
			this.systemInfoHash.get(infoType).put((LocalDate) key, (String) value);
		} 
		else {
			this.systemInfoHash.get(infoType).put((String) key, (double) value);
			this.systemInfoHash.get("priceReference").put((String) key, (double) value); // also update master list
		}
		System.out.println("Setting added");
	}
	
	public void updateSetting(String infoType, Object key, Object value) {
		if (infoType.equals("holidayReference")) {
			this.systemInfoHash.get(infoType).replace((LocalDate) key, (String) value);
		} 
		else {
			this.systemInfoHash.get(infoType).replace((String) key, (double) value);
			this.systemInfoHash.get("priceReference").replace((String) key, (double) value); // also update master list
		}
		
		System.out.println("Setting updated");		
	}
	
	public void deleteSetting(String infoType, Object key) {
		if (infoType.equals("holidayReference")) {
			this.systemInfoHash.get(infoType).remove((LocalDate) key);
		} 
		else {
			this.systemInfoHash.get(infoType).remove((String) key);
			this.systemInfoHash.get("priceReference").remove((String) key); // also update master list
		}
		System.out.println("Setting removed");		
	}	
	
	// Initializers
	private void setsystemInfoList() {
		this.systemInfoList = new ArrayList<String>(List.of("priceReference", "holidayReference", "dayOfWeek$", "default$", "holiday$", "movieFormat$", "ticketType$", "cinemaType$"));	
	}
	
	private void setSystemInfoHash() {
		this.systemInfoHash = new HashMap<String, Map<Object, Object>>();
		for (String attributeName : this.getsystemInfoList()) {
			this.setSystemInfoItem(attributeName);
		}
 		
	}
	
	private void setSystemInfoItem(String attributeName) {
		try {
			// Get filepath
			//how to get filepath
			String filePath = ProjectRootPathFinder.findProjectRootPath();
			
			
			if (filePath == null) {
				throw new IOException("Cannot find root");
			} 
			
			this.systemInfoHash.put(attributeName, new HashMap<Object, Object>());
			
			switch (attributeName) {
				case "priceReference": 
					filePath = filePath + "/data/system_settings/price_reference.txt";
					break;
				case "holidayReference":
					filePath = filePath + "/data/system_settings/holiday_list.txt";
					break;
				case "dayOfWeek$":
					filePath = filePath + "/data/system_settings/day_of_week.txt";
					break;
				case "default$":
					filePath = filePath + "/data/system_settings/default_price.txt";
					break;
				case "holiday$":
					filePath = filePath + "/data/system_settings/holiday.txt";
					break;
				case "movieFormat$":
					filePath = filePath + "/data/system_settings/movie_format.txt";
					break;				
				case "ticketType$":
					filePath = filePath + "/data/system_settings/ticket_type.txt";
					break;			
				case "cinemaType$":
					filePath = filePath + "/data/system_settings/cinema_type.txt";
					break;							
			}
			
			
			// Open file and traverse it
			FileReader frStream = new FileReader( filePath );
			BufferedReader brStream = new BufferedReader( frStream );
			String inputLine;
			
			do {
				inputLine = brStream.readLine(); // read in a line
				if (inputLine == null) {break;} // end of file
				String inputLineSeparated[] = inputLine.split("\\|"); // escape the | character
	
				switch (attributeName) {
					case "holidayReference":
						LocalDate date = LocalDate.parse(inputLineSeparated[0].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
						String holidayName = inputLineSeparated[1].trim();
						this.systemInfoHash.get(attributeName).put(date, holidayName);
						break;
					default:
						String key = inputLineSeparated[0].trim();
						Double value = Double.parseDouble(inputLineSeparated[1].trim());
						this.systemInfoHash.get(attributeName).put(key, value);						
						break;
				}
				
			} while (inputLine != null);
			
			brStream.close();	
			
		} catch ( FileNotFoundException e ) {
			System.out.println( "Error opening the input file!" + e.getMessage() );
			System.exit( 0 );
		} catch ( IOException e ) {
			System.out.println( "IO Error!" + e.getMessage() );
			e.printStackTrace();
			System.exit( 0 );
		}	
	}
}