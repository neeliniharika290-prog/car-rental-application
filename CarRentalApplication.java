
package com.example.car_rental;

import java.util.Scanner;

public class CarRentalApplication {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("===== CAR RENTAL MANAGEMENT SYSTEM =====");

		System.out.println("1. Customer Registration");
		System.out.println("2. Exit");

		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		sc.nextLine();

		switch (choice) {

			case 1:
				System.out.println("\n--- CUSTOMER REGISTRATION ---");

				System.out.print("Enter Customer ID: ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Customer Name: ");
				String name = sc.nextLine();

				System.out.print("Enter Phone Number: ");
				String phone = sc.nextLine();

				System.out.print("Enter Age: ");
				int age = sc.nextInt();

				System.out.println("\n--- CUSTOMER DETAILS ---");
				System.out.println("Customer ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("Phone: " + phone);
				System.out.println("Age: " + age);
				System.out.println("Registration Successful!");

				break;

			case 2:
				System.out.println("Thank you!");
				break;

			default:
				System.out.println("Invalid choice!");
		}

		sc.close();
	}
}
