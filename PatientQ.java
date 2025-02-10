import java.util.ArrayList;
import java.util.List;

abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;
    private List<String> records;

    public InPatient(int patientId, String name, int age, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
        this.records = new ArrayList<>();
    }

    
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    
    public void addRecord(String record) {
        records.add(record);
    }

    
    public List<String> viewRecords() {
        return records;
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records;

    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.records = new ArrayList<>();
    }

    
    public double calculateBill() {
        return consultationFee;
    }

    
    public void addRecord(String record) {
        records.add(record);
    }

    
    public List<String> viewRecords() {
        return records;
    }
}

public class PatientQ {
    public static void processPatient(Patient patient) {
        patient.getPatientDetails();
        System.out.println("Total Bill: $" + patient.calculateBill());

        if (patient instanceof MedicalRecord) {
            MedicalRecord medicalRecord = (MedicalRecord) patient;
            medicalRecord.addRecord("Initial diagnosis recorded.");
            System.out.println("Medical Records: " + medicalRecord.viewRecords());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Patient inPatient = new InPatient(1, "John Doe", 45, 5, 200);
        Patient outPatient = new OutPatient(2, "Jane Smith", 30, 100);

        Patient[] patients = {inPatient, outPatient};

        for (Patient patient : patients) {
            processPatient(patient);
        }
    }
}
