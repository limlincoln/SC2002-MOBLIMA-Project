package initializer;

public class TicketInitializer {
    
    switch(arr[0]) {
        case "SUN":
            dayofweek = DayOfWeek.SUN;
            break;
            
        case "MON":
            dayofweek = DayOfWeek.MON;
            break;
            
        case "TUE":
            dayofweek = DayOfWeek.TUE;
            break;
            
        case "WED":
            dayofweek = DayOfWeek.WED;
            break;
            
        case "THU":
            dayofweek = DayOfWeek.THU;
            break;
            
        case "FRI":
            dayofweek = DayOfWeek.FRI;
            break;
            
        case "SAT":
            dayofweek = DayOfWeek.SAT;
            break;	
        }
        
        switch(arr[1]) {
        case "BEFORE_6":
            timeofday = TimeOfDay.BEFORE_6;
            break;
            
        case "AFTER_6":
            timeofday = TimeOfDay.AFTER_6;
            break;	
        }
        
        switch(arr[2]) {
        case "ADULT":
            agegroup = AgeGroup.ADULT;
            break;
            
        case "SENIOR":
            agegroup = AgeGroup.SENIOR;
            break;
        
        case "STUDENT":
            agegroup = AgeGroup.STUDENT;
            break;
        }
        switch(arr[3]) {
            case "WEEKEND":
                typeOfDay = TypeOfDay.WEEKEND;
                break;
                
            case "WEEKDAY":
                typeOfDay = TypeOfDay.WEEKDAY;
                break;	
            case "PUBLIC_HOLIDAY":
                typeOfDay = TypeOfDay.PUBLIC_HOLIDAY;
                break;
        }
        switch(arr[4]) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddhhmm");
            exactDateTime = LocalDateTime.parse(arr[4], formatter);
        }
        switch(arr[5]) {
            seat = arr[5];
        }
    
}
