public class Truck extends Vehicle {
    private double loadSpace;

    public Truck(String make, String model, int milesPerKM, int numOfSeats, String registrationNum,
                 String lastServiceDate, double mileage, double latitude, double longitude, double loadSpace) {
        super(make, model, milesPerKM, numOfSeats, registrationNum, 6.00, lastServiceDate, mileage, latitude,
                longitude);
        this.loadSpace = loadSpace;
    }

    public String getObjectStr() {
        return "Truck," + super.getObjectStr() + "," + this.loadSpace;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " loadSpace=" + loadSpace +
                super.toString();
    }
}
