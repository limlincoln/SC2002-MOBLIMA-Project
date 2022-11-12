package menus;
import enums.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class SettingsHolidayFormMenu {

    public static String startNameForm(){
        String holname;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Holiday Name: ");
        holname = sc.nextLine();
        return holname;
    }

    public static LocalDate startDateForm(){
        LocalDate date;
        String dates;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Date in the format(yyyyMMdd): ");
        dates = sc.nextLine();
        date = LocalDate.parse(dates);
        return date;
    }

    public static DayOfWeek startDayForm(){
        DayOfWeek dow;
        String dows;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Day of week(etc. MON, TUES... SUN): ");
        dows = sc.nextLine();
        dow = Enum.valueOf(DayOfWeek.class, dows);
        return dow;
    }
}
