import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteCountMap = new HashMap<>();
    private Map<String, Integer> orderedVotes = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedResults = new TreeMap<>();

    public void castVote(String candidate) {
        voteCountMap.put(candidate, voteCountMap.getOrDefault(candidate, 0) + 1);
        orderedVotes.put(candidate, voteCountMap.get(candidate));
        sortedResults.put(candidate, voteCountMap.get(candidate));
    }

    public void displayResults() {
        System.out.println("\nVotes in Order of Voting:");
        System.out.println(orderedVotes);

        System.out.println("\nVotes Sorted Alphabetically:");
        System.out.println(sortedResults);

        System.out.println("\nVotes Sorted by Highest Count:");
        voteCountMap.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static void main(String[] args) {
        VotingSystem voting = new VotingSystem();
        
        voting.castVote("Alice");
        voting.castVote("Bob");
        voting.castVote("Alice");
        voting.castVote("Charlie");
        voting.castVote("Bob");
        voting.castVote("Alice");

        voting.displayResults();
    }
}
