import java.util.ArrayList;

class Student {
    private String name;
    private ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);
            System.out.println(name + " enrolled in " + course.getCourseName());
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

class Professor {
    private String name;
    private ArrayList<Course> courses;

    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.setProfessor(this);
            System.out.println("Professor " + name + " assigned to " + course.getCourseName());
        }
    }

    public void viewAssignedCourses() {
        System.out.println("Courses taught by Professor " + name + ":");
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
    private Professor professor;
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

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not Assigned"));
        System.out.println("Enrolled Students:");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
        System.out.println();
    }

    public String getCourseName() {
        return courseName;
    }
}

public class StuQ {
    public static void main(String[] args) {
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");

        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Physics");

        student1.enrollCourse(course1);
        student1.enrollCourse(course2);
        student2.enrollCourse(course1);

        professor1.assignCourse(course1);
        professor2.assignCourse(course2);

        student1.viewEnrolledCourses();
        student2.viewEnrolledCourses();

        professor1.viewAssignedCourses();
        professor2.viewAssignedCourses();

        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}
