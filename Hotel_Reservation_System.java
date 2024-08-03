import java.util.*;

class Hotel {
    private static final int SINGLE_NON_AC = 0;
    private static final int DOUBLE_NON_AC = 1;
    private static final int SINGLE_AC = 2;
    private static final int DOUBLE_AC = 3;

    private int[] roomsAvailability = new int[20];
    private Map<Integer, String> bookingDetails = new HashMap<>();

    void display() {
        System.out.println("\n1. Search for Available Rooms");
        System.out.println("2. Make Reservation");
        System.out.println("3. View Booking Details");
        System.out.println("4. Exit");
    }

    void displayRoomCategories() {
        System.out.println("\nRoom Categories:");
        System.out.println("1. Single Non-AC");
        System.out.println("2. Double Non-AC");
        System.out.println("3. Single AC");
        System.out.println("4. Double AC");
    }

    void searchForAvailableRooms() {
        displayRoomCategories();
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        int start = 0;
        int end = 0;

        switch (option) {
            case 1:
                start = 0;
                end = 3;
                break;
            case 2:
                start = 3;
                end = 5;
                break;
            case 3:
                start = 5;
                end = 8;
                break;
            case 4:
                start = 8;
                end = 10;
                break;
            default:
                System.out.println("Invalid option.");
                return;
        }

        boolean roomFound = false;
        for (int i = start; i < end; i++) {
            if (roomsAvailability[i] == 0) {
                System.out.println("Room no. " + (i + 1) + " is available.");
                roomFound = true;
            }
        }

        if (!roomFound) {
            System.out.println("No rooms available in this category.");
        }
    }

    void makeReservations() {
        displayRoomCategories();
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        int start = 0;
        int end = 0;

        switch (option) {
            case 1: 
                start = 0;
                end = 3;
                break;
            case 2: 
                start = 3;
                end = 5;
                break;
            case 3:
                start = 5;
                end = 8;
                break;
            case 4:
                start = 8;
                end = 10;
                break;
            default:
                System.out.println("Invalid option.");
                return;
        }

        int roomNo = -1;
        for (int i = start; i < end; i++) {
            if (roomsAvailability[i] == 0) {
                roomNo = i + 1;
                break;
            }
        }

        if (roomNo == -1) {
            System.out.println("No available rooms in the selected category.");
            return;
        }

        System.out.println("Room no. " + roomNo + " is available. Confirm reservation (1 - Yes, 0 - No):");
        int confirm = sc.nextInt();

        if (confirm == 1) {
            sc.nextLine(); // Consume newline
            System.out.println("Enter your name:");
            String name = sc.nextLine();
            System.out.println("Enter your phone number:");
            String phone = sc.nextLine();
            proceedToPay();
            roomsAvailability[roomNo - 1] = 1; // Mark room as booked
            bookingDetails.put(roomNo, "Name: " + name + ", Phone: " + phone);
            System.out.println("Your booking Reservation Details:");
            System.out.println("Name: " + name);
            System.out.println("Phone: " + phone);
            System.out.println("Booked room: " + roomNo);
        } else {
            System.out.println("Reservation not confirmed.");
        }
    }

    void proceedToPay() {
        System.out.println("Kindly pay an amount of $200 as advance to confirm your reservation.");
        System.out.println("You can pay to MobileNo---1234567890---through any UPI app.");
        System.out.println("Thank you for your confirmation.");
    }

    void viewBookingDetails() {
        System.out.println("Enter the room number to view booking details:");
        Scanner sc = new Scanner(System.in);
        int roomNo = sc.nextInt();

        if (bookingDetails.containsKey(roomNo)) {
            System.out.println("Booking Details for Room no. " + roomNo + ":");
            System.out.println(bookingDetails.get(roomNo));
        } else {
            System.out.println("No booking details found for Room no. " + roomNo);
        }
    }
}

public class Hotel_Reservation_System {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner sc = new Scanner(System.in);
        int option = 0;

        System.out.println("\n-----WELCOME TO THE HOTEL RESERVATION SYSTEM-----\n");

        do {
            hotel.display();
            System.out.println("Enter your choice:");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    hotel.searchForAvailableRooms();
                    break;
                case 2:
                    hotel.makeReservations();
                    break;
                case 3:
                    hotel.viewBookingDetails();
                    break;
                case 4:
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 4);
    }
}
