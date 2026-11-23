
package com.example.car_rental;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n===== CAR RENTAL MANAGEMENT SYSTEM =====");

            System.out.println("\n===== CUSTOMER MANAGEMENT =====");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Update Customer");
            System.out.println("5. Delete Customer");

            System.out.println("\n===== CAR MANAGEMENT =====");
            System.out.println("6. Add Car");
            System.out.println("7. View Cars");
            System.out.println("8. Search Car");
            System.out.println("9. Update Car");
            System.out.println("10. Delete Car");

            System.out.println("\n===== BOOKING MANAGEMENT =====");
            System.out.println("11. Book Car");
            System.out.println("12. View Bookings");
            System.out.println("13. Search Booking");
            System.out.println("14. Update Booking");
            System.out.println("15. Cancel Booking");

            System.out.println("\n===== CUSTOMER REPORTS =====");
            System.out.println("16. Customer Booking History");
            System.out.println("17. Customer Total Spending");

            System.out.println("\n===== BUSINESS REPORTS =====");
            System.out.println("18. Revenue Report");

            System.out.println("\n0. Exit");

            System.out.print("\nEnter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1: AddCustomerDB.main(new String[0]); break;
                case 2: ViewCustomersDB.main(new String[0]); break;
                case 3: SearchCustomerDB.main(new String[0]); break;
                case 4: UpdateCustomerDB.main(new String[0]); break;
                case 5: DeleteCustomerDB.main(new String[0]); break;

                case 6: carmanagement.main(new String[0]); break;
                case 7: ViewCars.main(new String[0]); break;
                case 8: SearchCar.main(new String[0]); break;
                case 9: UpdateCar.main(new String[0]); break;
                case 10: DeleteCar.main(new String[0]); break;

                case 11: Booking.main(new String[0]); break;
                case 12: ViewBookings.main(new String[0]); break;
                case 13: SearchBooking.main(new String[0]); break;
                case 14: UpdateBooking.main(new String[0]); break;
                case 15: CancelBooking.main(new String[0]); break;

                case 16: CustomerBookingHistory.main(new String[0]); break;
                case 17: CustomerSpending.main(new String[0]); break;
                case 18: RevenueReport.main(new String[0]); break;

                case 0:
                    System.out.println(
                            "Thank You for Using Car Rental System!");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
