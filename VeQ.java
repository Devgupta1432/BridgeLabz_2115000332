import java.util.Random;

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver: " + driverName);
        System.out.println("Rate per Km: $" + ratePerKm);
    }

    public double getRatePerKm() {
        return ratePerKm;
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class Car extends Vehicle implements GPS {
    private String location;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    
    public String getCurrentLocation() {
        return location;
    }

    
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

class Bike extends Vehicle implements GPS {
    private String location;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.9;
    }

    
    public String getCurrentLocation() {
        return location;
    }

    
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

class Auto extends Vehicle implements GPS {
    private String location;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 1.1;
    }

    
    public String getCurrentLocation() {
        return location;
    }

    
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

public class VeQ {
    public static void processRide(Vehicle vehicle, double distance) {
        vehicle.getVehicleDetails();
        System.out.println("Fare for " + distance + " km: $" + vehicle.calculateFare(distance));

        if (vehicle instanceof GPS) {
            GPS gpsVehicle = (GPS) vehicle;
            String newLocation = "Location " + new Random().nextInt(100);
            gpsVehicle.updateLocation(newLocation);
            System.out.println("Updated Location: " + gpsVehicle.getCurrentLocation());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Vehicle car = new Car("C123", "John Doe", 5.0);
        Vehicle bike = new Bike("B456", "Jane Smith", 3.0);
        Vehicle auto = new Auto("A789", "Raj Kumar", 4.0);

        Vehicle[] rides = {car, bike, auto};

        for (Vehicle ride : rides) {
            processRide(ride, 10);
        }
    }
}
