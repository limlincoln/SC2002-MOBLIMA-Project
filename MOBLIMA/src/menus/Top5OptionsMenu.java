package menus;

import java.util.Scanner;

/**
 * Menu to display menu 
 */
public class Top5OptionsMenu implements ITop5Menu {
    public static Top5OptionsMenu single_instance = null;

    private Top5OptionsMenu() {}

    public static Top5OptionsMenu getInstance() {
        if(single_instance == null) {
            single_instance = new Top5OptionsMenu();
        }
        return single_instance;
    }

    @Override
    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("(1) By Sales");
        System.out.println("(2) By Rating");
        System.out.println("(0) By Rating");

        int ratingChoice;
        do {
            ratingChoice = sc.nextInt();
        } while(ratingChoice < 0 || ratingChoice > 2);

        switch(ratingChoice){
            case 1:
                Top5BySalesMenu.getInstance().displayMenu();
                break;
            case 2:
                Top5ByRatingMenu.getInstance().displayMenu();
            default:
                return;
        }
    }
    
}
