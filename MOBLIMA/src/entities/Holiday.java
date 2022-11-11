package entities;

import java.time.LocalDate;

import enums.DayOfWeek;

public class Holiday {
    /**
     * the name given for this Holiday
     */
    private String name;

    /**
     * the date when this Holiday occurs
     */
    private LocalDate date;

    /**
     * the day of the Week this holiday is in
     */
    private DayOfWeek dayOfWeek;

    /**
     * The Constructor for the Holiday Class
     * @param name the name given for this Holiday 
     * @param date the date when this Holiday occurs
     * @param dayOfWeek the day of the Week this holiday is in
     */
    public Holiday(String name, LocalDate date, DayOfWeek dayOfWeek) {
        this.name = name;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
