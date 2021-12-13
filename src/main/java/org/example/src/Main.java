package org.example.src;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static Reader reader = new Reader();
    public static Writer writer = new Writer();
    public static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //Initializing All Array Lists.
        VehiclesManager.fleet = new ArrayList<>();
        VehiclesManager.cars = new ArrayList<>();
        VehiclesManager.vans = new ArrayList<>();
        PassengerManager.passengers = new ArrayList<>();
        BookingsManager.bookings = new ArrayList<>();
        reader.loadBookings();
        reader.loadPassengers();
        reader.loadVehicles();
        driverFunction(); // The Main Driver Function.
    }

    // Displays Instructions Related To Main Menu
    public static void printInstruction(){
        System.out.println("Please Select From The Following: ");
        System.out.println("0- To Print Instructions");
        System.out.println("1- Bookings");
        System.out.println("2- Passengers");
        System.out.println("3- Vehicles");
        System.out.println("4- Exit");

    }

    // Our Main Driver Function Which Exit On Pressing 4
    public static void driverFunction(){
        char choice;
        boolean command = true;
        do{
            printInstruction();
            choice = scanner.next().charAt(0);
            switch (choice){
                case '0': {
                    break;
                }
                case '1': {
                    BookingsManager.bookingsDriverFunction();//Call To BookingManager Driver Function
                    scanner.nextLine();
                    break;
                }

                case '2': {
                    PassengerManager.passengersDriverFunction();//Call To PassengerManager Driver Function
                    scanner.nextLine();
                    break;
                }

                case '3': {
                    VehiclesManager.vehiclesDriverFunction();//Call To VehicleManager Driver Function
                    scanner.nextLine();
                    break;
                }
                case '4': {
                    writer.writeBookings();
                    writer.writePassengers();
                    writer.writeVehicles();
                    System.out.println("Bye Bye");
                    command = false;
                    System.exit(0);
                }
                default: {
                    System.out.println("Invalid Choice Please Try Again");
                    break;
                }
            }
        }while (command);
    }
}
