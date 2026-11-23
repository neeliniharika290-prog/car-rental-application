
package com.example.car_rental;

import java.sql.*;
import java.util.Scanner;

public class CustomerSpending {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== CUSTOMER TOTAL SPENDING =====");

        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();

        String sql =
                "SELECT COUNT(*) AS total_bookings, " +
                        "COALESCE(SUM(total_amount), 0) AS total_spending " +
                        "FROM bookings " +
                        "WHERE customer_id = ? AND status = 'Booked'";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, customerId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    int totalBookings =
                            rs.getInt("total_bookings");

                    double totalSpending =
                            rs.getDouble("total_spending");

                    System.out.println("--------------------------");
                    System.out.println("Customer ID: " + customerId);
                    System.out.println("Active Bookings: " +
                            totalBookings);
                    System.out.println("Total Spending: Rs. " +
                            totalSpending);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
