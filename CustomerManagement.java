
package com.example.car_rental;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManagement {

    static ArrayList<Customer> customers = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== CUSTOMER MANAGEMENT =====");
            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Exit");

            System.out.print("Enter Your Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addCustomer();
                    break;

                case 2:
                    viewCustomers();
                    break;

                case 3:
                    searchCustomer();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }

    // Add Customer
    public static void addCustomer() {

        System.out.print("Enter Customer ID: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Customer c : customers) {
            if (c.customerId == id) {
                System.out.println("Customer ID Already Exists!");
                return;
            }
        }

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        Customer c = new Customer(id, name, phone, email);

        customers.add(c);

        System.out.println("Customer Added Successfully!");
    }

    // View All Customers
    public static void viewCustomers() {

        if (customers.isEmpty()) {
            System.out.println("No Customers Available!");
            return;
        }

        System.out.println("\n===== ALL CUSTOMERS =====");

        for (Customer c : customers) {
            c.displayCustomer();
            System.out.println("-------------------");
        }
    }

    // Search Customer
    public static void searchCustomer() {

        System.out.print("Enter Customer ID: ");
        int id = Integer.parseInt(sc.nextLine());

        boolean found = false;

        for (Customer c : customers) {

            if (c.customerId == id) {

                System.out.println("Customer Found!");
                c.displayCustomer();

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Customer Not Found!");
        }
    }
}
