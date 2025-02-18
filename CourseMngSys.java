import java.util.ArrayList;
import java.util.List;
abstract class CourseType {
    abstract void evaluationType();
}

class ExamCourse extends CourseType {
    void evaluationType() {
        System.out.println("Evaluation Type: Exam-based");
    }
}

class AssignmentCourse extends CourseType {
    void evaluationType() {
        System.out.println("Evaluation Type: Assignment-based");
    }
}

class ResearchCourse extends CourseType {
    void evaluationType() {
        System.out.println("Evaluation Type: Research-based");
    }
}

class Course<T extends CourseType> {
    T courseType;
    
    Course(T courseType) {
        this.courseType = courseType;
    }

    void displayCourse() {
        courseType.evaluationType();
    }
}

class University {
    void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.evaluationType();
        }
    }
}

public class CourseMngSys {
    public static void main(String[] args) {
        Course<ExamCourse> examCourse = new Course<>(new ExamCourse());
        Course<AssignmentCourse> assignmentCourse = new Course<>(new AssignmentCourse());
        Course<ResearchCourse> researchCourse = new Course<>(new ResearchCourse());
        
        examCourse.displayCourse();
        assignmentCourse.displayCourse();
        researchCourse.displayCourse();
        
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(new ExamCourse());
        allCourses.add(new AssignmentCourse());
        allCourses.add(new ResearchCourse());
        
        University university = new University();
        university.displayAllCourses(allCourses);
    }
}
