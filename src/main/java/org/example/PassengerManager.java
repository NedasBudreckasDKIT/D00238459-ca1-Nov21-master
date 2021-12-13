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
                    System.out.printf("2");
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
                return;
            }
        }
        System.out.println("Passenger With ID: "+ passengerID+ " Not Found.");
    }

    public static void deletePassenger(String passengerName){
        Passenger passenger = searchPassenger(passengerName);
        if(passenger != null){
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
            System.out.println("Passenger Name: "+ passenger.getName());
            System.out.println("Passenger ID: "+ passenger.getId());
            System.out.println("Passenger Email: "+ passenger.getEmail());
            System.out.println("Passenger Telephone: "+ passenger.getTelephone());
            System.out.println("Passenger Latitude: "+ passenger.getHomeLatitude());
            System.out.println("Passenger Longitude: "+ passenger.getHomeLongitude());
            System.out.println("\n");
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

}
