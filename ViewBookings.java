

package com.example.car_rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewBookings {

    public static void main(String[] args) {

        String sql = "SELECT * FROM bookings";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("===== ALL BOOKINGS =====");

            while (rs.next()) {

                System.out.println("Booking ID: " + rs.getInt("booking_id"));
                System.out.println("Customer ID: " + rs.getInt("customer_id"));
                System.out.println("Car ID: " + rs.getInt("car_id"));
                System.out.println("Rental Days: " + rs.getInt("rental_days"));
                System.out.println("Total Amount: Rs. " + rs.getDouble("total_amount"));
                System.out.println("Booking Date: " + rs.getDate("booking_date"));
                System.out.println("Status: " + rs.getString("status"));

                System.out.println("--------------------------");
            }

        } catch (Exception e) {
            System.out.println("Unable to Display Bookings!");
            e.printStackTrace();
        }
    }
}

