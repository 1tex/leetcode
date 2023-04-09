import java.util.*;

public class meituan4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] grid = new int[n + 1][m + 1];
        List<int[]> mines = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            mines.add(new int[]{p, q});
            grid[p][q] = -1;
        }

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x1, y1, Integer.MAX_VALUE});
        grid[x1][y1] = 1;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int ans = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int minDist = current[2];

            if (x == x2 && y == y2) {
                ans = minDist;
                break;
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 1 && newX <= n && newY >= 1 && newY <= m && grid[newX][newY] != -1 && grid[newX][newY] != 1) {
                    int tempMinDist = Integer.MAX_VALUE;
                    for (int[] mine : mines) {
                        tempMinDist = Math.min(tempMinDist, Math.abs(newX - mine[0]) + Math.abs(newY - mine[1]));
                    }
                    grid[newX][newY] = 1;
                    queue.offer(new int[]{newX, newY, Math.min(minDist, tempMinDist)});
                }
            }
        }

        System.out.println(ans);
    }
}
