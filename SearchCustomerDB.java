
package com.example.car_rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchCustomerDB {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== SEARCH CUSTOMER =====");

        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();

        String sql = "SELECT * FROM customers WHERE customer_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Customer Found!");
                System.out.println("Customer ID: " +
                        rs.getInt("customer_id"));
                System.out.println("Customer Name: " +
                        rs.getString("customer_name"));
                System.out.println("Phone: " +
                        rs.getString("phone"));
                System.out.println("Email: " +
                        rs.getString("email"));

            } else {
                System.out.println("Customer Not Found!");
            }

        } catch (Exception e) {
            System.out.println("Search Failed!");
            e.printStackTrace();
        }

        sc.close();
    }
}

