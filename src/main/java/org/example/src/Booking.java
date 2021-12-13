import java.time.LocalDateTime;
public class Booking {
    //Our Booking Class Required Class Members
    private static int count = 0;
    private int id;
    private LocalDateTime bookingDate;
    private double startLatitude;
    private double startLongitude;
    private double endLatitude;
    private double endLongitude;
    private double cost;
    private int vehicleID;
    private int passengerID;

    public double getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(double endLatitude) {
        this.endLatitude = endLatitude;
    }

    public double getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(double endLongitude) {
        this.endLongitude = endLongitude;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public Booking(LocalDateTime bookingDate, double startLatitude, double startLongitude, double cost, double endLatitude, double endLongitude, int vehicleID, int passengerID) {
        this.bookingDate = bookingDate;
        this.startLatitude = startLatitude;
        this.startLongitude = startLongitude;
        this.endLatitude = endLatitude;
        this.endLongitude = endLongitude;
        this.cost = cost;
        this.vehicleID = vehicleID;
        this.passengerID = passengerID;
        Booking.count++;
        id = count;
    }

    //Required Getters And Setters
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Booking.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getStartLatitude() {
        return startLatitude;
    }

    public double getStartLongitude() {
        return startLongitude;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    //To String Method Which Formats Our Object Before Printing
    @Override
    public String toString() {
        String date = this.getBookingDate().format(Main.format);
        return "Booking Id: "+this.getId() + "\n"+
                "Passenger Id: "+ this.getPassengerID() + "\n"+
                "Vehicle Id: "+ this.getVehicleID() + "\n"+
                "Booking Date And Time: "+ date + "\n"+
                "Booking Starting Latitude: "+ this.getStartLatitude()+ "\n"+
                "Booking Starting Longitude: "+ this.getStartLongitude()+ "\n"+
                "Booking Ending Latitude: "+ this.getEndLatitude()+ "\n"+
                "Booking Ending Longitude: "+ this.getEndLongitude() + "\n"+
                "Booking Cost: "+ this.getCost() + "\n";
    }

    public String getObjectStr() {
        return this.getPassengerID() + "," +
                this.getVehicleID() + "," + this.getBookingDate() + "," +
                this.getStartLatitude() + "," + this.getStartLongitude() + "," +
                this.getEndLatitude() + "," + this.getEndLongitude() + "," +
                this.getCost() + "\n";
    }
}
