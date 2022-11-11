package menus;
import managers.BookingManager;
import managers.ReviewManager;
import entities.Booking;

import java.util.ArrayList;
import java.util.Scanner;

public class BookingHistoryMenu {
    private static BookingHistoryMenu single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

    private BookingHistoryMenu(){}


    public static BookingHistoryMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new BookingHistoryMenu();
        return single_instance;
    }


    public void displayBookingHistoryMenu() { 
        Booking selectedBooking = null;
        do {
            String username = CustomerFormMenu.startUserNameForm();
            ArrayList<Booking> bookingHistory = BookingManager.getBookingHistoryByUsername(username);
            selectedBooking = BookingSelectorMenu.getInstance().startSelector(bookingHistory, "BOOKING HISTORY");
            if(selectedBooking != null) {
                int rating = -1;
                do {
                    System.out.println("Enter Rating (0-5):"); 
                    rating = sc.nextInt();
                } while(rating < 0 || rating > 5); 
                ReviewManager.reviewBooking(selectedBooking, rating);   
            }
        } while(selectedBooking != null);

    }
}
