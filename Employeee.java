class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void modifySalary(double newSalary) {
        if (newSalary > 0) {
            salary = newSalary;
            System.out.println("Salary updated to: $" + newSalary);
        } else {
            System.out.println("Invalid salary amount.");
        }
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}

class Manager extends Employee {

    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayManagerDetails() {
        System.out.println("Manager Details:");
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + getSalary()); 
    }
}

public class Employeee {
    public static void main(String[] args) {
        Employee employee1 = new Employee(101, "Marketing", 50000.0);
        employee1.displayEmployeeDetails();
        employee1.modifySalary(55000);
        employee1.displayEmployeeDetails();

        System.out.println("\nManager Details:");
        Manager manager1 = new Manager(102, "Sales", 80000.0);
        manager1.displayManagerDetails();
    }
}
