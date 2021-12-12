public class Car extends Vehicle {
    private int numberOfSeats;
    public Car(String make, String model, double milesPerKWH, String registrationNumber, String lastServicedDate, int mileage, double depotLatitude, double depotLongitude, String type, int numberOfSeats) {
        super(make, model, milesPerKWH, registrationNumber, lastServicedDate, mileage, depotLatitude, depotLongitude, type);
        this.numberOfSeats = numberOfSeats;
        if(this.getType().equals("Car") || this.getType().equals("car")){
            this.setCostPerMiles(2);
        }
        else if(this.getType().equals("4x4") || this.getType().equals("4*4")){
            this.setCostPerMiles(4);
        }
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
