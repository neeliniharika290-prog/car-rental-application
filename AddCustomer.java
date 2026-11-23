
package com.example.car_rental;

import java.util.ArrayList;
import java.util.Scanner;

public class AddCustomer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Customer> customers = new ArrayList<>();

        System.out.println("===== ADD CUSTOMER =====");

        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        Customer c = new Customer(id, name, phone, email);

        customers.add(c);

        System.out.println("\nCustomer Added Successfully!");

        System.out.println("\n===== CUSTOMER DETAILS =====");

        c.displayCustomer();

        sc.close();
    }
}

