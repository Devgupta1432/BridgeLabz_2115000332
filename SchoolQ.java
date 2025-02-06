import java.util.ArrayList;

class School {
    private String name;
    private ArrayList<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("Students in " + name + ":");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
}

class Student {
    private String name;
    private ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);
        }
    }

    public void viewEnrolledCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println("- " + course.getCourseName());
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
}

class Course {
    private String courseName;
    private ArrayList<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void displayEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
        System.out.println();
    }

    public String getCourseName() {
        return courseName;
    }
}

public class SchoolQ {
    public static void main(String[] args) {
        School school = new School("Greenwood High");

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Science");

        school.enrollStudent(student1);
        school.enrollStudent(student2);

        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course1);

        school.displayStudents();
        student1.viewEnrolledCourses();
        student2.viewEnrolledCourses();
        course1.displayEnrolledStudents();
        course2.displayEnrolledStudents();
    }
}
