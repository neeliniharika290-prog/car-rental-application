
package com.example.car_rental;

import java.sql.*;
import java.util.Scanner;

public class CancelBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== CANCEL BOOKING =====");

        System.out.print("Enter Booking ID: ");
        int bookingId = sc.nextInt();

        String findSql =
                "SELECT car_id FROM bookings " +
                        "WHERE booking_id = ? AND status = 'Booked' FOR UPDATE";

        String cancelSql =
                "UPDATE bookings SET status = 'Cancelled' " +
                        "WHERE booking_id = ? AND status = 'Booked'";

        String carSql =
                "UPDATE cars SET availability = 'Available' " +
                        "WHERE car_id = ?";

        try (Connection con = DBConnection.getConnection()) {

            con.setAutoCommit(false);

            try {
                int carId;

                try (PreparedStatement ps =
                             con.prepareStatement(findSql)) {

                    ps.setInt(1, bookingId);

                    ResultSet rs = ps.executeQuery();

                    if (!rs.next()) {
                        System.out.println(
                                "Booking not found or already cancelled!"
                        );
                        con.rollback();
                        return;
                    }

                    carId = rs.getInt("car_id");
                }

                try (PreparedStatement ps =
                             con.prepareStatement(cancelSql)) {

                    ps.setInt(1, bookingId);
                    ps.executeUpdate();
                }

                try (PreparedStatement ps =
                             con.prepareStatement(carSql)) {

                    ps.setInt(1, carId);
                    ps.executeUpdate();
                }

                con.commit();

                System.out.println("Booking Cancelled Successfully!");
                System.out.println("Car is now Available!");

            } catch (Exception e) {
                con.rollback();
                throw e;
            }

        } catch (Exception e) {
            System.out.println("Cancellation Failed!");
            e.printStackTrace();
        }

        sc.close();
    }
}
