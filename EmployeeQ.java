abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}

class FullTimeEmployee extends Employee {
    private double overtimeHours;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double overtimeHours) {
        super(employeeId, name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    
    public double calculateSalary() {
        return getBaseSalary() + (overtimeHours * 15);
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
    }

    
    public double calculateSalary() {
        return getBaseSalary() + (hoursWorked * 20);
    }
}

interface Department {
    void assignDepartment(String department);
    String getDepartmentDetails();
}

public class EmployeeQ {
    public static void main(String[] args) {
        Employee emp1 = new FullTimeEmployee(1, "John Doe", 3000, 10);
        Employee emp2 = new PartTimeEmployee(2, "Jane Smith", 2000, 25);

        emp1.displayDetails();
        System.out.println("Salary: $" + emp1.calculateSalary());

        emp2.displayDetails();
        System.out.println("Salary: $" + emp2.calculateSalary());

        Employee[] employees = { emp1, emp2 };

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Salary: $" + emp.calculateSalary());
            System.out.println();
        }
    }
}
