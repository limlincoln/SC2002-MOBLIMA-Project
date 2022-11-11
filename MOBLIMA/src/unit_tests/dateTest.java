package unit_tests;

import managers.DateManager;

import java.time.LocalDateTime;

import enums.DayOfWeek;

public class dateTest {
    public static void main(String args[]) {
        LocalDateTime datTime = DateManager.getInstance().getExactShowTime(DayOfWeek.MON, 5);

        System.out.println("Today: "+DateManager.getCurrentDateTimeFormatted("MMdd"));
        System.out.println("Show Date: "+datTime.getMonth()+datTime.getDayOfMonth());
        System.out.println("Show time: "+datTime.getHour()+""+datTime.getMinute());
    } 
}
