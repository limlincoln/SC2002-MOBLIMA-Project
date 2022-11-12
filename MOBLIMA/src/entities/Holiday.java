package entities;

import java.time.LocalDate;

import enums.DayOfWeek;
import utils.IDGenerator;

public class Holiday {
    /**
     * The unique ID for this Holiday
     */
    private Integer ID;
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
    public Holiday(Integer ID, String name, LocalDate date, DayOfWeek dayOfWeek) {
        this.ID = IDGenerator.get();
        this.name = name;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
    }


    public Integer getID() {
        return this.ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public DayOfWeek getDayOfWeek() {
        return this.dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

}
