import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        VehiclesManager.fleet = new ArrayList<>();
        PassengerManager.passengers = new ArrayList<>();
        BookingsManager.bookings = new ArrayList<>();
        driverFunction();
    }

    public static void printInstruction(){
        System.out.println("Please Select From The Following: ");
        System.out.println("0- To Print Instructions");
        System.out.println("1- Bookings");
        System.out.println("2- Passengers");
        System.out.println("3- Vehicles");
        System.out.println("4- Exit");

    }

    public static void driverFunction(){
        boolean command = true;
        do{
            printInstruction();
            char choice = scanner.next().charAt(0);
            switch (choice){
                case '0': {
                    break;
                }
                case '1': {
                    BookingsManager.bookingsDriverFunction();
                    break;
                }

                case '2': {
                    PassengerManager.passengersDriverFunction();
                    break;
                }

                case '3': {
                    VehiclesManager.vehiclesDriverFunction();
                    break;
                }
                case '4': {
                    System.out.println("Bye Bye");
                    command = false;
                    break;
                }
                default: {
                    System.out.println("Invalid Choice Please Try Again");
                    break;
                }
            }
        }while (command);
    }
}
