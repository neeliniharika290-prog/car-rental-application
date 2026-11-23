
package com.example.car_rental;

import java.util.ArrayList;

public class CustomerTest {

    public static void main(String[] args) {

        ArrayList<Customer> customers = new ArrayList<>();

        Customer c1 = new Customer(
                101, "Niharika",
                "9876543210", "niharika@gmail.com"
        );

        Customer c2 = new Customer(
                102, "Priya",
                "9876501234", "priya@gmail.com"
        );

        Customer c3 = new Customer(
                103, "Rahul",
                "9876512345", "rahul@gmail.com"
        );

        customers.add(c1);
        customers.add(c2);
        customers.add(c3);

        System.out.println("===== ALL CUSTOMERS =====");

        for (Customer c : customers) {
            c.displayCustomer();
            System.out.println("-------------------");
        }
    }
}
