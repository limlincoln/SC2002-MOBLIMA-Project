package menus;
import java.time.LocalDate;
import java.util.Scanner;

import enums.DayOfWeek;

public class SettingsHolidayFormMenu {
    /**
     * Holiday name form
     * @return holiday's name
     */
    public static String startNameForm(){
        String holname;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Holiday Name: ");
        holname = sc.nextLine();
        return holname;
    }
    /**
     * Date form
     * @return date
     */
    public static LocalDate startDateForm(){
        LocalDate date;
        String dates;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Date in the format(yyyyMMdd): ");
        dates = sc.nextLine();
        date = LocalDate.parse(dates);
        return date;
    }
    /**
     * Day of Week form
     *  @return DayOfWeek
     */
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
