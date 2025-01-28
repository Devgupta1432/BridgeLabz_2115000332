import java.util.Scanner;
public class student {
    public boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }
        return age >= 18; 
    }
    public static void main(String[] args){
        student checker = new student();
        Scanner scanner = new Scanner(System.in);
        int[] studentAges = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter the age of student " + (i + 1) + ": ");
            studentAges[i] = scanner.nextInt();
            if (checker.canStudentVote(studentAges[i])) {
                System.out.println("Student " + (i + 1) + " can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " cannot vote.");
            }
        }
        scanner.close();
    }
}
