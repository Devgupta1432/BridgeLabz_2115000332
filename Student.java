class Student1 {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student1(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA");
        }
    }

    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

class PostgraduateStudent extends Student1 {

    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    public void displayPostgraduateDetails() {
        System.out.println("Postgraduate Student Details:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);         System.out.println("CGPA: " + getCGPA()); 
    }
}

public class Student {
    public static void main(String[] args) {
        Student1 student1 = new Student1(101, "Alice", 9.1);
        student1.displayStudentDetails();
        student1.setCGPA(9.5);
        System.out.println("\nAfter modifying CGPA:");
        student1.displayStudentDetails();

        System.out.println("\nPostgraduate Student Details:");
        PostgraduateStudent pgStudent = new PostgraduateStudent(102, "Bob", 8.7);
        pgStudent.displayPostgraduateDetails();
    }
}
