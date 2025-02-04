class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;

    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(String name, int patientID, int age, String ailment) {
        this.name = name;
        this.patientID = patientID;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient Name: " + name);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
            System.out.println("-------------------------");
        }
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient patient1 = new Patient("Alice", 1001, 30, "Fever");
        Patient patient2 = new Patient("Bob", 1002, 40, "Cough");

        patient1.displayPatientDetails();
        patient2.displayPatientDetails();

        Patient.getTotalPatients();
    }
}
