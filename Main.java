
package com.example.car_rental;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== CAR RENTAL SYSTEM =====");
            System.out.println("===== CUSTOMER MANAGEMENT =====");

            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Update Customer");
            System.out.println("5. Delete Customer");
            System.out.println("6. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    AddCustomerDB.main(new String[0]);
                    break;

                case 2:
                    ViewCustomersDB.main(new String[0]);
                    break;

                case 3:
                    SearchCustomerDB.main(new String[0]);
                    break;

                case 4:
                    UpdateCustomerDB.main(new String[0]);
                    break;

                case 5:
                    DeleteCustomerDB.main(new String[0]);
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
