
import java.util.ArrayList;
import java.util.Scanner;

public class BookingsManager {
    public static ArrayList<Booking> bookings;
    public static Scanner input = Main.scanner;

    public static void printBookingsInstructions(){
        System.out.println("1- Add a Booking");
        System.out.println("2- Edit Booking");
        System.out.println("3- Remove a Booking Using Booking ID.");
        System.out.println("4- Display All Bookings.");
        System.out.println("5- Display All Bookings Using Booking ID.");
        System.out.println("6- Display All Bookings Using Passenger ID.");
        System.out.println("7- Display All Bookings Using Passenger Name.");
        System.out.println("8- Display Average Length Of All Bookings");
        System.out.println("9- Go Back");
    }

    public static void bookingsDriverFunction(){
        boolean command = true;
        do{
            printBookingsInstructions();
            char choice = input.next().charAt(0);
            switch (choice){
                case '1': {
                    input.nextLine();
                    String vehicleType;
                    String vehicleModel;
                    String vehicleMake;
                    String passengerName;
                    System.out.print("Please Enter The Vehicle Type: ");
                    vehicleType = input.nextLine();
                    System.out.print("Please Enter The Vehicle Make: ");
                    vehicleMake = input.nextLine();
                    System.out.print("Please Enter The Vehicle Model: ");
                    vehicleModel = input.nextLine();
                    System.out.print("Please Enter The Vehicle Passenger Name: ");
                    passengerName = input.nextLine();
                    addBooking(vehicleType, vehicleModel, vehicleMake, passengerName);
                    break;
                }

                case '2': {
                    System.out.printf("2");
                    break;
                }

                case '3': {
                    System.out.println("Please Enter Booking ID: ");
                    int bookingID = input.nextInt();
                    deleteBooking(bookingID);
                    break;
                }
                case '4': {
                    displayAllBookingsDetails();
                    break;
                }
                case '5': {
                    System.out.println("Please Enter Booking ID: ");
                    int bookingID = input.nextInt();
                    displayBookingsDetailsGivenBookingID(bookingID);
                    break;
                }
                case '6': {
                    System.out.println("Please Enter Passenger ID: ");
                    int passengerID = input.nextInt();
                    displayAllBookingsDetailsGivenPassengerID(passengerID);
                    break;
                }
                case '7': {
                    input.nextLine();
                    System.out.println("Please Enter Passenger Name: ");
                    String passengerName = input.nextLine();
                    displayAllBookingsDetailsGivenPassengerName(passengerName);
                    break;
                }
                case '8': {
                    averageLengthOfBookingJourneys();
                    break;
                }
                case '9':{
                    Main.driverFunction();
                }
                default: {
                    System.out.println("Invalid Choice Please Try Again");
                    break;
                }
            }
        }while (command);
    }

    public static void addBooking(String vehicleType, String vehicleModel, String vehicleMake, String passengerName){
        System.out.println("Enter date and time: ");
        String dateAndTime = input.nextLine();
        System.out.println("Enter start latitude: ");
        double startLong = input.nextDouble();
        input.nextLine();
        System.out.println("Enter start longitude: ");
        double startLat = input.nextDouble();
        input.nextLine();
        System.out.println("Enter end longitude: ");
        double endLong = input.nextDouble();
        input.nextLine();
        System.out.println("Enter end longitude: ");
        double endLat = input.nextDouble();
        input.nextLine();
        System.out.println("Enter cost: ");
        double cost = input.nextDouble();
        input.nextLine();
        Vehicle vehicle = VehiclesManager.findVehicle(vehicleType,vehicleMake,vehicleModel);
        Passenger passenger = PassengerManager.searchPassenger(passengerName);
        if(vehicle != null && passenger != null) {
            Booking booking = new Booking(dateAndTime,startLat,startLong, cost, endLat, endLong, vehicle.getId(), passenger.getId());
            bookings.add(booking);
            System.out.println("Booking Success Full.");
            String subject = "Booking Confirmed And Scheduled Accordingly.";
            String text = bookingDetails(booking);
            Email email = new Email(passenger.getEmail(),subject, text,dateAndTime);
            email.sendEmail();
        }
        else if(vehicle == null || passenger == null) {
            System.out.println("Booking Failed.");
            return;
        }
    }

    public static String bookingDetails(Booking booking){
        String text;
        text = "Booking Id: "+booking.getId() +
        "Passenger Id: "+ booking.getPassengerID() +
        "Vehicle Id: "+ booking.getVehicleID() +
        "Booking Date And Time: "+ booking.getBookingDate()+
        "Booking Starting Latitude: "+ booking.getStartLatitude()+
        "Booking Starting Longitude: "+ booking.getStartLongitude()+
        "Booking Ending Latitude: "+ booking.getEndLatitude()+
        "Booking Ending Longitude: "+ booking.getEndLongitude();
        return text;
    }

    public static void displayAllBookingsDetails(){
        if(bookings.size() == 0)
        {
            System.out.println("Bookings List Is Empty.");
            return;
        }
        System.out.println("\t\t All Booking Details:");
        for(Booking booking: bookings){
            System.out.println("Booking Id: "+booking.getId());
            System.out.println("Passenger Id: "+ booking.getPassengerID());
            System.out.println("Vehicle Id: "+ booking.getVehicleID());
            System.out.println("Booking Date And Time: "+ booking.getBookingDate());
            System.out.println("Booking Starting Latitude: "+ booking.getStartLatitude());
            System.out.println("Booking Starting Longitude: "+ booking.getStartLongitude());
            System.out.println("Booking Ending Latitude: "+ booking.getEndLatitude());
            System.out.println("Booking Ending Longitude: "+ booking.getEndLongitude());
        }
    }

    public static void displayBookingsDetailsGivenBookingID(int bookingID){
        if(bookings.size() == 0)
        {
            System.out.println("Bookings List Is Empty.");
            return;
        }
        System.out.println("\t\t All Booking Details For Booking ID = "+bookingID+":");
        for(Booking booking: bookings){
            if(booking.getId() == bookingID) {
                System.out.println("Booking Id: " + booking.getId());
                System.out.println("Passenger Id: " + booking.getPassengerID());
                System.out.println("Vehicle Id: " + booking.getVehicleID());
                System.out.println("Booking Date And Time: " + booking.getBookingDate());
                System.out.println("Booking Starting Latitude: " + booking.getStartLatitude());
                System.out.println("Booking Starting Longitude: " + booking.getStartLongitude());
                System.out.println("Booking Ending Latitude: " + booking.getEndLatitude());
                System.out.println("Booking Ending Longitude: " + booking.getEndLongitude());
            }
        }
    }

    public static void displayAllBookingsDetailsGivenPassengerID(int passengerID){
        if(bookings.size() == 0) {
            System.out.println("Bookings List Is Empty.");
            return;
        }
        System.out.println("\t\t All Booking Details For Passenger ID = "+passengerID+":");
        for(Booking booking: bookings){
            if(booking.getPassengerID() == passengerID) {
                System.out.println("Booking Id: " + booking.getId());
                System.out.println("Passenger Id: " + booking.getPassengerID());
                System.out.println("Vehicle Id: " + booking.getVehicleID());
                System.out.println("Booking Date And Time: " + booking.getBookingDate());
                System.out.println("Booking Starting Latitude: " + booking.getStartLatitude());
                System.out.println("Booking Starting Longitude: " + booking.getStartLongitude());
                System.out.println("Booking Ending Latitude: " + booking.getEndLatitude());
                System.out.println("Booking Ending Longitude: " + booking.getEndLongitude());
            }
        }
    }

    public static void displayAllBookingsDetailsGivenPassengerName(String passengerName){
        if(bookings.size() == 0)
        {
            System.out.println("Bookings List Is Empty.");
            return;
        }
        Passenger passenger = PassengerManager.searchPassenger(passengerName);
        if(passenger != null){
            displayAllBookingsDetailsGivenPassengerID(passenger.getId());
        }
        else if(passenger == null){
            System.out.println("No Passenger With "+ passengerName + " Found.");
            return;
        }
    }

    public static void deleteBooking(int bookingID){
        if(bookings.size() == 0)
        {
            System.out.println("Bookings List Is Empty.");
            return;
        }
        for(Booking booking: bookings){
            if(booking.getId() == bookingID){
                bookings.remove(booking);
                System.out.println("Booking With ID: "+ bookingID +" Removed.");
                return;
            }
        }
        System.out.println("No Booking With Booking ID" + bookingID + " Found.");
    }

    public static void averageLengthOfBookingJourneys(){
        if(bookings.size() == 0){
            System.out.println("Bookings List Is Empty.");
            return;
        }
        int count = 0;
        double sum = 0;
        for(Booking booking: bookings){
            double distance = (booking.getStartLatitude() - booking.getEndLatitude()) +(booking.getStartLongitude() - booking.getEndLongitude());
            double total = distance * booking.getCost();
            sum += total;
            count++;
        }
        double length = sum / count;
        System.out.println("Average Length Is: "+ length);
    }

}

