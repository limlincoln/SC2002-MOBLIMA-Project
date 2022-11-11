package unit_tests;

import java.util.ArrayList;

import entities.Customer;

public class stringTest {
    public static void main(String[] args) {
        Customer newCustomer = new Customer(122, "dfdw", "daa", "1233");
        ArrayList<Customer> ne = new ArrayList<Customer>();
        ne.add(newCustomer);

        System.out.println(""+ne);
    }
    
}
