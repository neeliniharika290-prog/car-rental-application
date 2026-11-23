
package com.example.car_rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class carmanagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== CAR MANAGEMENT =====");

        System.out.print("Enter Car ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Car Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Brand: ");
        String brand = sc.nextLine();

        System.out.print("Enter Model Year: ");
        int year = sc.nextInt();

        System.out.print("Enter Rent Per Day: ");
        double rent = sc.nextDouble();

        String sql = "INSERT INTO cars " +
                "(car_id, car_name, brand, model_year, rent_per_day) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, brand);
            ps.setInt(4, year);
            ps.setDouble(5, rent);

            ps.executeUpdate();

            System.out.println("Car Added Successfully!");

        } catch (Exception e) {
            System.out.println("Car Addition Failed!");
            e.printStackTrace();
        }

        sc.close();
    }
}
