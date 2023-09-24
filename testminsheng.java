import java.util.Scanner;

public class testminsheng {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        in.nextLine();
        String s = in.nextLine().trim();
        String t = in.nextLine().trim();

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= m - n; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) != t.charAt(j + i)) {
                    cur++;
                }
            }
            ans = Math.min(cur, ans);
        }

        System.out.println(ans);
    }
}