package Java_collections_worksheet_1;

import java.util.*;

public class Q7_Movie_Rating_Aggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Integer>> movieRatings = new HashMap<>();

        System.out.println("Enter the number of movies:");
        int numMovies = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numMovies; i++) {
            System.out.println("Enter the name of movie " + (i + 1) + ":");
            String movieName = scanner.nextLine();

            System.out.println("Enter the number of ratings for " + movieName + ":");
            int numRatings = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            List<Integer> ratings = new ArrayList<>();
            for (int j = 0; j < numRatings; j++) {
                int rating;
                while (true) {
                    System.out.println("Enter rating " + (j + 1) + " for " + movieName + " (between 1-5):");
                    rating = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (rating >= 1 && rating <= 5) {
                        break;
                    } else {
                        System.out.println("Invalid rating. Please enter a rating between 1 and 5.");
                    }
                }
                ratings.add(rating);
            }
            movieRatings.put(movieName, ratings);
        }

        // Calculate average ratings
        Map<String, Double> averageRatings = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : movieRatings.entrySet()) {
            String movie = entry.getKey();
            List<Integer> ratings = entry.getValue();
            double average = ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0);
            averageRatings.put(movie, average);
        }

        // Sort movies by average rating in descending order
        List<Map.Entry<String, Double>> sortedMovies = new ArrayList<>(averageRatings.entrySet());
        sortedMovies.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        // Display the sorted movies and their average ratings
        System.out.println("Movies sorted by average rating:");
        for (Map.Entry<String, Double> entry : sortedMovies) {
            System.out.printf("%s: %.2f%n", entry.getKey(), entry.getValue());
        }

        scanner.close();
    }
}
