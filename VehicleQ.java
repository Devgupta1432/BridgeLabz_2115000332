class Vehicle {
    protected int maxSpeed;
    protected String fuelType;

    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed + " km/h, Fuel Type: " + fuelType);
    }
}
class Car extends Vehicle {
    private int seatCapacity;

    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

class Truck extends Vehicle {
    private double payloadCapacity;

    public Truck(int maxSpeed, String fuelType, double payloadCapacity) {
        super(maxSpeed, fuelType);
        this.payloadCapacity = payloadCapacity;
    }

    
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Payload Capacity: " + payloadCapacity + " tons");
    }
}

class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(int maxSpeed, String fuelType, boolean hasSidecar) {
        super(maxSpeed, fuelType);
        this.hasSidecar = hasSidecar;
    }

    
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
}

public class VehicleQ {
    public static void main(String[] args) {
        Vehicle car = new Car(180, "Petrol", 5);
        Vehicle truck = new Truck(120, "Diesel", 10.5);
        Vehicle motorcycle = new Motorcycle(150, "Petrol", true);


        Vehicle[] vehicles = {car, truck, motorcycle};


        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            System.out.println();
        }
    }
}
