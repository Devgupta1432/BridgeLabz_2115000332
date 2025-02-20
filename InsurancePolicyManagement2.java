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

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InsurancePolicy)) return false;
        InsurancePolicy other = (InsurancePolicy) obj;
        return this.policyNumber.equals(other.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
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

public class InsurancePolicyManagement2 {
    private Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("\nAll Unique Policies:");
        for (InsurancePolicy policy : hashSetPolicies) {
            System.out.println(policy);
        }
    }

    public void displayExpiringSoon() {
        LocalDate today = LocalDate.now();
        System.out.println("\nPolicies Expiring in the Next 30 Days:");
        for (InsurancePolicy policy : treeSetPolicies) {
            if (ChronoUnit.DAYS.between(today, policy.getExpiryDate()) <= 30) {
                System.out.println(policy);
            }
        }
    }

    public void displayByCoverageType(String coverageType) {
        System.out.println("\nPolicies with Coverage Type: " + coverageType);
        for (InsurancePolicy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    public void findDuplicatePolicies() {
        Set<String> policyNumbers = new HashSet<>();
        Set<InsurancePolicy> duplicates = new HashSet<>();
        for (InsurancePolicy policy : linkedHashSetPolicies) {
            if (!policyNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        System.out.println("\nDuplicate Policies:");
        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found.");
        } else {
            for (InsurancePolicy policy : duplicates) {
                System.out.println(policy);
            }
        }
    }

    public void comparePerformance() {
        List<InsurancePolicy> testPolicies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            testPolicies.add(new InsurancePolicy("P" + i, "Holder" + i, LocalDate.now().plusDays(i), "Auto", 500 + i));
        }

        measurePerformance("HashSet", new HashSet<>(), testPolicies);
        measurePerformance("LinkedHashSet", new LinkedHashSet<>(), testPolicies);
        measurePerformance("TreeSet", new TreeSet<>(), testPolicies);
    }

    private void measurePerformance(String setType, Set<InsurancePolicy> set, List<InsurancePolicy> policies) {
        long start = System.nanoTime();
        set.addAll(policies);
        long addTime = System.nanoTime() - start;

        start = System.nanoTime();
        set.contains(policies.get(5000));
        long searchTime = System.nanoTime() - start;

        start = System.nanoTime();
        set.remove(policies.get(5000));
        long removeTime = System.nanoTime() - start;

        System.out.println("\nPerformance of " + setType + ":");
        System.out.println("Add Time: " + addTime / 1_000_000 + " ms");
        System.out.println("Search Time: " + searchTime / 1_000 + " µs");
        System.out.println("Remove Time: " + removeTime / 1_000 + " µs");
    }

    public static void main(String[] args) {
        InsurancePolicyManagement manager = new InsurancePolicyManagement();

        manager.addPolicy(new InsurancePolicy("P123", "Alice", LocalDate.now().plusDays(20), "Health", 1200));
        manager.addPolicy(new InsurancePolicy("P456", "Bob", LocalDate.now().plusDays(40), "Auto", 900));
        manager.addPolicy(new InsurancePolicy("P789", "Charlie", LocalDate.now().plusDays(10), "Home", 1500));
        manager.addPolicy(new InsurancePolicy("P123", "Alice", LocalDate.now().plusDays(20), "Health", 1200)); // Duplicate

        manager.displayAllPolicies();
        manager.displayExpiringSoon();
        manager.displayByCoverageType("Health");
        manager.findDuplicatePolicies();
        manager.comparePerformance();
    }
}
