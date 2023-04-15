import java.util.Scanner;

public class meituans1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int C = scanner.nextInt();
        for (int c = 0; c < C; c++) {
            String S = scanner.next();
            String T = scanner.next();
            System.out.println(minOps(S, T));
        }
    }

    private static int minOps(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();
        int[][] dp = new int[sLen + 1][tLen + 1];

        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= tLen; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[sLen][tLen];
    }
}
