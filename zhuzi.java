import java.util.*;

public class zhuzi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int c = scanner.nextInt();
        List<List<Integer>> beadColors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int numColors = scanner.nextInt();
            List<Integer> colors = new ArrayList<>();
            for (int j = 0; j < numColors; j++) {
                colors.add(scanner.nextInt());
            }
            beadColors.add(colors);
        }

        int[] colorViolations = new int[c + 1];
        for (int i = 0; i < n; i++) {
            for (int color : beadColors.get(i)) {
                if (isColorViolated(beadColors, n, m, color, i)) {
                    colorViolations[color]++;
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= c; i++) {
            if (colorViolations[i] > 0) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static boolean isColorViolated(List<List<Integer>> beadColors, int n, int m, int color, int startIndex) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            int index = (startIndex + i) % n;
            if (beadColors.get(index).contains(color)) {
                count++;
                if (count >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
