import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class minshengkeji1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int s = in.nextInt();
        int t = in.nextInt();
        in.nextLine();
        String s1 = in.nextLine().trim();
        String s2 = in.nextLine().trim();

        int[][] dp = new int[s + 1][t + 1];
        for (int i = 0; i <= s; i++) {
            for (int j = 0; j <= t; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;

        for (int i = 0; i <= s; i++) {
            for (int j = Math.max(0, i); j <= t; j++) {
                if (j > 0 && j > 0 && dp[i - 1][j - 1] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1));
                }
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
                if (i == 0 && dp[i][j] == Integer.MAX_VALUE) {
                    dp[i][j] = 0;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = s; j <= t; j++) {
            result = Math.min(result, dp[s][j]);
        }
        System.out.println(result);
    }
}