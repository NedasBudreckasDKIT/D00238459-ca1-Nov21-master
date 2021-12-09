public class FourByFour extends Vehicle {
    public FourByFour(String make, String model, int milesPerKM, int numOfSeats, String registrationNum, String lastServiceDate, double mileage, double latitude, double longitude) {
        super(make, model, milesPerKM, numOfSeats, registrationNum, 4.00, lastServiceDate, mileage, latitude,
                longitude);
    }

    public String getObjectStr() {
        return "FourByFour," + super.getObjectStr();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + super.toString();
    }
}
