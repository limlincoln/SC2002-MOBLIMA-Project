package menus;
import java.util.Scanner;

public class SettingsPriceFormMenu {
    /**
     * Price form
     * @return  newPrice
     */
    public static double startFullForm(){
        Scanner sc = new Scanner(System.in);
        double newPrice;
        System.out.println("Enter the new price: ");
        newPrice = sc.nextDouble();
        return newPrice;
    }
}
