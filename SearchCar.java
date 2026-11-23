package com.example.car_rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchCar {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== SEARCH CAR =====");

        System.out.print("Enter Car ID: ");
        int carId = sc.nextInt();

        String sql = "SELECT * FROM cars WHERE car_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, carId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    System.out.println("\nCar Found!");
                    System.out.println("Car ID: " + rs.getInt("car_id"));
                    System.out.println("Car Name: " + rs.getString("car_name"));
                    System.out.println("Brand: " + rs.getString("brand"));
                    System.out.println("Model Year: " + rs.getInt("model_year"));
                    System.out.println("Rent Per Day: Rs. " + rs.getDouble("rent_per_day"));
                    System.out.println("Availability: " + rs.getString("availability"));

                } else {
                    System.out.println("Car Not Found!");
                }
            }

        } catch (Exception e) {
            System.out.println("Search Failed!");
            e.printStackTrace();
        }

        sc.close();
    }
}