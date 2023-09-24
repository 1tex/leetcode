import java.util.Arrays;
import java.util.Scanner;

public class wangyi3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int X = in.nextInt();
        int Y = in.nextInt();
        int[][] herbs = new int[N][3];

        for (int i = 0; i < N; i++) {
            herbs[i][0] = in.nextInt();
            herbs[i][1] = in.nextInt();
            herbs[i][2] = in.nextInt();
        }

        int[][][][] dp = new int[K + 1][Y + 1][Y + 1][3]; // dp[k][y1][y2][x]: 使用k个草药，阴属性为y1，阳属性为y2，最小花费是多少

        for (int k = 0; k <= K; k++) {
            for (int y1 = 0; y1 <= Y; y1++) {
                for (int y2 = 0; y2 <= Y; y2++) {
                    Arrays.fill(dp[k][y1][y2], Integer.MAX_VALUE / 2);
                }
            }
        }

        dp[0][0][0][0] = 0;

        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < N; i++) {
                int cost = herbs[i][0];
                int type = herbs[i][1];
                int value = herbs[i][2];

                for (int y1 = 0; y1 <= Y; y1++) {
                    for (int y2 = 0; y2 <= Y; y2++) {
                        for (int lastType = 0; lastType <= 2; lastType++) {
                            if (dp[k - 1][y1][y2][lastType] == Integer.MAX_VALUE / 2) continue;

                            int newY1 = y1;
                            int newY2 = y2;
                            if (type == 1) newY1 += value;
                            if (type == 2) newY2 += value;

                            newY1 = Math.min(newY1, Y);
                            newY2 = Math.min(newY2, Y);

                            int newCost = dp[k - 1][y1][y2][lastType] + cost;
                            dp[k][newY1][newY2][type] = Math.min(dp[k][newY1][newY2][type], newCost);
                        }
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int k = 1; k <= K; k++) {
            for (int y1 = 0; y1 <= Y; y1++) {
                for (int y2 = 0; y2 <= Y; y2++) {
                    int remain1 = y1;
                    int remain2 = y2;

                    if (X == 1) remain1 -= y2;
                    if (X == 2) remain2 -= y1;

                    remain1 = Math.max(remain1, 0);
                    remain2 = Math.max(remain2, 0);

                    if (remain1 >= Y && X == 1) {
                        ans = Math.min(ans, dp[k][y1][y2][1]);
                    }
                    if (remain2 >= Y && X == 2) {
                        ans = Math.min(ans, dp[k][y1][y2][2]);
                    }
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println("Cannot Make It!");
        } else {
            System.out.println(ans);
        }
    }
}