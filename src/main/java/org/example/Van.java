public class Van extends Vehicle {
    private double loadSpace;

    public Van(String make, String model, int milesPerKM, int numOfSeats, String registrationNum, String lastServiceDate,
               double mileage, double latitude, double longitude, double loadSpace) {
        super(make, model, milesPerKM, numOfSeats, registrationNum, 6.00, lastServiceDate, mileage, latitude,
                longitude);
        this.loadSpace = loadSpace;
    }

    public String getObjectStr() {
        return "Van," + super.getObjectStr() + "," + this.loadSpace;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " loadSpace=" + loadSpace +
                super.toString();
    }
}