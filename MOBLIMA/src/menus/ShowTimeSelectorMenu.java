package menus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import managers.HolidayManager;

public class ShowTimeSelectorMenu implements ISelectorMenu<LocalDateTime> {

    public static ShowTimeSelectorMenu single_instance = null;

    private ShowTimeSelectorMenu() {}

    public static ShowTimeSelectorMenu getInstance() {
        if(single_instance == null) {
            single_instance = new ShowTimeSelectorMenu();
        }
        return single_instance;
    }

    /**
     * Select showtime
     */
    public LocalDateTime startSelector(ArrayList<LocalDateTime> showtimes, String heading) {
        Scanner sc = new Scanner(System.in);
        System.out.println(	"================ " +heading+ " =================");
        for(int i = 0; i < showtimes.size(); i++) {
			LocalDateTime currentShowTime = showtimes.get(i);
            String isHoliday = HolidayManager.isHoliday(LocalDate.from(currentShowTime)) ? " | PUBLIC HOLIDAY (EXTRA CHARGES)" : "";
			System.out.println(
				"("+(i+1)+") "+
				currentShowTime.getDayOfWeek() +
                isHoliday + "\n"+
				currentShowTime.getDayOfMonth()+" "+
				currentShowTime.getMonth()+"\n"+
				"Showtime: " + DateTimeFormatter.ofPattern("HH:mm").format(currentShowTime)
			);
			System.out.println("----------------------------------");
		}

        
		int selectedShowTime;
		do {	
            System.out.println("Select a Timeslot");
            
            while (!sc.hasNextInt()) {
                System.out.printf("Invalid input type.");
                sc.next(); 
            }
            selectedShowTime = sc.nextInt()-1;
            if(selectedShowTime < 0 || selectedShowTime >= showtimes.size()){
                System.out.println("Please input a valid integer.");
            }

		} while(selectedShowTime < 0 || selectedShowTime >= showtimes.size());

        return showtimes.get(selectedShowTime);
    } 
    
    
}
