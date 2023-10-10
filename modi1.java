import java.util.Arrays;
import java.util.Scanner;

public class modi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] citys = new int[n][2];
        for (int i = 0; i < n; i++) {
            citys[i][0] = sc.nextInt();
            citys[i][1] = sc.nextInt();
        }

        Arrays.sort(citys, (a, b) -> (a[0] - b[0]));

        int max = 0;

        for (int i = 0; i < n; i++) {
            int temp = citys[i][1];
            for (int j = i + 1; j < n && Math.abs(citys[i][0] - citys[j][0]) < k; j++) {
                temp += citys[j][1];
            }
            max = Math.max(temp, max);
        }

        System.out.println(max);
    }
}
