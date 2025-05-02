package Java_collections_worksheet_1;

import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + ": " + score;
    }
}

class ScoreComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        return Integer.compare(p2.score, p1.score); // Descending order
    }
}

public class Q9_Leaderboard_Tracker {
    private TreeSet<Player> leaderboard;

    public Q9_Leaderboard_Tracker() {
        leaderboard = new TreeSet<>(new ScoreComparator());
    }

    public void addOrUpdatePlayer(String name, int score) {
        Player existingPlayer = null;
        for (Player player : leaderboard) {
            if (player.name.equals(name)) {
                existingPlayer = player;
                break;
            }
        }
        if (existingPlayer != null) {
            leaderboard.remove(existingPlayer);
        }
        leaderboard.add(new Player(name, score));
    }

    public void printLeaderboard() {
        for (Player player : leaderboard) {
            System.out.println(player);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q9_Leaderboard_Tracker tracker = new Q9_Leaderboard_Tracker();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add/Update Player");
            System.out.println("2. Print Leaderboard");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter player name:");
                    String playerName = scanner.nextLine();
                    System.out.println("Enter player score:");
                    int playerScore = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    tracker.addOrUpdatePlayer(playerName, playerScore);
                    break;
                case 2:
                    System.out.println("\nLeaderboard:");
                    tracker.printLeaderboard();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
