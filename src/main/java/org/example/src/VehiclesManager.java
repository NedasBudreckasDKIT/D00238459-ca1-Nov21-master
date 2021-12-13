import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class VehiclesManager {
    // Our Vehicle Manager Which Contains List for All Vehicles
    // For Car And Vans We Have Separate List
    public static ArrayList<Vehicle> fleet;
    public static ArrayList<Car> cars;
    public static ArrayList<Van> vans;
    public static Scanner input = Main.scanner;

    //Displays Instructions
    public static void vehiclesPrintInstruction(){
        System.out.println("Please Select From The Following: ");
        System.out.println("0- To Print Instructions");
        System.out.println("1- Add Vehicle");
        System.out.println("2- Display Vehicles Based On Type.");
        System.out.println("3- Display Vehicles(Car) Based On Number Of Seats.");
        System.out.println("4- Go Back");

    }

    //Driver Function
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
                    input.nextLine();
                    System.out.println("Please Enter Vehicle Type: ");
                    String type = input.nextLine();
                    displayVehiclesBasedOnType(type);
                    break;
                }
                case '3': {
                    System.out.println("Please Enter Number Of Seats: ");
                    int numberOfSeats = input.nextInt();
                    displayAllVehiclesBasedOnNumberOfSeats(numberOfSeats);
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

    //Add Vehicle Function Which Checks if the Entered Type Is Car Or Van and then asks for
    //Number of seats or loadCapacity as required
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
            Car car = new Car(make,model,miles,registrationNumber,lastServiceDate,mileage,latitude,longitude,type,numberOfSeats);
            fleet.add(car);//Adding to Total Vehicles List
            cars.add(car);// Adding To Cars List
        }
        else if(type.equals("Van") || type.equals("van") || type.equals("Truck") || type.equals("truck")){
            Van van = new Van(make,model,miles,registrationNumber,lastServiceDate,mileage,latitude,longitude,type, loadSpace);
            fleet.add(van);
            vans.add(van);// Adding To Vans List
        }
    }

    //Find Vehicle List Which returns Vehicle Object If Found Based On Type, Make,
    //Model and Registration Number.
    public static Vehicle findVehicle(String vehicleType, String make, String model ,String registrationNumber){
        if(fleet.size() == 0){
            System.out.println("Vehicles List Is Empty.");
            return null;
        }
        for(Vehicle vehicle: fleet){
            if(vehicle.getType().equals(vehicleType) && vehicle.getMake().equals(make) && vehicle.getModel().equals(model) && vehicle.getRegistrationNumber().equals(registrationNumber)){
                return vehicle;
            }
        }
        System.out.println("Vehicle Not Found.");
        return null;
    }

    //Displays All Cars Based On Number Of Seats
    public static void displayAllVehiclesBasedOnNumberOfSeats(int numberOfSeats){
        if(fleet.size() == 0){
            System.out.println("Vehicles List Is Empty.");
            return;
        }
        ArrayList<Car> sortedCarsList = sortBasedOnNumberOfSeats(numberOfSeats);
        for(Car car : sortedCarsList){
            System.out.println(car);
        }
    }

    //Used For Sorting Our List Which returns Ascending Order List Based On Registration Number.
    //By Getting Input as Number Of Seats
    public static ArrayList<Car> sortBasedOnNumberOfSeats(int numberOfSeats){
        ArrayList<Car> sortedCarsList = new ArrayList<>();
        for(Car car : cars){
            if(car.getNumberOfSeats() == numberOfSeats){
                sortedCarsList.add(car);
            }
        }
        Collections.sort(sortedCarsList, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                int result = o1.getRegistrationNumber().compareTo(o2.getRegistrationNumber());
                return result;
            }
        });
        return sortedCarsList;
    }

    //Displays Vehicles Based On Type Either Car Or Van.
    public static void displayVehiclesBasedOnType(String type){
        if(fleet.size() == 0){
            System.out.println("Vehicles List Is Empty.");
        }
        if(type.equals("Car") || type.equals("car") || type.equals("4x4") || type.equals("4*4")){
            ArrayList<Car> sortedCars = sortCars(type);
            for(Car car : sortedCars){
                System.out.println(car);
            }
        }
        else if(type.equals("Van") || type.equals("van") || type.equals("Truck") || type.equals("truck")){
            ArrayList<Van> sortedVans = sortVans(type);
            for(Van van : sortedVans){
                System.out.println(van);
            }
        }
    }

    //Used For Sorting Our List Which returns Cars Ascending Order List Based On Registration Number.
    //By Getting Input as Type Of Vehicle
    public static ArrayList<Car> sortCars(String type){
        ArrayList<Car> sortedCars= new ArrayList<>();
        for(Car car: cars){
            if(car.getType().equals(type)){
                sortedCars.add(car);
            }
        }
        Collections.sort(sortedCars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                int result = o1.getRegistrationNumber().compareTo(o2.getRegistrationNumber());
                return result;
            }
        });
        return sortedCars;
    }

    //Used For Sorting Our List Which returns Ascending Order Cars List Based On Registration Number.
    //By Getting Input as Type
    public static ArrayList<Van> sortVans(String type){
        ArrayList<Van> sortedVans= new ArrayList<>();
        for(Van van: vans){
            if(van.getType().equals(type)){
                sortedVans.add(van);
            }
        }
        Collections.sort(sortedVans, new Comparator<Van>() {
            @Override
            public int compare(Van o1, Van o2) {
                int result = o1.getRegistrationNumber().compareTo(o2.getRegistrationNumber());
                return result;
            }
        });
        return sortedVans;
    }

    //Used For Finding Vehicle Based On Vehicle ID.
    public static Vehicle findVehicle(int vehicleID){
        if(fleet.size() == 0){
            System.out.println("Vehicles List Is Empty.");
            return null;
        }
        for(Vehicle vehicle: fleet){
            if(vehicle.getId() == vehicleID){
                return vehicle;
            }
        }
        System.out.println("Vehicle With ID: "+vehicleID+" Not Found.");
        return null;
    }
}
