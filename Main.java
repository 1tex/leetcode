import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(solve(n, x, y));
        }
    }

    private static String solve(int n, int x, int y) {
        int maxPlayers, minPlayers;

        int playersWithYellow = Math.min(n, x);
        maxPlayers = Math.max(0, n - Math.max(0, y - (n - playersWithYellow)));

        int playersSentOffByYellow = Math.min(x / 2, n);
        minPlayers = Math.max(0, n - playersSentOffByYellow - y);

        return maxPlayers + " " + minPlayers;
    }
}
