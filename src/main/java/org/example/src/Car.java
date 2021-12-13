package org.example.src;

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

    @Override
    public String toString() {
        return "Vehicle ID: "+ this.getId() + "\n" +
                "Vehicle Type: "+ this.getType() + "\n" +
                "Vehicle Make: "+ this.getMake() + "\n" +
                "Vehicle Model: "+ this.getModel() + "\n" +
                "Vehicle Miles Per KWH: "+ this.getMilesPerKWH() + "\n" +
                "Vehicle Registration Number: "+ this.getRegistrationNumber() + "\n" +
                "Vehicle Cost Per Mile: "+ this.getCostPerMiles() + "\n" +
                "Vehicle Last Service Date: "+ this.getLastServicedDate() + "\n" +
                "Vehicle Mileage: "+ this.getMileage() + "\n" +
                "Vehicle Depot Latitude: "+ this.getDepotLatitude() + "\n" +
                "Vehicle Depot Longitude: "+ this.getDepotLongitude() + "\n" +
                "Vehicle Number Of Seats: "+ this.getNumberOfSeats() + "\n";
    }

    public String getObjectStr(){
        return super.getObjectStr() + "," + this.getNumberOfSeats() + "\n";
    }
}
