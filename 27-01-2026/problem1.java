import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class problem1 {

    public static void main(String[] args) {
        String text = "";
        try {
            File file = new File("data.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                text = text + line + " ";
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("file not found!");
            return;
        }
        text = text.trim().replaceAll("\\s+", " ");
        System.out.println("Cleaned Text:");
        System.out.println(text);
        System.out.println();
        // charactercount
        int charCount = text.replace(" ", "").length();
        System.out.println("Character count: " + charCount);

        // count words
        String[] words = text.toLowerCase().split(" ");
        System.out.println("Word count: " + words.length);

        // count sentences
        String[] sentences = text.split("\\.");
        System.out.println("Sentence count: " + sentences.length);

        // count word frequencies
        HashMap<String, Integer>map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        System.out.println("\nTop 5 Most Frequent Words:");

        for (int i = 0; i < 5; i++) {

            String maxWord = null;
            int maxCount = 0;

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxWord = entry.getKey();
                    maxCount = entry.getValue();
                }
            }

            if (maxWord != null) {
                System.out.println(maxWord + " : " + maxCount);
                map.remove(maxWord);
            }
        }

        //  to reverse each sentence
        System.out.println("\nReversed Sentences:");

        for (String sentence : sentences) {
            String[] sentenceWords = sentence.trim().split(" ");
            StringBuilder sb = new StringBuilder();

            for (int i = sentenceWords.length - 1; i >= 0; i--) {
                sb.append(sentenceWords[i]).append(" ");
            }

            System.out.println(sb.toString().trim());
        }

        // comparison of == vs equals()
        String s1 = new String("Java");
        String s2 = new String("Java");

        System.out.println("\nString Comparison:");
        System.out.println("Using == : " + (s1 == s2));
        System.out.println("Using equals() : " + s1.equals(s2));
    }
}
