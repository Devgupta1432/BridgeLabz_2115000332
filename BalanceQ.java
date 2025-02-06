import java.util.ArrayList;

class Bank {
    private String name;
    private ArrayList<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void openAccount(Customer customer, double initialDeposit) {
        Account newAccount = new Account(this, customer, initialDeposit);
        accounts.add(newAccount);
        customer.addAccount(newAccount);
        System.out.println("Account opened for " + customer.getName() + " at " + name + " with balance: $" + initialDeposit);
    }

    public String getName() {
        return name;
    }
}

class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println(name + "'s Accounts:");
        for (Account account : accounts) {
            System.out.println("- Bank: " + account.getBank().getName() + ", Balance: $" + account.getBalance());
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
}

class Account {
    private Bank bank;
    private Customer customer;
    private double balance;

    public Account(Bank bank, Customer customer, double balance) {
        this.bank = bank;
        this.customer = customer;
        this.balance = balance;
    }

    public Bank getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }
}

public class BalanceQ {
    public static void main(String[] args) {
        Bank bank1 = new Bank("National Bank");
        Bank bank2 = new Bank("City Bank");

        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        bank1.openAccount(customer1, 1000);
        bank1.openAccount(customer2, 1500);
        bank2.openAccount(customer1, 2000);

        customer1.viewBalance();
        customer2.viewBalance();
    }
}
