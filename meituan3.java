import java.util.Scanner;

public class meituan3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int minVolume = a[i], maxVolume = a[i];
            int k = 0;
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j >= 1 && k < m; j--, k++) {
                minVolume = Math.min(minVolume, a[j]);
                maxVolume = Math.max(maxVolume, a[j]);
                dp[i] = Math.min(dp[i], dp[j - 1] + k * ((minVolume + maxVolume) / 2) + s);
            }
        }

        System.out.println(dp[n]);
    }
}
