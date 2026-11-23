
package com.example.car_rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewCustomersDB {

    public static void main(String[] args) {

        String sql = "SELECT * FROM customers ORDER BY customer_id";

        System.out.println("===== VIEW CUSTOMERS =====");

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.println("Customer ID: "
                        + rs.getInt("customer_id"));

                System.out.println("Customer Name: "
                        + rs.getString("customer_name"));

                System.out.println("Phone: "
                        + rs.getString("phone"));

                System.out.println("Email: "
                        + rs.getString("email"));

                System.out.println("--------------------------");
            }

            if (!found) {
                System.out.println("No Customers Found!");
            }

        } catch (Exception e) {
            System.out.println("View Customers Failed!");
            e.printStackTrace();
        }
    }
}
