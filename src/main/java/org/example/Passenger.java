public class Passenger {
    private int id;
    private String name;
    private String email;
    private String phone;
    private LocationGPS location;  // Home location

    public Passenger(String name, String email, String phone, double latitude, double longitude) {
        this.id = IdGenerator.getInstance("src/next-id-store.txt").getNextId();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.location = new LocationGPS(latitude, longitude);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocationGPS getLocation() {
        return location;
    }

    public void setLocation(LocationGPS location) {
        this.location = location;
    }

    public String getObjectStr() {
        return this.name + "," + this.email + "," + this.phone + "," + this.location.getLatitude() + "," + this.location.getLongitude() + "\n";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " id = " + id +
                ", name = " + name +
                ", email = " + email +
                ", phone = " + phone +
                ", location = " + location;
    }

    @Override
    public boolean equals(Object obj) {
        Passenger passenger = (Passenger) obj;
        return this.getName().equals(passenger.getName());
    }
}
