
package com.example.car_rental;

import java.sql.*;
import java.util.Scanner;

public class Booking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== CAR BOOKING =====");

        System.out.print("Enter Booking ID: ");
        int bookingId = sc.nextInt();

        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();

        System.out.print("Enter Car ID: ");
        int carId = sc.nextInt();

        System.out.print("Enter Rental Days: ");
        int days = sc.nextInt();

        if (bookingId <= 0 || customerId <= 0 || carId <= 0) {
            System.out.println("IDs must be greater than zero!");
            return;
        }

        if (days <= 0) {
            System.out.println("Rental days must be greater than zero!");
            return;
        }

        String customerSql =
                "SELECT customer_id FROM customers WHERE customer_id = ?";

        String carSql =
                "SELECT rent_per_day FROM cars " +
                        "WHERE car_id = ? AND availability = 'Available' FOR UPDATE";

        String bookingSql =
                "INSERT INTO bookings " +
                        "(booking_id, customer_id, car_id, rental_days, total_amount) " +
                        "VALUES (?, ?, ?, ?, ?)";

        String updateCarSql =
                "UPDATE cars SET availability = 'Rented' " +
                        "WHERE car_id = ? AND availability = 'Available'";

        try (Connection con = DBConnection.getConnection()) {

            con.setAutoCommit(false);

            try {

                // Check customer
                try (PreparedStatement ps =
                             con.prepareStatement(customerSql)) {

                    ps.setInt(1, customerId);

                    try (ResultSet rs = ps.executeQuery()) {

                        if (!rs.next()) {
                            System.out.println("Customer ID not found!");
                            con.rollback();
                            return;
                        }
                    }
                }

                // Check car availability
                double rent;

                try (PreparedStatement ps =
                             con.prepareStatement(carSql)) {

                    ps.setInt(1, carId);

                    try (ResultSet rs = ps.executeQuery()) {

                        if (!rs.next()) {
                            System.out.println(
                                    "Car not found or already rented!");
                            con.rollback();
                            return;
                        }

                        rent = rs.getDouble("rent_per_day");
                    }
                }

                // Calculate total amount
                double total = rent * days;

                // Insert booking
                try (PreparedStatement ps =
                             con.prepareStatement(bookingSql)) {

                    ps.setInt(1, bookingId);
                    ps.setInt(2, customerId);
                    ps.setInt(3, carId);
                    ps.setInt(4, days);
                    ps.setDouble(5, total);

                    ps.executeUpdate();
                }

                // Update car status
                try (PreparedStatement ps =
                             con.prepareStatement(updateCarSql)) {

                    ps.setInt(1, carId);

                    int rows = ps.executeUpdate();

                    if (rows == 0) {
                        throw new SQLException(
                                "Car availability update failed!");
                    }
                }

                // Commit transaction
                con.commit();

                System.out.println("Booking Successful!");
                System.out.println("Booking ID: " + bookingId);
                System.out.println("Total Amount: Rs. " + total);

            } catch (SQLException e) {

                con.rollback();

                if ("23505".equals(e.getSQLState())) {
                    System.out.println("Booking ID already exists!");
                } else {
                    System.out.println("Booking Failed!");
                    System.out.println("Reason: " + e.getMessage());
                }

            } catch (Exception e) {

                con.rollback();
                System.out.println("Booking Failed!");
                System.out.println("Reason: " + e.getMessage());
            }

        } catch (SQLException e) {

            System.out.println("Database Connection Failed!");
            System.out.println("Reason: " + e.getMessage());
        }
    }
}
