import java.util.ArrayList;
import java.util.Scanner;

public class VehiclesManager {
    public static ArrayList<Vehicle> fleet;
    public static Scanner input = Main.scanner;

    public static void vehiclesPrintInstruction(){
        System.out.println("Please Select From The Following: ");
        System.out.println("0- To Print Instructions");
        System.out.println("1- Add Vehicle");
        System.out.println("2- Edit Vehicle");
        System.out.println("3- Remove Vehicle");
        System.out.println("4- Go Back");

    }

    public static void vehiclesDriverFunction(){
        boolean command = true;
        do{
            vehiclesPrintInstruction();
            char choice = input.next().charAt(0);
            switch (choice){
                case '0': {
                    break;
                }
                case '1': {
                    addVehicle();
                    break;
                }

                case '2': {
                    System.out.println("2");
                    break;
                }

                case '3': {
                    System.out.println("3");
                    break;
                }
                case '4': {
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


    public static void addVehicle(){
        int numberOfSeats = 4;
        int loadSpace = 10;
        input.nextLine();
        System.out.println("Enter Type: ");
        String type = input.nextLine();
        if(type.equals("Car") || type.equals("car") || type.equals("4x4") || type.equals("4*4")){
            System.out.println("Enter Number Of Seats: ");
            numberOfSeats = input.nextInt();
            input.nextLine();
        }
        else if(type.equals("Van") || type.equals("van") || type.equals("Truck") || type.equals("truck")){
            System.out.println("Enter Load Space");
            loadSpace = input.nextInt();
            input.nextLine();
        }
        System.out.println("Enter Make: ");
        String make = input.nextLine();
        System.out.println("Enter Model: ");
        String model = input.nextLine();
        System.out.println("Enter Miles Per KWH: ");
        double miles = input.nextDouble();
        input.nextLine();
        System.out.println("Enter Registration Number: ");
        String registrationNumber = input.nextLine();
        System.out.println("Enter Last Service Date: ");
        String lastServiceDate = input.nextLine();
        System.out.println("Enter Mileage: ");
        int mileage = input.nextInt();
        input.nextLine();
        System.out.println("Enter latitude: ");
        double latitude = input.nextDouble();
        input.nextLine();
        System.out.println("Enter longitude: ");
        double longitude = input.nextDouble();
        input.nextLine();
        if(type.equals("Car") || type.equals("car") || type.equals("4x4") || type.equals("4*4")){
            Vehicle vehicle = new Car(make,model,miles,registrationNumber,lastServiceDate,mileage,latitude,longitude,type,numberOfSeats);
            fleet.add(vehicle);
            System.out.println("SuccessFully Added Car. Id Number = "+vehicle.getId());
        }
        else if(type.equals("Van") || type.equals("van") || type.equals("Truck") || type.equals("truck")){
            Vehicle vehicle = new Van(make,model,miles,registrationNumber,lastServiceDate,mileage,latitude,longitude,type, loadSpace);
            fleet.add(vehicle);
            System.out.println("SuccessFully Added Car. Id Number = "+vehicle.getId());
        }
    }

    public static Vehicle findVehicle(String vehicleType, String make, String model){
        for(Vehicle vehicle: fleet){
            if(vehicle.getType().equals(vehicleType) && vehicle.getMake().equals(make) && vehicle.getModel().equals(model)){
                return vehicle;
            }
        }
        System.out.println("Vehicle Not Found.");
        return null;
    }

}
