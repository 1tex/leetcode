import java.util.*;

public class shuranhong {
    private static int n;
    private static List<List<Edge>> tree;
    private static int[] dp;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        tree = new ArrayList<>(n + 1);
        for (int i = 0; i <=n ;i++){
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            tree.get(u).add(new Edge(v, w));
            tree.get(v).add(new Edge(u, w));
        }
        dp = new int[n + 1];
        dfs(1, 0);

        System.out.println(dp[1]);
    }

    private static void dfs(int u, int pre) {
        for (Edge edge : tree.get(u)) {
            int v = edge.to;
            if (v == pre) {
                continue;
            }
            dfs(v, u);
            dp[u] = Math.max(dp[u], dp[v] + edge.weight);
        }
    }

    private static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

}
