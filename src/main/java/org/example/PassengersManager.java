import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PassengersManager {
    ArrayList<Passenger> passengers;
    Scanner input;

    public PassengersManager() {
        input = new Scanner(System.in);
        this.passengers = new ArrayList<>();
        this.loadPassengers();
    }

    private void loadPassengers() {
        File file = new File("src/passengers.txt");
        try {
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {
                String[] data = fileReader.nextLine().split(",");
                this.add(new Passenger(data[0], data[1], data[2], Double.parseDouble(data[3]),
                        Double.parseDouble(data[4])));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Vehicles File Not Found...");
        }
    }


    private void writePassengers() {
        try {
            FileWriter fileWriter = new FileWriter("src/passengers.txt");
            for (Passenger passenger : passengers) {
                fileWriter.write(passenger.getObjectStr());
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing Vehicles File...");
        }
    }

    public void add(Passenger passenger) {
        if (search(passenger)) {
            System.out.println("Similar entry already exists");
            return;
        }
        this.passengers.add(passenger);
        writePassengers();
    }

    public void edit(int id) {
        for (Passenger passenger : passengers) {
            if (passenger.getId() == id) {
                passenger = getNewPassenger();
                return;
            }
        }
        System.out.println("No similar match found");
    }

    public void remove(int id) {
        for (Passenger passenger : passengers) {
            if (passenger.getId() == id) {
                passengers.remove(passenger);
                return;
            }
        }
        System.out.println("No similar match found");
    }


    public void showPassengersMenu() {
        System.out.println("1.\tAdd a Passenger");
        System.out.println("2.\tEdit a Passenger");
        System.out.println("3.\tRemove a Passenger");
        System.out.println("4.\tDisplay all Passengers");

        System.out.print("Enter your choice: ");
        int choice = input.nextInt();

        this.controls(choice);
    }

    private void controls(int choice) {
        if (choice == 1) {
            input.nextLine();
            this.add(getNewPassenger());
        } else if(choice == 2){
            System.out.println("Enter id: ");
            int id = input.nextInt();
            this.edit(id);
        } else if (choice == 3) {
            System.out.println("Enter id: ");
            int id = input.nextInt();
            this.remove(id);
        } else if (choice == 4) {
            displayPassengers();
        } else {
            System.out.println("Invalid Entry Entered");
        }
    }

    public void displayPassengers() {
        for (Passenger passenger : passengers) {
            System.out.println(passenger);
        }
    }


    Passenger getNewPassenger() {
        System.out.println("Enter name: ");
        String name = input.nextLine();
        System.out.println("Enter email: ");
        String email = input.nextLine();
        System.out.println("Enter phone: ");
        String phone = input.nextLine();
        System.out.println("Enter latitude: ");
        double latitude = input.nextDouble();
        System.out.println("Enter longitude: ");
        double longitude = input.nextDouble();
        return new Passenger(name, email, phone, latitude, longitude);
    }

    public boolean search(Passenger passengerToSearch) {
        for (Passenger passenger : passengers) {
            if (passenger.equals(passengerToSearch)) {
                return true;
            }
        }
        return false;
    }

}
