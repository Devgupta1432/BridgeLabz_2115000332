import java.util.Scanner;
public class bonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salary = new double[10], years = new double[10], bonus = new double[10], newSalary = new double[10];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter salary: ");
            salary[i] = sc.nextDouble();
            System.out.print("Enter years of service: ");
            years[i] = sc.nextDouble();
            if (salary[i] <= 0 || years[i] < 0) i--;
        }
        for (int i = 0; i < 10; i++) {
            bonus[i] = years[i] > 5 ? salary[i] * 0.05 : salary[i] * 0.02;
            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }
        System.out.println("Total Bonus: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
    }
}
