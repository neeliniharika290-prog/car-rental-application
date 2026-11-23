
package com.example.car_rental;

import java.sql.*;

public class RevenueReport {

    public static void main(String[] args) {

        System.out.println("===== CAR RENTAL REVENUE REPORT =====");

        String sql =
                "SELECT COUNT(*) AS total_bookings, " +
                        "COUNT(*) FILTER (WHERE status = 'Booked') AS active_bookings, " +
                        "COUNT(*) FILTER (WHERE status = 'Cancelled') AS cancelled_bookings, " +
                        "COALESCE(SUM(total_amount) FILTER " +
                        "(WHERE status = 'Booked'), 0) AS total_revenue " +
                        "FROM bookings";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {

                System.out.println("--------------------------");

                System.out.println("Total Bookings: " +
                        rs.getInt("total_bookings"));

                System.out.println("Active Bookings: " +
                        rs.getInt("active_bookings"));

                System.out.println("Cancelled Bookings: " +
                        rs.getInt("cancelled_bookings"));

                System.out.println("Total Revenue: Rs. " +
                        rs.getDouble("total_revenue"));
            }

        } catch (SQLException e) {

            System.out.println("Revenue Report Failed!");
            System.out.println("Reason: " + e.getMessage());
        }
    }
}
