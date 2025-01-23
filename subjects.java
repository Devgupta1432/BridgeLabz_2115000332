import java.util.Scanner;
public class subjects {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter marks for Physics: ");
        int physics = scanner.nextInt();
        System.out.print("Enter marks for Chemistry: ");
        int chemistry = scanner.nextInt();
        System.out.print("Enter marks for Maths: ");
        int maths = scanner.nextInt();
        int totalMarks = physics + chemistry + maths;
        double percentage = (totalMarks / 3.0);
        String grade;
        if (percentage >= 80) {
            grade = "A (Level 4, above agency-normalized standards)";
        } else if (percentage >= 70) {
            grade = "B (Level 3, at agency-normalized standards)";
        } else if (percentage >= 60) {
            grade = "C (Level 2, below but approaching agency-normalized standards)";
        } else if (percentage >= 50) {
            grade = "D (Level 1, well below agency-normalized standards)";
        } else if (percentage >= 40) {
            grade = "E (Level 1-, too below agency-normalized standards)";
        } else {
            grade = "R (Remedial standards)";
        }
        System.out.println("\nResults:");
        System.out.printf("Physics: %d, Chemistry: %d, Maths: %d%n", physics, chemistry, maths);
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
