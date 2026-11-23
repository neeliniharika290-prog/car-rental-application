

package com.example.car_rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== SEARCH BOOKING =====");
        System.out.print("Enter Booking ID: ");

        int id = sc.nextInt();

        String sql = "SELECT * FROM bookings WHERE booking_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Booking Found!");
                System.out.println("Booking ID: " + rs.getInt("booking_id"));
                System.out.println("Customer ID: " + rs.getInt("customer_id"));
                System.out.println("Car ID: " + rs.getInt("car_id"));
                System.out.println("Rental Days: " + rs.getInt("rental_days"));
                System.out.println("Total Amount: Rs. " + rs.getDouble("total_amount"));
                System.out.println("Booking Date: " + rs.getDate("booking_date"));
                System.out.println("Status: " + rs.getString("status"));

            } else {
                System.out.println("Booking ID Not Found!");
            }

            rs.close();

        } catch (Exception e) {
            System.out.println("Booking Search Failed!");
            e.printStackTrace();
        }

        sc.close();
    }
}
