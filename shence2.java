import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class shence2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int m = in.nextInt();
        int[] resources = new int[m];

        for (int i = 0; i < m; i++) {
            resources[i] = in.nextInt();
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                int maxResource = 0;

                for (int k = j; k < m; k++) {
                    maxResource = Math.max(maxResource, resources[k]);
                    if (i - 1 >= k - j && dp[i - 1 - (k - j)] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i - 1 - (k - j)] + maxResource);
                    }
                }
            }
        }

        if (dp[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n]);
        }
    }
}