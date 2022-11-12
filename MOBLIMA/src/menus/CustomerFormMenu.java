package menus;

import java.util.Random;
import java.util.Scanner;

import entities.Customer;
import managers.DateManager;
import utils.IDGenerator;

public class CustomerFormMenu {

    /**
     * Customer details form
     * @return
     */
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
        Customer newCustomer = new Customer(IDGenerator.get(), userName, email, phoneNumber);

        return newCustomer;
    }

    /**
     * Customer username form
     * @return
     */
    public static String startUserNameForm() {
        String userName;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Username: ");
        userName = sc.nextLine();

        return userName;
    }
    
}
