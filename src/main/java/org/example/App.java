import java.util.Scanner;

public class App {
    // Components (objects) used in this App
    Scanner input;
    PassengersManager passengersManager;
    BookingManager bookingManager;
    VehicleManager vehicleManager;

    public App() {
        this.passengersManager = new PassengersManager();
        this.bookingManager = new BookingManager();
        this.vehicleManager = new VehicleManager();
        this.input = new Scanner(System.in);
    }

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    void start() {
        System.out.println("1.\tPassengers");
        System.out.println("2.\tVehicles");
        System.out.println("3.\tBookings");
        System.out.println("4.\tEXIT");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();

        this.controlsMainMenu(choice);
    }


    void controlsMainMenu(int choice) {
        if (choice == 1) {
            passengersManager.showPassengersMenu();
        } else if (choice == 2) {
            vehicleManager.showVehiclesMenu();
        } else if (choice == 3) {
            bookingManager.showBookingsMenu();
        } else if (choice == 4) {
            System.exit(0);
        } else {
            System.out.println("Invalid Choice Entered");
        }
        this.start();
    }
}