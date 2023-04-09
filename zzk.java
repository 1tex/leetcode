import java.util.*;

public class zzk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = scanner.nextInt();
        }

        List<Integer> children = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            children.add(i);
        }

        int currentIndex = 0;
        boolean clockwise = true;
        for (int round = 0; round < k; round++) {
            int step = a[round];
            currentIndex = (currentIndex + (clockwise ? step : -step - 1) + children.size()) % children.size();
            System.out.print(children.get(currentIndex) + (round < k - 1 ? " " : "\n"));
            children.remove(currentIndex);
            if (!clockwise) {
                currentIndex = (currentIndex - 1 + children.size()) % children.size();
            } else {
                currentIndex %= children.size();
            }
            clockwise = !clockwise;
        }
    }
}
