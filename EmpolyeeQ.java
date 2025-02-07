
class Employee {
    protected String name;
    protected int id;
    protected double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: " + salary);
    }
}
class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}
class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}
class Intern extends Employee {
    private String university;

    public Intern(String name, int id, double salary, String university) {
        super(name, id, salary);
        this.university = university;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("University: " + university);
    }
}

public class EmpolyeeQ {
    public static void main(String[] args) {
        Manager manager = new Manager("Alice", 101, 80000, 5);
        Developer developer = new Developer("Bob", 102, 60000, "Java");
        Intern intern = new Intern("Charlie", 103, 20000, "XYZ University");

        System.out.println("Manager Details:");
        manager.displayDetails();
        System.out.println();

        System.out.println("Developer Details:");
        developer.displayDetails();
        System.out.println();

        System.out.println("Intern Details:");
        intern.displayDetails();
    }
}

