public abstract class Vehicle {
    protected int id;
    protected String make;
    protected String model;
    protected int milesPerKM;
    protected int numOfSeats;
    protected String registrationNum;
    protected double costPerMile;
    protected String lastServiceDate;
    protected double mileage;
    protected LocationGPS location;

    public Vehicle(String make, String model, int milesPerKM, int numOfSeats, String registrationNum,
                   double costPerMile, String lastServiceDate, double mileage, double latitude, double longitude) {
        this.id = IdGenerator.getInstance("src/next-id-store.txt").getNextId();
        this.make = make;
        this.model = model;
        this.milesPerKM = milesPerKM;
        this.numOfSeats = numOfSeats;
        this.registrationNum = registrationNum;
        this.costPerMile = costPerMile;
        this.lastServiceDate = lastServiceDate;
        this.mileage = mileage;
        this.location = new LocationGPS(latitude, longitude);
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

    public int getMilesPerKM() {
        return milesPerKM;
    }

    public void setMilesPerKM(int milesPerKM) {
        this.milesPerKM = milesPerKM;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public String getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    public double getCostPerMile() {
        return costPerMile;
    }

    public void setCostPerMile(double costPerMile) {
        this.costPerMile = costPerMile;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public LocationGPS getLocation() {
        return location;
    }

    public void setLocation(LocationGPS location) {
        this.location = location;
    }

    public String getObjectStr() {
        return this.getMake() + "," + this.getModel() + "," + this.getMilesPerKM() + "," + this.getNumOfSeats() +
                "," + this.getRegistrationNum()
                + "," + this.getLastServiceDate() + "," + this.getMileage() + "," + this.getLocation().getLatitude() + "," + this.getLocation().getLongitude();
    }

    @Override
    public boolean equals(Object o) {
        Vehicle vehicle = (Vehicle) o;
        return this.id == vehicle.id;
    }

    @Override
    public String toString() {
        return " make = " + make +
                ", model= " + model +
                ", milesPerKM = " + milesPerKM +
                ", numOfSeats = " + numOfSeats +
                ", registrationNum = " + registrationNum +
                ", costPerMile = " + costPerMile +
                ", lastServiceDate = " + lastServiceDate +
                ", mileage =" + mileage +
                ", location =" + location;
    }
}
