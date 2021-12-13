import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private FileWriter bookingsWriter;
    private FileWriter passengersWriter;
    private FileWriter vehiclesWriter;

    public void writeBookings(){
        try {
            bookingsWriter = new FileWriter("bookings.txt");
            for (Booking booking : BookingsManager.bookings) {
                bookingsWriter.write(booking.getObjectStr());
            }
            bookingsWriter.close();
        } catch (IOException e) {
            System.out.println("Error Writing Bookings File...");
        }
    }

    public void writePassengers(){
        try {
            passengersWriter = new FileWriter("passengers.txt");
            for (Passenger passenger : PassengerManager.passengers) {
                passengersWriter.write(passenger.getObjectStr());
            }
            passengersWriter.close();
        } catch (IOException e) {
            System.out.println("Error Writing Passengers File...");
        }
    }

    public void writeVehicles(){
        try {
            vehiclesWriter = new FileWriter("vehicles.txt");
            for (Vehicle vehicle : VehiclesManager.fleet) {
                if (vehicle.getType().equals("Car") || vehicle.getType().equals("car") || vehicle.getType().equals("4x4") || vehicle.getType().equals("4*4")) {
                    Car car = findCar(vehicle.getId());
                    vehiclesWriter.write(car.getObjectStr());
                } else if (vehicle.getType().equals("Van") || vehicle.getType().equals("van") || vehicle.getType().equals("Truck") || vehicle.getType().equals("truck")) {
                    Van van = findVan(vehicle.getId());
                    vehiclesWriter.write(van.getObjectStr());
                }
            }
            vehiclesWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing Vehicles File...");
        }
    }

    public Car findCar(int vehicleID){
        for(Car car: VehiclesManager.cars){
            if(car.getId() == vehicleID){
                return car;
            }
        }
        return null;
    }

    public Van findVan(int vehicleID){
        for(Van van: VehiclesManager.vans){
            if(van.getId() == vehicleID){
                return van;
            }
        }
        return null;
    }

}
