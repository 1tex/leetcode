import java.util.Scanner;

public class meituans2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int l = 0, r = Math.max(a, b);
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (check(mid, n, a, b)) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }

            System.out.println(r);
        }
    }

    private static boolean check(int x, int n ,int a, int b) {
        int count = a / x + b / x;
        return count >= n;
    }
}
