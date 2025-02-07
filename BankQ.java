
class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    public void displayAccountType() {
        System.out.println("Account Type: General Bank Account");
    }
}


class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    
    public void displayAccountType() {
        super.displayAccountType();
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    
    public void displayAccountType() {
        super.displayAccountType();
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: " + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    private int lockInPeriod;

    public FixedDepositAccount(String accountNumber, double balance, int lockInPeriod) {
        super(accountNumber, balance);
        this.lockInPeriod = lockInPeriod;
    }

    
    public void displayAccountType() {
        super.displayAccountType();
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Lock-in Period: " + lockInPeriod + " months");
    }
}

public class BankQ {
    public static void main(String[] args) {

        BankAccount savings = new SavingsAccount("SA12345", 10000, 4.5);
        BankAccount checking = new CheckingAccount("CA12345", 5000, 2000);
        BankAccount fixedDeposit = new FixedDepositAccount("FDA12345", 20000, 12);

        System.out.println("Savings Account Info:");
        savings.displayAccountInfo();
        savings.displayAccountType();
        System.out.println();

        System.out.println("Checking Account Info:");
        checking.displayAccountInfo();
        checking.displayAccountType();
        System.out.println();

        System.out.println("Fixed Deposit Account Info:");
        fixedDeposit.displayAccountInfo();
        fixedDeposit.displayAccountType();
    }
}
