import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class zhaohang3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            colors[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            Map<Integer, Integer> seenColors = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                if (colors[i] != colors[j]) {
                    if (seenColors.getOrDefault(colors[j], 0) == 0) {
                        seenColors.put(colors[j], 1);
                        count++;
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
