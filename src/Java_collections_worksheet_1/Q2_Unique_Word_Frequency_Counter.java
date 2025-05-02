package Java_collections_worksheet_1;

import java.util.*;

public class Q2_Unique_Word_Frequency_Counter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a paragraph:");
        String paragraph = scanner.nextLine();

        // Remove punctuation and convert to lowercase
        paragraph = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        // Split the paragraph into words
        String[] words = paragraph.split("\\s+");

        // Use a TreeMap to store word frequencies and keep them sorted
        Map<String, Integer> wordFrequency = new TreeMap<>();

        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        // Number of unique words
        int uniqueWordsCount = wordFrequency.size();
        System.out.println("Number of unique words: " + uniqueWordsCount);

        // Display word frequencies
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

