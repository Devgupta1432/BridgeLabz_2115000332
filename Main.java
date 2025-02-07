
class Course {
    protected String courseName;
    protected int duration;

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

class OnlineCourse extends Course {
    private String platform;
    private boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration); 
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    
    public void displayInfo() {
        super.displayInfo();         System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);         this.fee = fee;
        this.discount = discount;
    }

    
    public void displayInfo() {
        super.displayInfo();        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
    }
}

public class Main {
    public static void main(String[] args) {
               Course course = new Course("Basic Java Programming", 40);
        OnlineCourse onlineCourse = new OnlineCourse("Advanced Python Programming", 50, "Udemy", true);
        PaidOnlineCourse paidOnlineCourse = new PaidOnlineCourse("Full Stack Web Development", 100, "Coursera", true, 299.99, 20);
        System.out.println("Course Information:");
        course.displayInfo();
        System.out.println();

        System.out.println("Online Course Information:");
        onlineCourse.displayInfo();
        System.out.println();

        System.out.println("Paid Online Course Information:");
        paidOnlineCourse.displayInfo();
    }
}
