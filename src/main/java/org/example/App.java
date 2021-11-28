package org.example;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    // Components (objects) used in this App
    PassengerStore passengerStore;  // encapsulates access to list of Passengers
    VehicleManager vehicleManager;  // encapsulates access to list of Vehicles
    BookingManager bookingManager;  // deals with all bookings

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    public void start() {
        // create PassengerStore and load all passenger records from text file
        passengerStore = new PassengerStore("passengers.txt");

        // create VehicleManager, and load all vehicles from text file
        vehicleManager = new VehicleManager("vehicles.txt");

        try {
            displayMainMenu();        // User Interface - Menu
        } catch (IOException e) {
            e.printStackTrace();
        }


        vehicleManager.displayAllVehicles();

        String registration = "172LH234106";
        Vehicle vehicle = vehicleManager.findVehicleByRegistration(registration);
        if (vehicle == null)
            System.out.println("No vehicle with registration " + registration + " was found.");
        else
            System.out.println("Found Vehicle: " + vehicle.toString());

        // Create BookingManager and load all bookings from file
        // bookingManager = new BookingManager("bookings.txt");

        //pMgr.saveToFile();

        System.out.println("Goodbye");
    }

    private void displayMainMenu() throws IOException {

        final String MENU_ITEMS = "\n*** MAIN MENU ***\n"
                + "1-> Passengers\n"
                + "2-> Vehicles\n"
                + "3-> Bookings\n"
                + "4-> Exit\n"
                + "Enter Option from Option 1-4";

        final int PASSENGERS = 1;
        final int VEHICLES = 2;
        final int BOOKINGS = 3;
        final int EXIT = 4;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case PASSENGERS:
                        System.out.println("Passengers option chosen");
                        displayPassengerMenu();
                        break;
                    case VEHICLES:
                        System.out.println("Vehicles option chosen");
                        displayVehicleMenu();
                        break;
                    case BOOKINGS:
                        System.out.println("Bookings option chosen");
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

        System.out.println("\nExiting Main Menu, goodbye.");
    }
    // Sub-Menu-Vehicle
    private void displayVehicleMenu() {
        final String VEHICLE_MENU_ITEMS = "\n*** VEHICLE MENU ***\n"
                + "1-> Show All Vehicles\n"
                + "2-> Show Vehicle by Registration\n"
                + "3-> Show Vehicle By Type\n"
                + "4-> Exit\n"
                + "Enter Option [1,4]";

        final int SHOW_ALL_VEHICLES = 1;
        final int SHOW_REG = 2;
        final int SHOW_TYPE = 3;
        final int EXIT = 4;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + VEHICLE_MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case SHOW_ALL_VEHICLES:
                        System.out.println("Displaying All Cars");
                        vehicleManager.displayAllVehicles();
                        break;
                    case SHOW_REG:
                        System.out.println("Displaying Cars by Reg");
                        System.out.println("Input the Car Registration");
                        String registration = keyboard.nextLine();
                        vehicleManager.findVehicleByRegistration(registration);
                        break;
                    case SHOW_TYPE:
                        System.out.println("Displaying Cars by Type");
                        System.out.println("Input the Car Type(eg Van,Car)");
                        String type = keyboard.nextLine();
                        vehicleManager.findVehicleByType(type);
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;

                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);
    }
    // Sub-Menu-Passenger
    private void displayPassengerMenu() {
        final String MENU_ITEMS = "\n*** PASSENGER MENU ***\n"
                + "1-> Show all Passengers\n"
                + "2-> Find Passenger by Name\n"
                + "3-> Add Passenger\n"
                + "4-> Exit\n"
                + "Enter Option [1,4]";

        final int SHOW_ALL = 1;
        final int FIND_BY_NAME = 2;
        final int ADD_PASSENGER =3;
        final int EXIT = 4;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case SHOW_ALL:
                        System.out.println("Display ALL Passengers");
                        passengerStore.displayAllPassengers();
                        break;
                    case FIND_BY_NAME:
                        System.out.println("Find Passenger by Name");
                        System.out.println("Enter the passenger's name: ");
                        String name = keyboard.nextLine();
                        Passenger p = (Passenger) passengerStore.findPassengerByName(name);
                        if (p == null)
                            System.out.println("No passenger matching the name \"" + name + "\"");
                        else
                            System.out.println("Found passenger: \n" + p.toString());
                        break;
                    case ADD_PASSENGER:
                        System.out.println("Enter the Passenger's Name: \n");
                        name = keyboard.nextLine();
                        System.out.println("Enter the Passenger's Email: \n");
                        String email = keyboard.nextLine();
                        System.out.println("Enter the Passenger's Phone: \n");
                        String phone = keyboard.nextLine();
                        System.out.println("Enter the Passenger's Location: \n");
                        String location = keyboard.nextLine();
                        System.out.println("The Passenger has been added! \n");
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

    }
}