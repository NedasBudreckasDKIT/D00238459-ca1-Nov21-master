public class Booking {
    private static int count = 0;
    private int id;
    private String bookingDate;
    private double startLatitude;
    private double startLongitude;
    private double endLatitude;
    private double endLongitude;
    private double cost;
    private int vehicleID;
    private int passengerID;

    public void setStartLatitude(double startLatitude) {
        this.startLatitude = startLatitude;
    }

    public void setStartLongitude(double startLongitude) {
        this.startLongitude = startLongitude;
    }

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

    public Booking(String bookingDate, double startLatitude, double startLongitude, double cost, double endLatitude, double endLongitude, int vehicleID, int passengerID) {
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

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(float startLatitude) {
        this.startLatitude = startLatitude;
    }

    public double getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(float startLongitude) {
        this.startLongitude = startLongitude;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
