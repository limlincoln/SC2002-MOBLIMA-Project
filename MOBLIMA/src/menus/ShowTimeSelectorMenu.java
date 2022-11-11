package menus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

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
			System.out.println(
				"("+(i+1)+")"+
				currentShowTime.getDayOfWeek()+"\n"+
				currentShowTime.getDayOfMonth()+", "+
				currentShowTime.getMonth()+"\n"+
				currentShowTime.getHour()+":"+currentShowTime.getMinute()
			);
			System.out.println("----------------------------------");
		}

		int selectedShowTime;
		do {	
			selectedShowTime = sc.nextInt()-1;
		} while(selectedShowTime < 0 || selectedShowTime >= showtimes.size());

        return showtimes.get(selectedShowTime);
    } 
    
    
}
