class Vehicle {
    private static double registrationFee = 500.0;

    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
            System.out.println("-------------------------");
        }
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void displayRegistrationFee() {
        System.out.println("Current Registration Fee: $" + registrationFee);
    }
}

public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("John Doe", "Car", "XYZ123");
        Vehicle vehicle2 = new Vehicle("Jane Smith", "Motorcycle", "ABC456");

        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();

        Vehicle.displayRegistrationFee();
        Vehicle.updateRegistrationFee(600.0);
        Vehicle.displayRegistrationFee();

        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}
