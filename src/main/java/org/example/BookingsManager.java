import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        System.out.println("9- Display All Current Bookings.");
        System.out.println("10- Go Back");
    }

    public static void bookingsDriverFunction(){
        boolean command = true;
        do{
            printBookingsInstructions();
            String choice = input.nextLine();
            switch (choice){
                case "1": {
                    String vehicleType;
                    String vehicleModel;
                    String vehicleMake;
                    String registrationNumber;
                    String passengerName;
                    System.out.println("Please Enter The Vehicle Type: ");
                    vehicleType = input.nextLine();
                    System.out.println("Please Enter The Vehicle Make: ");
                    vehicleMake = input.nextLine();
                    System.out.println("Please Enter The Vehicle Model: ");
                    vehicleModel = input.nextLine();
                    System.out.println("Please Enter The Vehicle Registration Number: ");
                    registrationNumber = input.nextLine();
                    System.out.println("Please Enter The Vehicle Passenger Name: ");
                    passengerName = input.nextLine();
                    addBooking(vehicleType, vehicleModel, vehicleMake, passengerName, registrationNumber);
                    break;
                }

                case "2": {
                    System.out.printf("2");
                    break;
                }

                case "3": {
                    System.out.println("Please Enter Booking ID: ");
                    int bookingID = input.nextInt();
                    deleteBooking(bookingID);
                    break;
                }
                case "4": {
                    displayAllBookingsDetails();
                    break;
                }
                case "5": {
                    System.out.println("Please Enter Booking ID: ");
                    int bookingID = input.nextInt();
                    displayBookingDetailsGivenBookingID(bookingID);
                    break;
                }
                case "6": {
                    System.out.println("Please Enter Passenger ID: ");
                    int passengerID = input.nextInt();
                    displayAllBookingsDetailsGivenPassengerID(passengerID);
                    break;
                }
                case "7": {
                    input.nextLine();
                    System.out.println("Please Enter Passenger Name: ");
                    String passengerName = input.nextLine();
                    displayAllBookingsDetailsGivenPassengerName(passengerName);
                    break;
                }
                case "8": {
                    averageLengthOfBookingJourneys();
                    break;
                }
                case "9": {
                    displayAllCurrentBookings();
                    break;
                }
                case "10":{
                    Main.driverFunction();
                }
                default: {
                    System.out.println("Invalid Choice Please Try Again");
                    break;
                }
            }
        }while (command);
    }

    public static void addBooking(String vehicleType, String vehicleModel, String vehicleMake, String passengerName, String registrationNumber){
        System.out.println("Enter date and time: ");
        System.out.println("Enter year: ");
        int year = input.nextInt();
        input.nextLine();
        System.out.println("Enter month: ");
        int month = input.nextInt();
        input.nextLine();
        System.out.println("Enter day: ");
        int day = input.nextInt();
        input.nextLine();
        System.out.println("Enter hours of day: ");
        int hour = input.nextInt();
        input.nextLine();
        System.out.println("Enter minutes of hour: ");
        int min = input.nextInt();
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, min);
        System.out.println("Enter end latitude: ");
        double endLat = input.nextDouble();
        input.nextLine();
        System.out.println("Enter end longitude: ");
        double endLong = input.nextDouble();
        input.nextLine();
        Vehicle vehicle = VehiclesManager.findVehicle(vehicleType,vehicleMake,vehicleModel, registrationNumber);
        Passenger passenger = PassengerManager.searchPassenger(passengerName);
        if(vehicle != null && passenger != null) {
            double startLat = passenger.getHomeLatitude();
            double startLong = passenger.getHomeLongitude();
            double cost = calculateCost(startLat,startLong,endLat,endLong,vehicle);
            boolean checkAvailability = checkAvailability(dateTime, vehicle);
            if(!checkAvailability){
                String date = dateTime.format(Main.format);
                System.out.println("Vehicle With ID: "+vehicle.getId()+ " Is Already Booked For Date: "+ date);
                System.out.println("Booking Is Not Success Full.");
                return;
            }
            Booking booking = new Booking(dateTime,startLat,startLong, cost, endLat, endLong, vehicle.getId(), passenger.getId());
            bookings.add(booking);
            System.out.println("Booking Success Full.");
            String subject = "Booking Confirmed And Scheduled Accordingly.";
            String text = bookingDetails(booking);
            LocalDateTime localDateTime = LocalDateTime.now();
            if(localDateTime.isBefore(dateTime)) {
                Email email = new Email(passenger.getEmail(), subject, text, dateTime);
                email.sendEmail();
            }
        }
        else if(vehicle == null || passenger == null) {
            System.out.println("Booking Failed.");
            return;
        }
    }

    public static String bookingDetails(Booking booking){
        String date = booking.getBookingDate().format(Main.format);
        String text;
        text = "Booking Id: "+booking.getId() +
        "Passenger Id: "+ booking.getPassengerID() +
        "Vehicle Id: "+ booking.getVehicleID() +
        "Booking Date And Time: "+ date +
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
            String date = booking.getBookingDate().format(Main.format);
            System.out.println("Booking Date And Time: " + date);
            System.out.println("Booking Starting Latitude: "+ booking.getStartLatitude());
            System.out.println("Booking Starting Longitude: "+ booking.getStartLongitude());
            System.out.println("Booking Ending Latitude: "+ booking.getEndLatitude());
            System.out.println("Booking Ending Longitude: "+ booking.getEndLongitude());
        }
    }

    public static void displayBookingDetailsGivenBookingID(int bookingID){
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
                String date = booking.getBookingDate().format(Main.format);
                System.out.println("Booking Date And Time: " + date);
                System.out.println("Booking Starting Latitude: " + booking.getStartLatitude());
                System.out.println("Booking Starting Longitude: " + booking.getStartLongitude());
                System.out.println("Booking Ending Latitude: " + booking.getEndLatitude());
                System.out.println("Booking Ending Longitude: " + booking.getEndLongitude());
                return;
            }
        }
        System.out.println("No Booking With Booking ID: "+ bookingID+" Is Present.");
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
                String date = booking.getBookingDate().format(Main.format);
                System.out.println("Booking Date And Time: " + date);
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
        double count = bookings.size();
        double sum = 0;
        for(Booking booking: bookings){
            double totalCost = booking.getCost();
            sum += totalCost;
        }
        double length = sum / count;
        System.out.println("Average Length Is: "+ length);
    }

    public static double calculateCost(double startLatitude, double startLongitude, double endLatitude, double endLongitude, Vehicle vehicle){
        double vehicleLongitude = Math.toRadians(vehicle.getDepotLongitude());
        startLongitude = Math.toRadians(startLongitude);
        double vehicleLatitude = Math.toRadians(vehicle.getDepotLatitude());
        startLatitude = Math.toRadians(startLatitude);
        endLongitude = Math.toRadians(endLongitude);
        endLatitude = Math.toRadians(endLatitude);
        double costPerMiles = vehicle.getCostPerMiles();

        // Haversine formula
        double vehicleToStartLongitudeDistance = startLongitude - vehicleLongitude;
        double vehicleToStartLatitudeDistance = startLatitude - vehicleLatitude;
        double startToEndLongitudeDistance = endLongitude - startLongitude;
        double startToEndLatitudeDistance = endLatitude - startLatitude;
        double endToVehicleLongitudeDistance = vehicleLongitude - endLongitude;
        double endToVehicleLatitudeDistance = vehicleLatitude - endLatitude;
        double a1 = Math.pow(Math.sin(vehicleToStartLatitudeDistance / 2), 2)
                + Math.cos(vehicleLatitude) * Math.cos(startLatitude)
                * Math.pow(Math.sin(vehicleToStartLongitudeDistance / 2),2);
        double a2 = Math.pow(Math.sin(startToEndLatitudeDistance / 2), 2)
                + Math.cos(startLatitude) * Math.cos(endLatitude)
                * Math.pow(Math.sin(startToEndLongitudeDistance / 2),2);
        double a3 = Math.pow(Math.sin(endToVehicleLatitudeDistance / 2), 2)
                + Math.cos(endLatitude) * Math.cos(vehicleLatitude)
                * Math.pow(Math.sin(endToVehicleLongitudeDistance / 2),2);

        double c1 = 2 * Math.asin(Math.sqrt(a1));
        double c2 = 2 * Math.asin(Math.sqrt(a2));
        double c3 = 2 * Math.asin(Math.sqrt(a3));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r1 = c1 * 3956;
        double r2 = c2 * 3956;
        double r3 = c3 * 3956;

        double totalCost = r1 + r2 + r3;
        totalCost = totalCost * costPerMiles;
        // calculate the result
        return totalCost;
    }

    public static boolean checkAvailability(LocalDateTime localDateTime, Vehicle vehicle){
        if(bookings.size() == 0)
        {
            return true;
        }
        for(Booking booking: bookings){
            if(booking.getVehicleID() == vehicle.getId() && booking.getBookingDate().equals(localDateTime)){
                return false;
            }
        }
        return true;
    }

    public static void displayAllCurrentBookings(){
        if(bookings.size() == 0){
            System.out.println("Bookings List Is Empty.");
            return;
        }
        ArrayList<Booking> sortedInIncreasingDateOrder = sortInIncreasingDateOrder();
        for(Booking booking: sortedInIncreasingDateOrder){
            System.out.println("Booking Id: " + booking.getId());
            System.out.println("Passenger Id: " + booking.getPassengerID());
            System.out.println("Vehicle Id: " + booking.getVehicleID());
            String date = booking.getBookingDate().format(Main.format);
            System.out.println("Booking Date And Time: " + date);
            System.out.println("Booking Starting Latitude: " + booking.getStartLatitude());
            System.out.println("Booking Starting Longitude: " + booking.getStartLongitude());
            System.out.println("Booking Ending Latitude: " + booking.getEndLatitude());
            System.out.println("Booking Ending Longitude: " + booking.getEndLongitude());
        }
    }

    public static ArrayList<Booking> sortInIncreasingDateOrder() {
        ArrayList<Booking> sortedBookingsList = new ArrayList<>();
        LocalDateTime localDateTime = LocalDateTime.now();
        for(Booking booking: bookings){
            if(booking.getBookingDate().isAfter(localDateTime)){
                sortedBookingsList.add(booking);
            }
        }
        Collections.sort(sortedBookingsList, new Comparator<Booking>() {
            @Override
            public int compare(Booking o1, Booking o2) {
                int result = o1.getBookingDate().compareTo(o2.getBookingDate());
                return result;
            }
        });
        return sortedBookingsList;
    }

}

