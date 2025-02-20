import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber +
               ", Holder: " + policyholderName +
               ", Expiry: " + expiryDate +
               ", Coverage: " + coverageType +
               ", Premium: $" + premiumAmount;
    }
}

public class InsurancePolicyManagement {
    private Map<String, InsurancePolicy> hashMapPolicies = new HashMap<>();
    private Map<String, InsurancePolicy> linkedHashMapPolicies = new LinkedHashMap<>();
    private TreeMap<LocalDate, InsurancePolicy> treeMapPolicies = new TreeMap<>();

    public void addPolicy(InsurancePolicy policy) {
        hashMapPolicies.put(policy.getPolicyNumber(), policy);
        linkedHashMapPolicies.put(policy.getPolicyNumber(), policy);
        treeMapPolicies.put(policy.getExpiryDate(), policy);
    }

    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return hashMapPolicies.get(policyNumber);
    }

    public List<InsurancePolicy> getExpiringPolicies() {
        LocalDate today = LocalDate.now();
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();

        for (Map.Entry<LocalDate, InsurancePolicy> entry : treeMapPolicies.entrySet()) {
            if (ChronoUnit.DAYS.between(today, entry.getKey()) <= 30) {
                expiringPolicies.add(entry.getValue());
            }
        }

        return expiringPolicies;
    }

    public List<InsurancePolicy> getPoliciesByHolder(String policyholderName) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : hashMapPolicies.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        treeMapPolicies.entrySet().removeIf(entry -> entry.getKey().isBefore(today));
        hashMapPolicies.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
        linkedHashMapPolicies.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
    }

    public void displayAllPolicies() {
        System.out.println("\nAll Policies:");
        for (InsurancePolicy policy : linkedHashMapPolicies.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement manager = new InsurancePolicyManagement();

        manager.addPolicy(new InsurancePolicy("P123", "Alice", LocalDate.now().plusDays(20), "Health", 1200));
        manager.addPolicy(new InsurancePolicy("P456", "Bob", LocalDate.now().plusDays(40), "Auto", 900));
        manager.addPolicy(new InsurancePolicy("P789", "Carol", LocalDate.now().plusDays(10), "Home", 1500));
        manager.addPolicy(new InsurancePolicy("P321", "Alice", LocalDate.now().minusDays(5), "Life", 800)); // Expired

        manager.displayAllPolicies();

        System.out.println("\nPolicy by Number (P123): " + manager.getPolicyByNumber("P123"));

        System.out.println("\nPolicies Expiring Soon:");
        System.out.println(manager.getExpiringPolicies());

        System.out.println("\nPolicies for Alice:");
        System.out.println(manager.getPoliciesByHolder("Alice"));

        manager.removeExpiredPolicies();
        System.out.println("\nAfter Removing Expired Policies:");
        manager.displayAllPolicies();
    }
}
