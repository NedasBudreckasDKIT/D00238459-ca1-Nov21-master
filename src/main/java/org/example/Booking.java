import java.util.Objects;

public class Booking {
    private int bookingID;
    private String bookingDateTime;
    private LocationGPS startLocation;
    private LocationGPS endLocation;
    private double cost;

    public Booking(String bookingDateTime, double startLatitude, double startLongitude,
                   double endLatitude, double endLongitude, double cost) {
        this.bookingID = IdGenerator.getInstance("src/next-id-store.txt").getNextId();
        this.bookingDateTime = bookingDateTime;
        this.startLocation = new LocationGPS(startLatitude, startLongitude);
        this.endLocation = new LocationGPS(endLatitude, endLongitude);
        this.cost = cost;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(String bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public LocationGPS getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(LocationGPS startLocation) {
        this.startLocation = startLocation;
    }

    public LocationGPS getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(LocationGPS endLocation) {
        this.endLocation = endLocation;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getObjectStr() {
        return this.getBookingDateTime() + "," + this.getStartLocation().getLatitude() + "," +
                this.getStartLocation().getLongitude() + "," + this.getEndLocation().getLatitude() + "," +
                this.getEndLocation().getLongitude() + "," + this.getCost() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return bookingID == booking.bookingID && Double.compare(booking.cost, cost) == 0 && Objects.equals(bookingDateTime, booking.bookingDateTime) && Objects.equals(startLocation, booking.startLocation) && Objects.equals(endLocation, booking.endLocation);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " bookingID = " + bookingID +
                ", bookingDateTime = " + bookingDateTime +
                ", startLocation = " + startLocation +
                ", endLocation = " + endLocation +
                ", cost = " + cost;
    }
}

