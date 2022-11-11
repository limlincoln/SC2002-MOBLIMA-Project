package menus;
import entities.Holiday;
import enums.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.util.Date;

public class SettingsHolidayFormMenu {

    // TODO: Holiday ID
    /*
    public static Holiday startFullForm(){
        String name;
        LocalDate date;
        DayOfWeek dayOfWeek;
        
        //return detail u want to change
        return holiday;
    }*/
    

    public static String startNameForm(){
        String holname;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Holiday Name: ");
        holname = sc.nextLine();
        sc.close();
        return holname;
    }

    public static LocalDate startDateForm(){
        LocalDate date;
        String dates;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Date in the format(yyyyMMdd): ");
        dates = sc.nextLine();
        date = LocalDate.parse(dates);
        sc.close();
        return date;
    }

    public static DayOfWeek startDayForm(){
        DayOfWeek dow;
        String dows;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Day of week(etc. MON, TUES... SUN): ");
        dows = sc.nextLine();
        dow = Enum.valueOf(DayOfWeek.class, dows);
        sc.close();
        return dow;
    }
}
