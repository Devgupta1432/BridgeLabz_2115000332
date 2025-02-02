class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "Default Institute";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " days");
        System.out.println("Fee: $" + fee);
        System.out.println("Institute: " + instituteName);
    }

    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    public static void main(String[] args) {
        Course course1 = new Course("Java Programming", 30, 300);
        Course course2 = new Course("Web Development", 45, 500);

        System.out.println("Before updating institute name:");
        course1.displayCourseDetails();
        course2.displayCourseDetails();

        Course.updateInstituteName("Advanced Learning Institute");

        System.out.println("\nAfter updating institute name:");
        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}
