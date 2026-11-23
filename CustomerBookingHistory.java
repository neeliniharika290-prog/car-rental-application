
package com.example.car_rental;

import java.sql.*;
import java.util.Scanner;

public class CustomerBookingHistory {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== CUSTOMER BOOKING HISTORY =====");

        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();

        String sql =
                "SELECT b.booking_id, b.car_id, " +
                        "c.car_name, c.brand, " +
                        "b.rental_days, b.total_amount, b.status " +
                        "FROM bookings b " +
                        "JOIN cars c ON b.car_id = c.car_id " +
                        "WHERE b.customer_id = ? " +
                        "ORDER BY b.booking_id";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, customerId);

            try (ResultSet rs = ps.executeQuery()) {

                boolean found = false;

                while (rs.next()) {

                    found = true;

                    System.out.println("--------------------------");

                    System.out.println("Booking ID: " +
                            rs.getInt("booking_id"));

                    System.out.println("Car ID: " +
                            rs.getInt("car_id"));

                    System.out.println("Car Name: " +
                            rs.getString("car_name"));

                    System.out.println("Brand: " +
                            rs.getString("brand"));

                    System.out.println("Rental Days: " +
                            rs.getInt("rental_days"));

                    System.out.println("Total Amount: Rs. " +
                            rs.getDouble("total_amount"));

                    System.out.println("Status: " +
                            rs.getString("status"));
                }

                if (!found) {
                    System.out.println(
                            "No booking history found for this customer!");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
