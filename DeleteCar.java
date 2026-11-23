package com.example.car_rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteCar {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== DELETE CAR =====");

        System.out.print("Enter Car ID: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM cars WHERE car_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Car Deleted Successfully!");
            } else {
                System.out.println("Car ID Not Found!");
            }

        } catch (Exception e) {
            System.out.println("Car Deletion Failed!");
            e.printStackTrace();
        }

        sc.close();
    }
}
