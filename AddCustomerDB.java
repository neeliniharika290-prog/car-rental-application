
package com.example.car_rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddCustomerDB {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== ADD CUSTOMER =====");

        // Customer ID validation
        System.out.print("Enter Customer ID: ");

        if (!sc.hasNextInt()) {
            System.out.println("Invalid Customer ID! Enter numbers only.");
            return;
        }

        int id = sc.nextInt();
        sc.nextLine();

        if (id <= 0) {
            System.out.println("Customer ID must be greater than zero!");
            return;
        }

        // Customer name validation
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Customer name cannot be empty!");
            return;
        }

        // Phone validation
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine().trim();

        if (!phone.matches("[0-9]{10}")) {
            System.out.println("Phone number must contain exactly 10 digits!");
            return;
        }

        // Email validation
        System.out.print("Enter Email: ");
        String email = sc.nextLine().trim();

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            System.out.println("Invalid email format!");
            return;
        }

        String sql = "INSERT INTO customers " +
                "(customer_id, customer_name, phone, email) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, email);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Customer Added Successfully!");
            }

        } catch (SQLException e) {

            if ("23505".equals(e.getSQLState())) {
                System.out.println("Customer ID already exists!");
            } else {
                System.out.println("Customer Addition Failed!");
                System.out.println("Reason: " + e.getMessage());
            }
        }
    }
}
