package Java_collections_worksheet_1;

import java.util.*;

public class Q12_Voting_System {
    private Map<String, Integer> candidates = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Q12_Voting_System system = new Q12_Voting_System();
        system.run();
    }

    public void run() {
        while (true) {
            System.out.println("\nVoting System Menu:");
            System.out.println("1. Vote for a candidate");
            System.out.println("2. Add a candidate");
            System.out.println("3. Remove a candidate");
            System.out.println("4. Show results");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    voteForCandidate();
                    break;
                case 2:
                    addCandidate();
                    break;
                case 3:
                    removeCandidate();
                    break;
                case 4:
                    showResults();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void voteForCandidate() {
        System.out.println("Candidates:");
        for (String candidate : candidates.keySet()) {
            System.out.println(candidate);
        }
        System.out.print("Enter candidate name to vote for: ");
        String candidate = scanner.nextLine();
        if (candidates.containsKey(candidate)) {
            candidates.put(candidate, candidates.get(candidate) + 1);
            System.out.println("Vote cast for " + candidate);
        } else {
            System.out.println("Candidate not found.");
        }
    }

    private void addCandidate() {
        System.out.print("Enter candidate name to add: ");
        String candidate = scanner.nextLine();
        if (candidates.containsKey(candidate)) {
            System.out.println("Candidate already exists.");
        } else {
            candidates.put(candidate, 0);
            System.out.println("Candidate " + candidate + " added.");
        }
    }

    private void removeCandidate() {
        System.out.print("Enter candidate name to remove: ");
        String candidate = scanner.nextLine();
        if (candidates.containsKey(candidate)) {
            candidates.remove(candidate);
            System.out.println("Candidate " + candidate + " removed.");
        } else {
            System.out.println("Candidate not found.");
        }
    }

    private void showResults() {
        List<Map.Entry<String, Integer>> sortedCandidates = new ArrayList<>(candidates.entrySet());
        sortedCandidates.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Voting Results:");
        for (Map.Entry<String, Integer> entry : sortedCandidates) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
}

