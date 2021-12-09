public class Car extends Vehicle {
    public Car(String make, String model, int milesPerKM, int numOfSeats, String registrationNum, String lastServiceDate, double mileage, double latitude, double longitude) {
        super(make, model, milesPerKM, numOfSeats, registrationNum, 2.00, lastServiceDate, mileage, latitude,
                longitude);
    }

    public String getObjectStr() {
        return "Car," + super.getObjectStr();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + super.toString();
    }
}