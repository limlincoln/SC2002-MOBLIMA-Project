package entities;

import java.time.LocalDate;

import enums.DayOfWeek;
import utils.IDGenerator;

// TODO: Auto-generated Javadoc
/**
 * The Class Holiday.
 */
public class Holiday {
    
    /** The unique ID for this Holiday. */
    private Integer ID;
    
    /** the name given for this Holiday. */
    private String name;

    /** the date when this Holiday occurs. */
    private LocalDate date;

    /** the day of the Week this holiday is in. */
    private DayOfWeek dayOfWeek;

    /**
	 * The Constructor for the Holiday Class.
	 *
	 * @param ID        the id
	 * @param name      the name given for this Holiday
	 * @param date      the date when this Holiday occurs
	 * @param dayOfWeek the day of the Week this holiday is in
	 */
    public Holiday(Integer ID, String name, LocalDate date, DayOfWeek dayOfWeek) {
        this.ID = IDGenerator.get();
        this.name = name;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
    }


    /**
	 * Gets the id.
	 *
	 * @return the id
	 */
    public Integer getID() {
        return this.ID;
    }

    /**
	 * Sets the id.
	 *
	 * @param ID the new id
	 */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
	 * Gets the name.
	 *
	 * @return the name
	 */
    public String getName() {
        return this.name;
    }

    /**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
    public void setName(String name) {
        this.name = name;
    }

    /**
	 * Gets the date.
	 *
	 * @return the date
	 */
    public LocalDate getDate() {
        return this.date;
    }

    /**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
	 * Gets the day of week.
	 *
	 * @return the day of week
	 */
    public DayOfWeek getDayOfWeek() {
        return this.dayOfWeek;
    }

    /**
	 * Sets the day of week.
	 *
	 * @param dayOfWeek the new day of week
	 */
    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

}
