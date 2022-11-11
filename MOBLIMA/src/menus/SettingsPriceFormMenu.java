package menus;
import java.util.Scanner;

public class SettingsPriceFormMenu {
    public static double startFullForm(){
        Scanner sc = new Scanner(System.in);
        double newPrice;
        System.out.println("Enter the new price: ");
        newPrice = sc.nextDouble();
        sc.close();
        return newPrice;
    }
}
