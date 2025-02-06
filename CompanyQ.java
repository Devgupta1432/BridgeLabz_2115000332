import java.util.ArrayList;

class Company {
    private String name;
    private ArrayList<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addEmployee(String departmentName, String employeeName) {
        for (Department dept : departments) {
            if (dept.getName().equals(departmentName)) {
                dept.addEmployee(employeeName);
                return;
            }
        }
        System.out.println("Department not found: " + departmentName);
    }

    public void displayCompanyDetails() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.displayDepartmentDetails();
        }
        System.out.println();
    }

    private class Department {
        private String name;
        private ArrayList<Employee> employees;

        public Department(String name) {
            this.name = name;
            this.employees = new ArrayList<>();
        }

        public void addEmployee(String employeeName) {
            employees.add(new Employee(employeeName));
        }

        public void displayDepartmentDetails() {
            System.out.println("Department: " + name);
            for (Employee emp : employees) {
                System.out.println("- Employee: " + emp.getName());
            }
        }

        public String getName() {
            return name;
        }

        private class Employee {
            private String name;

            public Employee(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }
    }
}

public class CompanyQ {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        company.addDepartment("IT");
        company.addDepartment("HR");

        company.addEmployee("IT", "Alice");
        company.addEmployee("IT", "Bob");
        company.addEmployee("HR", "Charlie");

        company.displayCompanyDetails();
    }
}
