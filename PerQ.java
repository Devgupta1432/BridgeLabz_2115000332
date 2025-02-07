
class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayRole() {
        System.out.println("I am a person.");
    }
}
class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);         this.subject = subject;
    }

    
    public void displayRole() {
        System.out.println("I am a teacher. I teach " + subject + ".");
    }
}


class Student extends Person {
    private String grade;

    public Student(String name, int age, String grade) {
        super(name, age);          this.grade = grade;
    }

    
    public void displayRole() {
        System.out.println("I am a student. I am in grade " + grade + ".");
    }
}

class Staff extends Person {
    private String position;

    public Staff(String name, int age, String position) {
        super(name, age); 
        this.position = position;
    }

    
    public void displayRole() {
        System.out.println("I am a staff member. My position is " + position + ".");
    }
}

public class PerQ {
    public static void main(String[] args) {

        Person teacher = new Teacher("Mr. Smith", 40, "Mathematics");
        Person student = new Student("Alice", 16, "10th");
        Person staff = new Staff("Mr. Johnson", 35, "Janitor");


        System.out.println("Teacher Info:");
        teacher.displayRole();
        System.out.println();

        System.out.println("Student Info:");
        student.displayRole();
        System.out.println();

        System.out.println("Staff Info:");
        staff.displayRole();
    }
}
