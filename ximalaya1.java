import java.util.HashMap;

public class ximalaya1 {
    public int lettersToChange(String str) {
        // Check if the string can be split into two equal-length substrings
        if (str.length() % 2 != 0) return -1;

        // Initialize a HashMap to store the frequency of characters for the first substring
        HashMap<Character, Integer> map = new HashMap<>();

        // Populate the HashMap with the first half of the string
        for (int i = 0; i < str.length() / 2; i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Count the minimum number of letters that need to be changed
        int changes = 0;
        for (int i = str.length() / 2; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                changes++;
            }
        }

        return changes;
    }
}