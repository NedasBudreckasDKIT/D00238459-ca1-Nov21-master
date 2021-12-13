public abstract class Vehicle {
    private String make;
    private String model;
    private double milesPerKWH;
    private String registrationNumber;
    private int costPerMiles;
    private String lastServicedDate;
    private int mileage;
    private double depotLatitude;
    private double depotLongitude;
    private String type;
    private int id;
    private static int count = 0;

    public int getCostPerMiles() {
        return costPerMiles;
    }

    public void setCostPerMiles(int costPerMiles) {
        this.costPerMiles = costPerMiles;
    }

    public void setDepotLatitude(double depotLatitude) {
        this.depotLatitude = depotLatitude;
    }

    public void setDepotLongitude(double depotLongitude) {
        this.depotLongitude = depotLongitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle(String make, String model, double milesPerKWH, String registrationNumber, String lastServicedDate, int mileage, double depotLatitude, double depotLongitude, String type) {
        this.make = make;
        this.model = model;
        this.milesPerKWH = milesPerKWH;
        this.registrationNumber = registrationNumber;
        this.lastServicedDate = lastServicedDate;
        this.mileage = mileage;
        this.depotLatitude = depotLatitude;
        this.depotLongitude = depotLongitude;
        this.type = type;
        Vehicle.count++;
        this.id = count;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getMilesPerKWH() {
        return milesPerKWH;
    }

    public void setMilesPerKWH(double milesPerKWH) {
        this.milesPerKWH = milesPerKWH;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getLastServicedDate() {
        return lastServicedDate;
    }

    public void setLastServicedDate(String lastServicedDate) {
        this.lastServicedDate = lastServicedDate;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getDepotLatitude() {
        return depotLatitude;
    }

    public void setDepotLatitude(float depotLatitude) {
        this.depotLatitude = depotLatitude;
    }

    public double getDepotLongitude() {
        return depotLongitude;
    }

    public void setDepotLongitude(float depotLongitude) {
        this.depotLongitude = depotLongitude;
    }

    public String getObjectStr() {
        return this.getType() + "," + this.getMake() + "," +
                this.getModel() + "," + this.getMilesPerKWH() + "," + this.getRegistrationNumber() + "," +
                this.getCostPerMiles() + "," + this.getLastServicedDate() + "," + this.getMileage() + "," +
                this.getDepotLatitude() + "," + this.getDepotLongitude();
    }

}
