package org.example.src;

public class Passenger {
    private String name;
    private static int count = 0;
    private int id;
    private String email;
    private String telephone;
    private double homeLatitude;
    private double homeLongitude;

    public Passenger(String name, String email, String telephone, double homeLatitude, double homeLongitude) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.homeLatitude = homeLatitude;
        this.homeLongitude = homeLongitude;
        Passenger.count++;
        this.id = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Passenger.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getHomeLatitude() {
        return homeLatitude;
    }

    public void setHomeLatitude(double homeLatitude) {
        this.homeLatitude = homeLatitude;
    }

    public double getHomeLongitude() {
        return homeLongitude;
    }

    public void setHomeLongitude(double homeLongitude) {
        this.homeLongitude = homeLongitude;
    }

    @Override
    public String toString() {
        return "Passenger Name: "+ this.getName()+ "\n"+
        "Passenger ID: "+ this.getId()+ "\n"+
        "Passenger Email: "+ this.getEmail() + "\n" +
        "Passenger Telephone: "+ this.getTelephone() + "\n"+
        "Passenger Latitude: "+ this.getHomeLatitude() + "\n"+
        "Passenger Longitude: "+ this.getHomeLongitude() + "\n";
    }

    public String getObjectStr() {
        return this.getName() + "," + this.getEmail() + "," +
                this.getTelephone() + "," + this.getHomeLatitude() + "," + this.getHomeLongitude() +
                "\n";
    }

}
