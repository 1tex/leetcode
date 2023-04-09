import java.util.*;

public class meiju {
    String s = "We test coders. Give us a try?";
    public static int solution(String S) {
        int maxWords = 0;
        String[] sentences = S.split("[.?!]");
        for (String sentence : sentences) {
            int wordCount = 0;
            String[] words = sentence.trim().split(" ");
            for (String word : words) {
                if (word.matches(".*[a-zA-Z].*")) {
                    wordCount++;
                }
            }
            maxWords = Math.max(maxWords, wordCount);
        }
        return maxWords;
    }

}
