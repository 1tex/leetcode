import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class meituan2 {
    static List<List<Integer>> tree;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 2; i <= n; i++) {
            int parent = scanner.nextInt();
            tree.get(i).add(parent);
            tree.get(parent).add(i);
        }

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int maxDepthX = dfs(x, y);
        int maxDepthY = dfs(y, x);

        int longestPath = maxDepthX + maxDepthY + 1;

        System.out.println(longestPath);
    }

    public static int dfs(int node, int parent) {
        int maxDepth = 0;
        for (int child : tree.get(node)) {
            if (child != parent) {
                maxDepth = Math.max(maxDepth, dfs(child, node) + 1);
            }
        }
        return maxDepth;
    }
}
