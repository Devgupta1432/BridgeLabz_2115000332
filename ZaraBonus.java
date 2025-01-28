public class ZaraBonus {
    
    public static double[][] generateEmployeeData(int numEmployees) {
        double[][] data = new double[numEmployees][2];  // [0] -> salary, [1] -> years of service
        
        for (int i = 0; i < numEmployees; i++) {
            data[i][0] = 10000 + Math.random() * 90000;  // Random salary between 10,000 and 99,999
            data[i][1] = Math.random() * 20;  // Random years of service between 0 and 20
        }
        
        return data;
    }

    public static double[][] calculateNewSalaryAndBonus(double[][] data) {
        double[][] newData = new double[data.length][3];  // [0] -> old salary, [1] -> years of service, [2] -> bonus and new salary

        for (int i = 0; i < data.length; i++) {
            double oldSalary = data[i][0];
            double yearsOfService = data[i][1];
            double bonus = 0;

            if (yearsOfService > 5) {
                bonus = oldSalary * 0.05;  // 5% bonus for more than 5 years of service
            } else {
                bonus = oldSalary * 0.02;  // 2% bonus for less than 5 years of service
            }

            double newSalary = oldSalary + bonus;

            newData[i][0] = oldSalary;
            newData[i][1] = yearsOfService;
            newData[i][2] = newSalary + bonus;
        }

        return newData;
    }

    public static void calculateTotals(double[][] data) {
        double oldSalarySum = 0;
        double newSalarySum = 0;
        double totalBonus = 0;

        for (int i = 0; i < data.length; i++) {
            oldSalarySum += data[i][0];
            newSalarySum += data[i][2] - data[i][0];
            totalBonus += data[i][2] - data[i][0];
        }

        System.out.println("Old Salary Sum: " + oldSalarySum);
        System.out.println("New Salary Sum: " + newSalarySum);
        System.out.println("Total Bonus Paid: " + totalBonus);
    }

    public static void displayEmployeeData(double[][] data) {
        System.out.printf("%-10s %-15s %-10s %-10s %-10s\n", "Employee", "Old Salary", "Years of Service", "Bonus", "New Salary");

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-10d %-15.2f %-10.2f %-10.2f %-10.2f\n", i + 1, data[i][0], data[i][1], data[i][2] - data[i][0], data[i][2]);
        }
    }

    public static void main(String[] args) {
        int numEmployees = 10;
        
        double[][] employeeData = generateEmployeeData(numEmployees);
        double[][] newSalaryData = calculateNewSalaryAndBonus(employeeData);
        
        displayEmployeeData(newSalaryData);
        calculateTotals(newSalaryData);
    }
}
