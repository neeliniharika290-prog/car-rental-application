
package com.example.car_rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewCars {

    public static void main(String[] args) {

        String sql = "SELECT * FROM cars";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("===== AVAILABLE CARS =====");

            while (rs.next()) {
                System.out.println("Car ID: " + rs.getInt("car_id"));
                System.out.println("Car Name: " + rs.getString("car_name"));
                System.out.println("Brand: " + rs.getString("brand"));
                System.out.println("Model Year: " + rs.getInt("model_year"));
                System.out.println("Rent Per Day: " + rs.getDouble("rent_per_day"));
                System.out.println("--------------------------");
            }

        } catch (Exception e) {
            System.out.println("Unable to Display Cars!");
            e.printStackTrace();
        }
    }
}

