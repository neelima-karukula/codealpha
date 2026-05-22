import java.util.ArrayList;
import java.util.Scanner;

// Room Class
class Room {
    int roomNumber;
    String category;
    double price;
    boolean booked;

    // Constructor
    Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.booked = false;
    }

    // Display room details
    void displayRoom() {
        System.out.println("Room No: " + roomNumber +
                " | Category: " + category +
                " | Price: ₹" + price +
                " | Status: " + (booked ? "Booked" : "Available"));
    }
}

// Booking Class
class Booking {
    String customerName;
    Room room;

    Booking(String customerName, Room room) {
        this.customerName = customerName;
        this.room = room;
    }

    void displayBooking() {
        System.out.println("Customer: " + customerName +
                " | Room No: " + room.roomNumber +
                " | Category: " + room.category +
                " | Price: ₹" + room.price);
    }
}

// Main Class
public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add default rooms
    static void addRooms() {
        rooms.add(new Room(101, "Standard", 2000));
        rooms.add(new Room(102, "Deluxe", 3500));
        rooms.add(new Room(103, "Suite", 5000));
        rooms.add(new Room(104, "Standard", 2000));
        rooms.add(new Room(105, "Deluxe", 3500));
    }

    // View all rooms
    static void viewRooms() {
        System.out.println("\n===== ROOM LIST =====");
        for (Room room : rooms) {
            room.displayRoom();
        }
    }

    // Book room
    static void bookRoom() {
        System.out.print("\nEnter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Room Number to Book: ");
        int roomNo = sc.nextInt();
        sc.nextLine();

        for (Room room : rooms) {
            if (room.roomNumber == roomNo) {

                if (!room.booked) {
                    room.booked = true;

                    Booking booking = new Booking(name, room);
                    bookings.add(booking);

                    // Payment Simulation
                    System.out.println("Payment of ₹" + room.price + " Successful!");

                    System.out.println("Room Booked Successfully!");
                } else {
                    System.out.println("Room Already Booked!");
                }
                return;
            }
        }

        System.out.println("Room Not Found!");
    }

    // Cancel booking
    static void cancelBooking() {
        System.out.print("\nEnter Room Number to Cancel Booking: ");
        int roomNo = sc.nextInt();
        sc.nextLine();

        for (Booking booking : bookings) {

            if (booking.room.roomNumber == roomNo) {

                booking.room.booked = false;
                bookings.remove(booking);

                System.out.println("Booking Cancelled Successfully!");
                return;
            }
        }

        System.out.println("Booking Not Found!");
    }

    // View bookings
    static void viewBookings() {

        System.out.println("\n===== BOOKING DETAILS =====");

        if (bookings.isEmpty()) {
            System.out.println("No Bookings Found!");
            return;
        }

        for (Booking booking : bookings) {
            booking.displayBooking();
        }
    }

    // Main method
    public static void main(String[] args) {

        addRooms();

        int choice;

        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    viewRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    cancelBooking();
                    break;

                case 4:
                    viewBookings();
                    break;

                case 5:
                    System.out.println("Thank You for Using Hotel Reservation System!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}