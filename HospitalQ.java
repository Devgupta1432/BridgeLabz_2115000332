import java.util.ArrayList;

class Hospital {
    private String name;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void displayDoctors() {
        System.out.println("Doctors in " + name + ":");
        for (Doctor doctor : doctors) {
            System.out.println("- " + doctor.getName());
        }
        System.out.println();
    }

    public void displayPatients() {
        System.out.println("Patients in " + name + ":");
        for (Patient patient : patients) {
            System.out.println("- " + patient.getName());
        }
        System.out.println();
    }
}

class Doctor {
    private String name;
    private ArrayList<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this);
        }
        System.out.println("Dr. " + name + " is consulting " + patient.getName());
    }

    public void displayPatients() {
        System.out.println("Patients of Dr. " + name + ":");
        for (Patient patient : patients) {
            System.out.println("- " + patient.getName());
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
}

class Patient {
    private String name;
    private ArrayList<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void displayDoctors() {
        System.out.println(name + " has consulted with:");
        for (Doctor doctor : doctors) {
            System.out.println("- Dr. " + doctor.getName());
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
}

public class HospitalQ {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor doctor1 = new Doctor("Smith");
        Doctor doctor2 = new Doctor("Johnson");

        Patient patient1 = new Patient("Alice");
        Patient patient2 = new Patient("Bob");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        doctor1.consult(patient1);
        doctor1.consult(patient2);
        doctor2.consult(patient1);

        hospital.displayDoctors();
        hospital.displayPatients();

        doctor1.displayPatients();
        doctor2.displayPatients();

        patient1.displayDoctors();
        patient2.displayDoctors();
    }
}