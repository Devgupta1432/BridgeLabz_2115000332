import java.util.*;

class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>();
    private TreeMap<Double, List<String>> sortedByBalance = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedByBalance.computeIfAbsent(balance, k -> new ArrayList<>()).add(accountNumber);
    }

    public void deposit(String accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found!");
            return;
        }

        double oldBalance = accounts.get(accountNumber);
        double newBalance = oldBalance + amount;

        sortedByBalance.get(oldBalance).remove(accountNumber);
        if (sortedByBalance.get(oldBalance).isEmpty()) {
            sortedByBalance.remove(oldBalance);
        }

        accounts.put(accountNumber, newBalance);
        sortedByBalance.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);
    }

    public void requestWithdrawal(String accountNumber) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found!");
            return;
        }
        withdrawalQueue.add(accountNumber);
        System.out.println("Withdrawal request added for account: " + accountNumber);
    }

    public void processWithdrawals() {
        System.out.println("\nProcessing Withdrawal Requests:");
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for account: " + accountNumber);
        }
    }

    public void displayAccountsSortedByBalance() {
        System.out.println("\nAccounts Sorted by Balance:");
        sortedByBalance.forEach((balance, accountList) -> 
            accountList.forEach(account -> 
                System.out.println("Account: " + account + ", Balance: $" + balance)
            )
        );
    }

    public void displayAllAccounts() {
        System.out.println("\nAll Accounts:");
        accounts.forEach((account, balance) -> 
            System.out.println("Account: " + account + ", Balance: $" + balance)
        );
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount("123", 5000);
        bank.addAccount("456", 3000);
        bank.addAccount("789", 7000);
        bank.addAccount("101", 6000);

        bank.displayAllAccounts();
        bank.displayAccountsSortedByBalance();

        bank.deposit("123", 2000);
        bank.displayAccountsSortedByBalance();

        bank.requestWithdrawal("456");
        bank.requestWithdrawal("789");

        bank.processWithdrawals();
    }
}
