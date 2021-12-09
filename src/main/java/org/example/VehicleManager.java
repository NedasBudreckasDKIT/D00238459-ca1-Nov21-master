import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VehicleManager {
    private final ArrayList<Vehicle> vehicles;
    private final Scanner input;

    public VehicleManager() {
        input = new Scanner(System.in);
        vehicles = new ArrayList<>();
        loadVehicles();
    }

    private void loadVehicles() {
        File file = new File("src/vehicles.txt");
        try {
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {
                String[] data = fileReader.nextLine().split(",");
                if (data[0].equals("Car")) {
                    this.add(new Car(data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5],
                            data[6], Double.parseDouble(data[7]),
                            Double.parseDouble(data[8]),
                            Double.parseDouble(data[9])));
                } else if (data[0].equals("Van")) {
                    this.add(new Van(
                            data[1],
                            data[2],
                            Integer.parseInt(data[3]),
                            Integer.parseInt(data[4]),
                            data[5],
                            data[6],
                            Double.parseDouble(data[7]),
                            Double.parseDouble(data[8]),
                            Double.parseDouble(data[9]),
                            Double.parseDouble(data[10])
                    ));

                } else if (data[0].equals("Truck")) {
                    this.add(new Truck(data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5],
                            data[6], Double.parseDouble(data[7]),
                            Double.parseDouble(data[8]),
                            Double.parseDouble(data[9]),
                            Double.parseDouble(data[10]))
                    );
                } else {
                    this.add(new FourByFour(data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5],
                            data[6], Double.parseDouble(data[7]),
                            Double.parseDouble(data[8]),
                            Double.parseDouble(data[9]))
                    );
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Vehicles File Not Found...");
        }
    }

    private boolean searchVehicle(Vehicle vehicleToSearch) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.equals(vehicleToSearch)) {
                return true;
            }
        }
        return false;
    }

    public void add(Vehicle vehicle) {
        if (searchVehicle(vehicle)) {
            System.out.println("A similar entry found");
            return;
        }
        this.vehicles.add(vehicle);
        this.writeVehicles();
        System.out.println(vehicle);
    }

    private void writeVehicles() {
        try {
            FileWriter fileWriter = new FileWriter("src/vehicles.txt");
            for (Vehicle vehicle : vehicles) {
                fileWriter.write(vehicle.getObjectStr() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing Vehicles File...");
        }
    }

    public void showVehiclesMenu() {
        System.out.println("1.\tDisplay all Vehicles");

        System.out.print("Enter your choice");
        int choice = input.nextInt();

        this.controls(choice);
    }

    private void controls(int choice) {
        if (choice == 1) {
            displayVehicles();
        } else {
            System.out.println("Invalid Entry Entered");
        }
    }

    public void displayVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

}