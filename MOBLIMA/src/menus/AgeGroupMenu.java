package menus;

import java.util.Scanner;
import enums.AgeGroup;;
/**
 * Menu to display Age group
 */
public class AgeGroupMenu {
    /** 
     * Single instance of AgeGroupMenu 
     */
  private static AgeGroupMenu single_instance = null;
  private AgeGroupMenu(){}

  /**
   * Get or creates the single instance of AgeGroupMenu class
   * @return AgeGroupMenu Class
   */
  public static AgeGroupMenu getInstance()
  {
    if (single_instance == null)
        single_instance = new AgeGroupMenu();
    return single_instance;
  }

  /**
   * Allow users to display different age groups
   * @return
   */
  public AgeGroup display() { 
    Scanner sc = new Scanner(System.in);
    int choice;	
  do {
    System.out.println(	"=========== SELECT AGE GROUP =========\n" +
                        " 1. ADULT  					   \n" +
                        " 2. SENIOR              \n" +
                        " 3. STUDENT              \n" +
                        "======================================");

    System.out.println("Enter choice: ");
    
    while (!sc.hasNextInt()) {
      System.out.println("Invalid input type. Please enter an integer value.");
    sc.next(); 
    }
    
    choice = sc.nextInt();
    
    switch(choice){
        case 1:
          return AgeGroup.ADULT;
        case 2:
          return AgeGroup.SENIOR;   
        case 3:
          return AgeGroup.STUDENT;
        default: 
          System.out.printf("Invalid input type.");
          break;
      }
  } while (true);
  }
}
