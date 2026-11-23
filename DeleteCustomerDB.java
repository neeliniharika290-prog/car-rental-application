
package com.example.car_rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteCustomerDB {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== DELETE CUSTOMER =====");

        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM customers WHERE customer_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Customer Deleted Successfully!");
            } else {
                System.out.println("Customer Not Found!");
            }

        } catch (Exception e) {
            System.out.println("Customer Deletion Failed!");
            e.printStackTrace();
        }

        sc.close();
    }
}
