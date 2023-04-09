import java.util.Scanner;

public class fentang {
    public static int maxTaste(int n, int[] tasteValues) {
        if (n == 1) {
            return tasteValues[0];
        }
        if (n == 2) {
            return Math.max(tasteValues[0], tasteValues[1]);
        }

        int[] dp = new int[n];
        dp[0] = tasteValues[0];
        dp[1] = Math.max(tasteValues[0], tasteValues[1]);
        dp[2] = Math.max(dp[1], tasteValues[0] + tasteValues[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + tasteValues[i], dp[i - 3] + tasteValues[i - 1]));
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] tasteValues = new int[n];

        for (int i = 0; i < n; i++) {
            tasteValues[i] = scanner.nextInt();
        }

        int maxTasteSum = maxTaste(n, tasteValues);
        System.out.println(maxTasteSum);
    }
}
