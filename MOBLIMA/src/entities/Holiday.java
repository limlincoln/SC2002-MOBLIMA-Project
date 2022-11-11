package entities;

import java.time.LocalDate;

import enums.DayOfWeek;

public class Holiday {
    private String name;
    private LocalDate date;
    private DayOfWeek dayOfWeek;

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
