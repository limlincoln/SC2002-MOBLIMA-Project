package menus;

import java.util.Scanner;
import enums.AgeGroup;;

public class AgeGroupMenu {
  private static AgeGroupMenu single_instance = null;
  private AgeGroupMenu(){}


  public static AgeGroupMenu getInstance()
  {
    if (single_instance == null)
        single_instance = new AgeGroupMenu();
    return single_instance;
  }


  public AgeGroup display() { 
    Scanner sc = new Scanner(System.in);
    int choice;	
  do {
    System.out.println(	"=========== SELECT AGE GROUP =========\n" +
                        " 1. AdDULT  					   \n" +
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
          sc.close();
          return AgeGroup.ADULT;
        case 2:
          sc.close();
          return AgeGroup.SENIOR;   
        case 3:
          sc.close();
          return AgeGroup.STUDENT;
        default: 
          System.out.printf("Invalid input type.");
          break;
      }
  } while (true);
  }
}
