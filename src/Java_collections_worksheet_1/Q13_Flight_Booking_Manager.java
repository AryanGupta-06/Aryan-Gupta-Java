package Java_collections_worksheet_1;

import java.util.*;

public class Q13_Flight_Booking_Manager {
    private Queue<String> bookingRequests;
    private Map<String, Integer> confirmedBookings;
    private int nextSeatNumber;

    public Q13_Flight_Booking_Manager() {
        bookingRequests = new LinkedList<>();
        confirmedBookings = new HashMap<>();
        nextSeatNumber = 1;
    }

    public void addBookingRequest(String passengerName) {
        bookingRequests.add(passengerName);
        System.out.println("Booking request added for " + passengerName);
    }

    public void processAllBookings() {
        if (bookingRequests.isEmpty()) {
            System.out.println("No booking requests to process.");
        } else {
            while (!bookingRequests.isEmpty()) {
                String passengerName = bookingRequests.poll();
                confirmedBookings.put(passengerName, nextSeatNumber);
                System.out.println("Booking confirmed for " + passengerName + " with seat number " + nextSeatNumber);
                nextSeatNumber++;
            }
        }
    }

    public void displayConfirmedBookings() {
        if (confirmedBookings.isEmpty()) {
            System.out.println("No confirmed bookings.");
        } else {
            System.out.println("Confirmed Bookings:");
            for (Map.Entry<String, Integer> entry : confirmedBookings.entrySet()) {
                System.out.println("Passenger: " + entry.getKey() + ", Seat Number: " + entry.getValue());
            }
        }
    }

    public void removeBooking(String passengerName) {
        if (bookingRequests.remove(passengerName)) {
            System.out.println("Booking request removed for " + passengerName);
        } else if (confirmedBookings.remove(passengerName) != null) {
            System.out.println("Confirmed booking removed for " + passengerName);
        } else {
            System.out.println("No booking found for " + passengerName);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q13_Flight_Booking_Manager manager = new Q13_Flight_Booking_Manager();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nFlight Booking Manager Menu:");
            System.out.println("1. Add Booking Request");
            System.out.println("2. Process All Bookings");
            System.out.println("3. Display Confirmed Bookings");
            System.out.println("4. Remove Booking");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter passenger name: ");
                    String passengerName = scanner.nextLine();
                    manager.addBookingRequest(passengerName);
                    break;
                case 2:
                    manager.processAllBookings();
                    break;
                case 3:
                    manager.displayConfirmedBookings();
                    break;
                case 4:
                    System.out.print("Enter passenger name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    manager.removeBooking(nameToRemove);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting Flight Booking Manager.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
