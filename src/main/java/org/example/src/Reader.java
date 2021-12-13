package org.example.src;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Reader {
    private File bookingsFile;
    private File passengersFile;
    private File vehiclesFile;

    public Reader() {
        bookingsFile = new File("src/main/java/org/example/bookings.txt");
        passengersFile = new File("src/main/java/org/example/passengers.txt");
        vehiclesFile = new File("src/main/java/org/example/vehicles.txt");
    }

    public void loadBookings(){
        try {
            Scanner readerForBookings = new Scanner(bookingsFile);
            while (readerForBookings.hasNextLine()) {
                String[] data = readerForBookings.nextLine().split(",");
                int passengerID = Integer.parseInt(data[0]);
                int vehicleID = Integer.parseInt(data[1]);
                LocalDateTime localDateTime = LocalDateTime.parse(data[2]);
                double startLat = Double.parseDouble(data[3]);
                double startLong = Double.parseDouble(data[4]);
                double endLat = Double.parseDouble(data[5]);
                double endLong = Double.parseDouble(data[6]);
                double cost = Double.parseDouble(data[7]);
                Booking booking = new Booking(localDateTime,startLat,startLong,cost,endLat,endLong,vehicleID,passengerID);
                BookingsManager.bookings.add(booking);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Bookings File Not Found...");
        }
    }

    public void loadPassengers(){
        try {
            Scanner readerForPassengers = new Scanner(passengersFile);
            while (readerForPassengers.hasNextLine()) {
                String[] data = readerForPassengers.nextLine().split(",");
                Passenger passenger = new Passenger(data[0],data[1],data[2],Double.parseDouble(data[3]),Double.parseDouble(data[4]));
                PassengerManager.passengers.add(passenger);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Bookings File Not Found...");
        }
    }

    public void loadVehicles(){
        try {
            Scanner readerForVehicles = new Scanner(vehiclesFile);
            while (readerForVehicles.hasNextLine()) {
                String[] data = readerForVehicles.nextLine().split(",");
                String type = data[0];
                String make = data[1];
                String model = data[2];
                double milesPerKWH = Double.parseDouble(data[3]);
                String registrationNumber = data[4];
                int costPerMiles = Integer.parseInt(data[5]);
                String lastServiceDate = data[6];
                int mileage = Integer.parseInt(data[7]);
                double depotLatitude = Double.parseDouble(data[8]);
                double depotLongitude = Double.parseDouble(data[9]);
                if(type.equals("Car") || type.equals("car") || type.equals("4x4") || type.equals("4*4")){
                    int numberOfSeats = Integer.parseInt(data[10]);
                    Car car = new Car(make,model,milesPerKWH,registrationNumber,lastServiceDate,mileage,depotLatitude,depotLongitude,type,numberOfSeats);
                    VehiclesManager.cars.add(car);
                    VehiclesManager.fleet.add(car);
                }
                else if(type.equals("Van") || type.equals("van") || type.equals("Truck") || type.equals("truck")){
                    int loadSpace = Integer.parseInt(data[10]);
                    Van van = new Van(make,model,milesPerKWH,registrationNumber,lastServiceDate,mileage,depotLatitude,depotLongitude,type,loadSpace);
                    VehiclesManager.vans.add(van);
                    VehiclesManager.fleet.add(van);
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Bookings File Not Found...");
        }
    }

}

