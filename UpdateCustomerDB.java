
package com.example.car_rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdateCustomerDB {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== UPDATE CUSTOMER =====");

        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        try (Connection con = DBConnection.getConnection()) {

            String checkSql =
                    "SELECT * FROM customers WHERE customer_id = ?";

            try (PreparedStatement check =
                         con.prepareStatement(checkSql)) {

                check.setInt(1, id);

                ResultSet rs = check.executeQuery();

                if (rs.next()) {

                    System.out.println("Customer Found!");
                    System.out.println("Current Name: "
                            + rs.getString("customer_name"));

                    System.out.print("Enter New Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter New Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String email = sc.nextLine();

                    String updateSql =
                            "UPDATE customers SET customer_name = ?, " +
                                    "phone = ?, email = ? WHERE customer_id = ?";

                    try (PreparedStatement ps =
                                 con.prepareStatement(updateSql)) {

                        ps.setString(1, name);
                        ps.setString(2, phone);
                        ps.setString(3, email);
                        ps.setInt(4, id);

                        int rows = ps.executeUpdate();

                        if (rows > 0) {
                            System.out.println(
                                    "Customer Updated Successfully!");
                        }
                    }

                } else {
                    System.out.println("Customer Not Found!");
                }
            }

        } catch (Exception e) {
            System.out.println("Customer Update Failed!");
            e.printStackTrace();
        }

        sc.close();
    }
}
