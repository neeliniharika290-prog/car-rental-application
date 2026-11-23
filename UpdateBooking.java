
package com.example.car_rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== UPDATE BOOKING =====");

        System.out.print("Enter Booking ID: ");
        int id = sc.nextInt();

        System.out.print("Enter New Rental Days: ");
        int days = sc.nextInt();

        if (days <= 0) {
            System.out.println("Rental days must be greater than zero!");
            sc.close();
            return;
        }

        String sql = "UPDATE bookings SET rental_days = ?, total_amount = ? WHERE booking_id = ? AND status <> 'Cancelled'";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            double rentPerDay = 1500.0;
            double totalAmount = rentPerDay * days;

            ps.setInt(1, days);
            ps.setDouble(2, totalAmount);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Booking Updated Successfully!");
                System.out.println("New Rental Days: " + days);
                System.out.println("New Total Amount: Rs. " + totalAmount);
            } else {
                System.out.println("Booking Not Found or Already Cancelled!");
            }

        } catch (Exception e) {
            System.out.println("Booking Update Failed!");
            e.printStackTrace();
        }

        sc.close();
    }
}
