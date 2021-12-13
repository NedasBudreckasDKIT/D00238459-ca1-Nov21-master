package org.example.src;

import java.util.ArrayList;
import java.util.Scanner;

public class PassengerManager {
    public static ArrayList<Passenger> passengers;
    public static Scanner input = Main.scanner;

    public static void printPassengersInstructions(){
        System.out.println("1- Add A Passenger");
        System.out.println("2- Edit A Passenger");
        System.out.println("3- Remove a Passenger Using Passenger ID.");
        System.out.println("4- Remove a Passenger Using Passenger Name.");
        System.out.println("5- Display all Passenger");
        System.out.println("6- Go Back");
    }

    public static void passengersDriverFunction(){
        boolean command = true;
        do{
            printPassengersInstructions();
            char choice = input.next().charAt(0);
            switch (choice){
                case '0': {
                    break;
                }
                case '1': {
                    addPassenger();
                    break;
                }

                case '2': {
                    System.out.println("Please Enter Passenger ID: ");
                    int passengerID = input.nextInt();
                    searchPassengerForEditing(passengerID);
                    break;
                }

                case '3': {
                    System.out.println("Please Enter Passenger ID: ");
                    int passengerID = input.nextInt();
                    deletePassenger(passengerID);
                    break;
                }
                case '4': {
                    input.nextLine();
                    System.out.println("Please Enter Passenger Name: ");
                    String passengerName = input.nextLine();
                    deletePassenger(passengerName);
                    break;
                }
                case '5': {
                    printAllPassengers();
                    break;
                }
                case '6': {
                    Main.driverFunction();
                    break;
                }
                default: {
                    System.out.println("Invalid Choice Please Try Again");
                    break;
                }
            }
        }while (command);
    }

    public static void addPassenger(){
        input.nextLine();
        System.out.println("Enter name: ");
        String name = input.nextLine();
        System.out.println("Enter email: ");
        String email = input.nextLine();
        System.out.println("Enter phone: ");
        String phone = input.nextLine();
        System.out.println("Enter latitude: ");
        double latitude = input.nextDouble();
        input.nextLine();
        System.out.println("Enter longitude: ");
        double longitude = input.nextDouble();
        input.nextLine();
        boolean checkDuplicate = preventDuplicates(name,email);
        if(!checkDuplicate){
            System.out.println("Passenger With Name: "+ name + " And Email: " + email + " Already Present." );
            return;
        }
        Passenger passenger = new Passenger(name,email,phone,latitude,longitude);
        passengers.add(passenger);
    }

    public static Passenger searchPassenger(String passengerName){
        if(passengers.size() == 0)
        {
            System.out.println("Passengers List Is Empty.");
            return null;
        }
        for(Passenger passenger: passengers){
            if(passenger.getName().equals(passengerName))
            {
                return passenger;
            }
        }
        System.out.println(passengerName + " Not Found.");
        return null;
    }

    public static void deletePassenger(int passengerID){
        if(passengers.size() == 0)
        {
            System.out.println("Passengers List Is Empty.");
            return;
        }
        for(Passenger passenger: passengers){
            if(passenger.getId() == passengerID){
                passengers.remove(passenger);
                BookingsManager.deleteBookingOnDeletingPassengerWithId(passengerID);
                return;
            }
        }
        System.out.println("Passenger With ID: "+ passengerID+ " Not Found.");
    }

    public static void deletePassenger(String passengerName){
        Passenger passenger = searchPassenger(passengerName);
        if(passenger != null){
            BookingsManager.deleteBookingOnDeletingPassengerWithName(passenger.getId());
            passengers.remove(passenger);
        }
        else if(passenger == null){
            return;
        }
    }

    public static void printAllPassengers(){
        if(passengers.size() == 0)
        {
            System.out.println("Passengers List Is Empty.");
            return;
        }
        for(Passenger passenger: passengers){
            System.out.println(passenger);
        }
    }

    public static boolean preventDuplicates(String passengerName, String passengerEmail){
        if(passengers.size() == 0){
            return true;
        }
        for(Passenger passenger: passengers){
            if(passenger.getName().equals(passengerName) && passenger.getEmail().equals(passengerEmail)){
                return false;
            }
        }
        return true;
    }

    public static Passenger findPassenger(int passengerID){
        if(passengers.size() == 0){
            return null;
        }
        for(Passenger passenger: passengers){
            if(passenger.getId() == passengerID){
                return passenger;
            }
        }
        return null;
    }

    public static void searchPassengerForEditing(int passengerID){
        if(passengers.size() == 0){
            System.out.println("Passengers List Is Empty.");
            return;
        }
        for(Passenger passenger: passengers){
            if(passenger.getId() == passengerID){
                editPassenger(passenger);
                return;
            }
        }
        System.out.println("No Passenger With ID: "+passengerID + " Is Present.");
    }

    public static void editPassenger(Passenger passenger){
        System.out.println("Note: You Can't Change Passenger ID.");
        input.nextLine();
        String check;
        System.out.println("Do You Want To Change Name And Email?(y or n).");
        check = input.nextLine();
        if(check.equals("yes") || check.equals("y") || check.equals("Y")){
            boolean checkAvailability = false;
            do {
                System.out.println("Enter Name: ");
                String name = input.nextLine();
                System.out.println("Enter email: ");
                String email = input.nextLine();
                checkAvailability = preventDuplicates(name, email);
                if (!checkAvailability) {
                    System.out.println("Passenger With Name: " + name + " And Email: " + email + " Already Present.");
                    System.out.println("Duplicates Not Allowed.");
                    System.out.println("Please Try Again.");
                } else if (checkAvailability) {
                    passenger.setEmail(email);
                    passenger.setName(name);
                }
            }while (!checkAvailability);
        }
        System.out.println("Do You Want To Change Phone?(y or n).");
        check = input.nextLine();
        if(check.equals("yes") || check.equals("y") || check.equals("Y")){
            System.out.println("Enter phone: ");
            String phone = input.nextLine();
            passenger.setTelephone(phone);
        }
        System.out.println("Do You Want To Change Passenger Home Latitude And Longitude?(y or n).");
        check = input.nextLine();
        if(check.equals("yes") || check.equals("y") || check.equals("Y")){
            System.out.println("Enter latitude: ");
            double latitude = input.nextDouble();
            input.nextLine();
            System.out.println("Enter longitude: ");
            double longitude = input.nextDouble();
            input.nextLine();
            passenger.setHomeLatitude(latitude);
            passenger.setHomeLongitude(longitude);
        }
        System.out.println("Passenger Edited");
    }

}
