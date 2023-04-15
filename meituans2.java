import java.util.Scanner;

public class meituans2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(getMin(n, a, b));
        }
    }

    private static int getMin(int n ,int a, int b) {
        int x = (a + b) / n;
        int left1 = a / x;
        return Math.min(Math.min(a, b), Math.abs(a - b) % n);
    }
}
