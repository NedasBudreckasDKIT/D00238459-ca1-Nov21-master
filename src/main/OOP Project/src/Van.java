public class Van extends Vehicle {
    private int loadSpace;

    public Van(String make, String model, double milesPerKWH, String registrationNumber, String lastServicedDate, int mileage, double depotLatitude, double depotLongitude, String type, int loadSpace) {
        super(make, model, milesPerKWH, registrationNumber, lastServicedDate, mileage, depotLatitude, depotLongitude, type);
        this.loadSpace = loadSpace;
        if(this.getType().equals("Van")  || this.getType().equals("van")){
            this.setCostPerMiles(6);
        }
        else if(this.getType().equals("Truck") || this.getType().equals("truck")){
            this.setCostPerMiles(10);
        }
    }
}
