abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate: $" + rentalRate + " per day");
    }

    public double getRentalRate() {
        return rentalRate;
    }
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    
    public double calculateInsurance() {
        return getRentalRate() * 0.1;
    }

    
    public String getInsuranceDetails() {
        return "Car insurance applied.";
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
}

class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.2;
    }

    
    public double calculateInsurance() {
        return getRentalRate() * 0.15;
    }

    
    public String getInsuranceDetails() {
        return "Truck insurance applied.";
    }
}

public class VehQ {
    public static void calculateTotalCost(Vehicle vehicle, int days) {
        double rentalCost = vehicle.calculateRentalCost(days);
        double insuranceCost = vehicle instanceof Insurable ? ((Insurable) vehicle).calculateInsurance() : 0;

        vehicle.displayDetails();
        System.out.println("Rental Cost for " + days + " days: $" + rentalCost);
        if (vehicle instanceof Insurable) {
            System.out.println("Insurance Cost: $" + insuranceCost);
            System.out.println(((Insurable) vehicle).getInsuranceDetails());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Vehicle car = new Car("C1234", 50, "INS123");
        Vehicle bike = new Bike("B5678", 20);
        Vehicle truck = new Truck("T9101", 100, "INS789");

        Vehicle[] vehicles = {car, bike, truck};

        for (Vehicle vehicle : vehicles) {
            calculateTotalCost(vehicle, 5);
        }
    }
}
