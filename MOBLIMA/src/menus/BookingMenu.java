package menu;
import entities.Movie;
import entities.Booking;
import entities.Cinema;
import entities.Customer;
import java.util.Scanner;

public class BookingMenu {
    private static BookingMenu single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

    private BookingMenu(){}


    public static BookingMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new BookingMenu();
        return single_instance;
    }
    public void showSeats(Movie movie,Cinema cine, double calculated) {
    	if(movie.getCinemaType() != cine.getCinemaType());
    	{
    		System.out.println("This movie does not support the cinema type");
    	}
    	
    	
    	System.out.println(	"============== Print Seats ================\n" );
        int arr[][] =  { { 0, 0, 0 },
			            { 0, 0, 0 },   
			            { 0, 0, 0 }};
        
        for (int i = 0; i < arr.length; i++) 
        {            
            for (int j = 0; j < arr[i].length; j++)
            {
              System.out.print(arr[i][j] + " ");
            }    
         System.out.println();       
        
        }        
    
    }
  
    public void displayBookingMenu() {
    	int choice;	
		do {
            System.out.println(	"=========== MOBLIMA CUSTOMER BOOKING MENU =========\n" +
			                    " 1. Show booking history     					   \n" +
			                    " 0. Back to MOBLIMA APP                           \n"+
							    "====================================================");
	    	
            System.out.println("Enter choice: ");
            
            while (!sc.hasNextInt()) {
            	System.out.println("Invalid input type. Please enter an integer value.");
        		sc.next(); 
            }
            
            choice = sc.nextInt();
            
            switch(choice){
                case 1:
                	//showbookinghistory();
                    break;
                case 0:
                	System.out.println("Back to MOBLIMA APP......");
                	break;
                default: 
                	System.out.printf("Invalid input type.");
                	break;
	            }
	        } while (choice != 0);
    }
}
