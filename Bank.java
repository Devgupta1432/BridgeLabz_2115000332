class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displaySavingsAccountDetails() {
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + accountNumber);             System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + getBalance());
    }
}

public class Bank {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("1234567890", "Alice", 5000.0);
        account1.displayAccountDetails();
        account1.deposit(2000);
        account1.withdraw(1000);
        account1.displayAccountDetails();

        System.out.println("\nSavings Account Details:");
        SavingsAccount savingsAccount = new SavingsAccount("0987654321", "Bob", 3000.0);
        savingsAccount.displaySavingsAccountDetails();
    }
}
