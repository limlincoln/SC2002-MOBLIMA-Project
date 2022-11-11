package menus;

import java.util.Random;
import java.util.Scanner;

import entities.Customer;
import managers.DateManager;

public class CustomerFormMenu {
    public static Customer startFullForm() {
        String userName;
        String phoneNumber;
        String email;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Username: ");
        userName = sc.nextLine();

        System.out.println("Enter Phone Number: ");
        phoneNumber = sc.nextLine();

        System.out.println("Email Address: ");
        email = sc.nextLine();

        Random rand = new Random();
        Customer newCustomer = new Customer(DateManager.getCurrentDateTimeFormatted("hhmmss")+rand.nextInt(1000), userName, email, phoneNumber);

        return newCustomer;
    }

    public static String startUserNameForm() {
        String userName;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Username: ");
        userName = sc.nextLine();

        return userName;
    }
    
}
