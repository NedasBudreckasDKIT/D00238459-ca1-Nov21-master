import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookingManager {
    private final ArrayList<Booking> bookings;
    private final Scanner input;

    public BookingManager() {
        input = new Scanner(System.in);
        this.bookings = new ArrayList<>();
        this.loadVehicles();
    }

    private void loadVehicles() {
        File file = new File("src/bookings.txt");
        try {
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {
                String[] data = fileReader.nextLine().split(",");
                this.add(new Booking(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]),
                        Double.parseDouble(data[3]), Double.parseDouble(data[4]), Double.parseDouble(data[5])));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Vehicles File Not Found...");
        }
    }

    public void add(Booking booking) {
        if (search(booking)) {
            System.out.println("Similar match already found");
            return;
        }
        this.bookings.add(booking);
        writeVehicles();
    }

    public boolean search(Booking bookingToSearch) {

        for (Booking booking : bookings) {
            if (booking.equals(bookingToSearch)) {
                return true;
            }
        }
        return false;
    }

    private void writeVehicles() {
        try {
            FileWriter fileWriter = new FileWriter("src/bookings.txt");
            for (Booking booking : bookings) {
                fileWriter.write(booking.getObjectStr());
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing Vehicles File...");
        }
    }

    public void remove(int id) {
        for (Booking booking : bookings) {
            if (booking.getBookingID() == id) {
                bookings.remove(booking);
                return;
            }
        }
        System.out.println("No similar match found");
    }

    public void edit(int id) {
        for (Booking booking : bookings) {
            if (booking.getBookingID() == id) {
                int index = bookings.indexOf(booking);
                bookings.set(index, getNewBooking());
                return;
            }
        }
        System.out.println("No similar match found");
    }

    public void showBookingsMenu() {
        System.out.println("1.\tAdd a Booking");
        System.out.println("2.\tRemove a Booking");
        System.out.println("3.\tDisplay all Booking");

        System.out.print("Enter your choice: ");
        int choice = input.nextInt();

        this.controls(choice);
    }

    private void controls(int choice) {
        if (choice == 1) {
            this.add(getNewBooking());
        } else if (choice == 2) {
            System.out.println("Enter id: ");
            int id = input.nextInt();
            this.remove(id);
        } else if (choice == 3) {
            displayBookings();
        } else {
            System.out.println("Invalid Entry Entered");
        }
    }

    public void displayBookings() {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public Booking getNewBooking() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter date and time: ");
        String dateTime = input.nextLine();
        System.out.println("Enter start latitude: ");
        double startLong = input.nextDouble();
        System.out.println("Enter start longitude: ");
        double startLat = input.nextDouble();
        System.out.println("Enter end longitude: ");
        double endLong = input.nextDouble();
        System.out.println("Enter end longitude: ");
        double endLat = input.nextDouble();
        System.out.println("Enter cost: ");
        double cost = input.nextDouble();

        return new Booking(dateTime, startLat, startLong, endLat, endLat, cost);
    }

}
