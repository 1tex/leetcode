import java.util.Iterator;
import java.util.Scanner;

public class meituans3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int T = scanner.nextInt();
        scanner.nextLine();

        int[] left = new int[n + 2];
        int[] right = new int[n + 2];

        for (int i = 0; i < T; i++) {
            String[] op  = scanner.nextLine().split(" ");
            if (op[0].equals("L")) {
                int x = Integer.parseInt(op[1]);
                if (x > 1 && left[x] == 0) {
                    left[x] = x -1;
                    right[x -1] = x;
                }
            } else if (op[0].equals("R")) {
                int x = Integer.parseInt(op[1]);
                if (x < n && right[x] == 0) {
                    right[x] = x + 1;
                    left[x + 1] =x;
                }
            } else if (op[0].equals("Q")) {
                int x = Integer.parseInt(op[1]);
                int left_most = x;
                while (left[left_most] != 0) {
                    left_most = left[left_most];
                }
                int right_most = x;
                while (right[right_most] != 0) {
                    right_most = right[right_most];
                }
                System.out.println(left_most + " " + right_most);
            }
        }
    }
}
