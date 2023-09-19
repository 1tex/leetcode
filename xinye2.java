import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class xinye2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int M = in.nextInt();
        int n = in.nextInt();
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = in.nextInt();
        }

        int[] dp = new int[M + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = M; j >= weights[i]; j--) {
                dp[j] += dp[j - weights[i]];
            }
        }

        System.out.println(dp[M]);
    }
}