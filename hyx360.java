import java.util.Scanner;

public class hyx360 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = 0;
        for (int R = 3; R <= n + 2; R++) {
            for (int C = 4; C <= n + 1; C++) { // 从4开始，因为C-1>=3
                for (int L = 3; L <= n + 2; L++) {
                    int stolen = R * C * L - (R - 2) * (C - 1) * (L - 2);
                    if (stolen == n) {
                        System.out.println(stolen);
                        return;
                    }
                    max = Math.max(max, stolen);
                }
            }
        }
        System.out.println(max);
    }
}
