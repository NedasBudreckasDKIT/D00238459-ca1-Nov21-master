package org.example.src;

public class Van extends Vehicle {
    private int loadSpace;

    public Van(String make, String model, double milesPerKWH, String registrationNumber, String lastServicedDate, int mileage, double depotLatitude, double depotLongitude, String type, int loadSpace) {
        super(make, model, milesPerKWH, registrationNumber, lastServicedDate, mileage, depotLatitude, depotLongitude, type);
        this.loadSpace = loadSpace;
        if (this.getType().equals("Van") || this.getType().equals("van")) {
            this.setCostPerMiles(6);
        } else if (this.getType().equals("Truck") || this.getType().equals("truck")) {
            this.setCostPerMiles(10);
        }
    }

    public int getLoadSpace() {
        return loadSpace;
    }

    public void setLoadSpace(int loadSpace) {
        this.loadSpace = loadSpace;
    }

    @Override
    public String toString() {
        return "Vehicle ID: " + this.getId() + "\n" +
                "Vehicle Type: " + this.getType() + "\n" +
                "Vehicle Make: " + this.getMake() + "\n" +
                "Vehicle Model: " + this.getModel() + "\n" +
                "Vehicle Miles Per KWH: " + this.getMilesPerKWH() + "\n" +
                "Vehicle Registration Number: " + this.getRegistrationNumber() + "\n" +
                "Vehicle Cost Per Mile: " + this.getCostPerMiles() + "\n" +
                "Vehicle Last Service Date: " + this.getLastServicedDate() + "\n" +
                "Vehicle Mileage: " + this.getMileage() + "\n" +
                "Vehicle Depot Latitude: " + this.getDepotLatitude() + "\n" +
                "Vehicle Depot Longitude: " + this.getDepotLongitude() + "\n" +
                "Vehicle Load Space: " + this.getLoadSpace() + "\n";
    }

    public String getObjectStr(){
        return super.getObjectStr() + "," + this.getLoadSpace() + "\n";
    }
}
