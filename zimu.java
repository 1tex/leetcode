import java.util.*;

public class zimu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int m = scanner.nextInt();

        int maxLen = 0;

        for (char c = 'a'; c <= 'z'; c++) {
            maxLen = Math.max(maxLen, getMaxLen(s, c, m));
        }

        System.out.println(maxLen);
    }

    private static int getMaxLen(String s, char c, int m) {
        int[] positions = new int[s.length()];
        int posCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                positions[posCount++] = i;
            }
        }

        if (posCount == 0) {
            return 0;
        }

        int[] costs = new int[posCount];
        for (int i = 1; i < posCount; i++) {
            costs[i] = costs[i - 1] + positions[i] - positions[i - 1] - 1;
        }

        int maxLength = 0;
        for (int i = 0; i < posCount; i++) {
            int remain = m;
            int j = i;
            while (j < posCount && remain >= costs[j] - (i == 0 ? 0 : costs[i - 1])) {
                remain -= costs[j] - (i == 0 ? 0 : costs[i - 1]);
                j++;
            }
            maxLength = Math.max(maxLength, j - i);
        }

        return maxLength;
    }
}
