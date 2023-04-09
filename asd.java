import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class asd {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] redCount, blueCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] colors = br.readLine().toCharArray();
        graph = new List[n + 1];
        visited = new boolean[n + 1];
        redCount = new int[n + 1];
        blueCount = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            if (colors[i - 1] == 'R') {
                redCount[i] = 1;
            } else {
                blueCount[i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            graph[u].add(v);
            graph[v].add(u);
        }
        int result = dfs(1);
        System.out.println(result);
    }

    private static int dfs(int node) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
                redCount[node] += blueCount[neighbor];
                blueCount[node] += redCount[neighbor];
            }
        }
        return Math.max(redCount[node], blueCount[node]);
    }
}