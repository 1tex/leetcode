import java.util.*;
import java.io.*;

public class xiaohongshu {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String[] input = reader.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int t = Integer.parseInt(input[1]);
            tree.get(s).add(t);
            tree.get(t).add(s);
        }
        reader.close();

        int[] subtreeSize = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        dfs(tree, 1, visited, subtreeSize);

        int minDiff = n;
        int minDiffCount = 0;
        for (int node = 2; node <= n; node++) {
            int diff = Math.abs(n - 2 * subtreeSize[node]);
            if (diff < minDiff) {
                minDiff = diff;
                minDiffCount = 1;
            } else if (diff == minDiff) {
                minDiffCount++;
            }
        }

        System.out.println(minDiff + " " + minDiffCount);
    }

    private static int dfs(List<List<Integer>> tree, int node, boolean[] visited, int[] subtreeSize) {
        visited[node] = true;
        int size = 1;
        for (int child : tree.get(node)) {
            if (!visited[child]) {
                size += dfs(tree, child, visited, subtreeSize);
            }
        }
        subtreeSize[node] = size;
        return size;
    }
}
