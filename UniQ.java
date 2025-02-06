import java.util.ArrayList;

class University {
    private String name;
    private ArrayList<Department> departments;
    private ArrayList<Faculty> facultyMembers;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    public void assignFacultyToDepartment(String departmentName, Faculty faculty) {
        for (Department dept : departments) {
            if (dept.getName().equals(departmentName)) {
                dept.addFaculty(faculty);
                return;
            }
        }
        System.out.println("Department not found: " + departmentName);
    }

    public void displayUniversityDetails() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (Department dept : departments) {
            dept.displayDepartmentDetails();
        }
        System.out.println("Faculty Members (Not Assigned to Any Department):");
        for (Faculty faculty : facultyMembers) {
            if (!faculty.isAssigned()) {
                System.out.println("- " + faculty.getName());
            }
        }
        System.out.println();
    }

    private class Department {
        private String name;
        private ArrayList<Faculty> facultyMembers;

        public Department(String name) {
            this.name = name;
            this.facultyMembers = new ArrayList<>();
        }

        public void addFaculty(Faculty faculty) {
            facultyMembers.add(faculty);
            faculty.assign();
        }

        public void displayDepartmentDetails() {
            System.out.println("- Department: " + name);
            if (facultyMembers.isEmpty()) {
                System.out.println("  No faculty assigned.");
            } else {
                System.out.println("  Faculty Members:");
                for (Faculty faculty : facultyMembers) {
                    System.out.println("  - " + faculty.getName());
                }
            }
        }

        public String getName() {
            return name;
        }
    }
}

class Faculty {
    private String name;
    private boolean assigned;

    public Faculty(String name) {
        this.name = name;
        this.assigned = false;
    }

    public void assign() {
        this.assigned = true;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public String getName() {
        return name;
    }
}

public class UniQ {
    public static void main(String[] args) {
        University university = new University("Tech University");

        university.addDepartment("Computer Science");
        university.addDepartment("Mechanical Engineering");

        Faculty faculty1 = new Faculty("Dr. Smith");
        Faculty faculty2 = new Faculty("Dr. Johnson");
        Faculty faculty3 = new Faculty("Dr. Williams");

        university.addFaculty(faculty1);
        university.addFaculty(faculty2);
        university.addFaculty(faculty3);

        university.assignFacultyToDepartment("Computer Science", faculty1);
        university.assignFacultyToDepartment("Mechanical Engineering", faculty2);

        university.displayUniversityDetails();
    }
}
