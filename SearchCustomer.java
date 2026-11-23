
package com.example.car_rental;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchCustomer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Customer> customers = new ArrayList<>();

        customers.add(new Customer(101, "Niharika",
                "9876543210", "niharika@gmail.com"));

        customers.add(new Customer(102, "Priya",
                "9876501234", "priya@gmail.com"));

        customers.add(new Customer(103, "Rahul",
                "9876512345", "rahul@gmail.com"));

        System.out.println("===== SEARCH CUSTOMER =====");

        System.out.print("Enter Customer ID: ");
        int searchId = sc.nextInt();

        boolean found = false;

        for (Customer c : customers) {

            if (c.customerId == searchId) {

                System.out.println("\nCustomer Found!");
                c.displayCustomer();

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Customer Not Found!");
        }

        sc.close();
    }
}
