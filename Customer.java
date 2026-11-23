

package com.example.car_rental;

public class Customer {

    int customerId;
    String customerName;
    String phone;
    String email;

    public Customer(int customerId, String customerName,
                    String phone, String email) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
    }

    public void displayCustomer() {

        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}

