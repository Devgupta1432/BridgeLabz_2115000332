import java.util.Scanner;
public class student1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[][] marks = new int[n][3];
        double[] percentage = new double[n];
        char[] grade = new char[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Physics, Chemistry, Maths marks: ");
            marks[i][0] = sc.nextInt();
            marks[i][1] = sc.nextInt();
            marks[i][2] = sc.nextInt();
            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            grade[i] = percentage[i] >= 90 ? 'A' : percentage[i] >= 75 ? 'B' : percentage[i] >= 50 ? 'C' : 'D';
        }
        for (int i = 0; i < n; i++) System.out.println("Percentage: " + percentage[i] + ", Grade: " + grade[i]);
    }
}
