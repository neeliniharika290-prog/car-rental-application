package com.example.car_rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateCar {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== UPDATE CAR DETAILS =====");

        System.out.print("Enter Car ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Car Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Brand: ");
        String brand = sc.nextLine();

        System.out.print("Enter New Model Year: ");
        int year = sc.nextInt();

        System.out.print("Enter New Rent Per Day: ");
        double rent = sc.nextDouble();

        String sql = "UPDATE cars SET car_name = ?, brand = ?, " +
                "model_year = ?, rent_per_day = ? WHERE car_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, brand);
            ps.setInt(3, year);
            ps.setDouble(4, rent);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Car Details Updated Successfully!");
            } else {
                System.out.println("Car ID Not Found!");
            }

        } catch (Exception e) {
            System.out.println("Car Update Failed!");
            e.printStackTrace();
        }

        sc.close();
    }
}