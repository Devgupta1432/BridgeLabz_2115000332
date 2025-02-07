
class Vehicle {
    protected int maxSpeed;
    protected String model;

    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

interface Refuelable {
    void refuel();
}

class ElectricVehicle extends Vehicle {
    private int batteryCapacity;

    public ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println("Charging the electric vehicle...");
    }

    
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}


class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelTankCapacity;

    public PetrolVehicle(int maxSpeed, String model, int fuelTankCapacity) {
        super(maxSpeed, model);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    
    public void refuel() {
        System.out.println("Refueling the petrol vehicle...");
    }

    
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + " liters");
    }
}

public class EleQ {
    public static void main(String[] args) {

        ElectricVehicle electricCar = new ElectricVehicle(150, "Tesla Model S", 100);
        PetrolVehicle petrolCar = new PetrolVehicle(180, "Ford Mustang", 60);


        System.out.println("Electric Vehicle Info:");
        electricCar.displayInfo();
        electricCar.charge(); 
        System.out.println();

        System.out.println("Petrol Vehicle Info:");
        petrolCar.displayInfo();
        petrolCar.refuel(); 
    }
}
