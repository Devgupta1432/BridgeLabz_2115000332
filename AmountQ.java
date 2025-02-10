abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public abstract double calculateInterest();

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: $" + balance);
    }

    public double getBalance() {
        return balance;
    }
}

interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    
    public double calculateInterest() {
        return getBalance() * 0.04;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    
    public double calculateInterest() {
        return getBalance() * 0.02;
    }

    
    public boolean applyForLoan(double amount) {
        return amount <= calculateLoanEligibility();
    }

    
    public double calculateLoanEligibility() {
        return getBalance() * 3 + overdraftLimit;
    }
}

public class AmountQ {
    public static void processAccount(BankAccount account) {
        account.displayAccountDetails();
        System.out.println("Interest Earned: $" + account.calculateInterest());

        if (account instanceof Loanable) {
            Loanable loanAccount = (Loanable) account;
            double loanEligibility = loanAccount.calculateLoanEligibility();
            System.out.println("Loan Eligibility: $" + loanEligibility);
            System.out.println("Loan Approval Status: " + (loanAccount.applyForLoan(loanEligibility / 2) ? "Approved" : "Denied"));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("SA12345", "Alice", 5000);
        BankAccount current = new CurrentAccount("CA67890", "Bob", 10000, 5000);

        BankAccount[] accounts = {savings, current};

        for (BankAccount account : accounts) {
            processAccount(account);
        }
    }
}
