import java.util.Scanner;
public class student {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[][] marks = new int[n][3];
       double[] perc = new double[n];
       String[] grade = new String[n];
       for (int i = 0; i < n; i++) {
           marks[i][0] = sc.nextInt();
           marks[i][1] = sc.nextInt();
           marks[i][2] = sc.nextInt();
       }
       for (int i = 0; i < n; i++) {
           perc[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
           if (perc[i] >= 90) grade[i] = "A";
           else if (perc[i] >= 80) grade[i] = "B";
           else if (perc[i] >= 70) grade[i] = "C";
           else if (perc[i] >= 60) grade[i] = "D";
           else grade[i] = "F";
       }
       for (int i = 0; i < n; i++) {
           System.out.println(marks[i][0] + " " + marks[i][1] + " " + marks[i][2] + " " + perc[i] + " " + grade[i]);
       }
   }
}
