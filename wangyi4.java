//有一天小师妹接到一个神秘人的任务，要求她从二维棋盘上的点S以最小的移动次数到达点T，而且必须按照神秘人的规则移动，这可难倒小师妹了，她希望你能帮助她算算最少移动多少次。
//
//        給一个二维的大小为M x N字符数组str，表示小师妹所在的地图，每个元素范在'a'-'z'之间。每次移动必须从以下5种方案中任选其一，设当前点为（x，y）：
//
//        (x， y) -> (x + 1, y)
//        (x， y) -> (x - 1, y)
//        (x， y) -> (x, y + 1)
//        (x， y) -> (x, y - 1)
//        (x， y) -> (x1, y1)，当str[x][y] == str[x1][y1]
//        任何时候都不能移动到地图范围外。
//
//        输入描述
//
//        输入二个正整数M，N(2<= M，N<= 100000 , 2<= M xN<= 100000)，表示一共有二维字符数组的大小。
//
//        接下来输入M行，每行N个字符，表示二维数组。
//
//        输入一个整数Q，表示询问次数。
//
//        接下来Q(1<= Q<= 100000 )行，每行输入SX，SY，TX，TY，分别表示起点S的行和列，终点T的行和列。
//
//
//
//
//        输出描述
//
//        对于每一个询问，输出一个正整数，表示起点到终点的最短距离。
//
//
//
//        示例1
//        输入输出示例仅供调试，后台判题数据一般不包含示例
//        输入
//        复制
//        4 4
//        qwer
//        sdaf
//        wert
//        dsre
//        4
//        1 4 4 1
//        2 3 4 2
//        3 4 1 2
//        3 4 1 3
//        输出
//        复制
//        3
//        3
//        3
//        2


import java.util.*;

public class wangyi4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        scanner.nextLine();

        char[][] board = new char[M][N];
        Map<Character, List<int[]>> map = new HashMap<>();

        // 读入二维数组和构建哈希表
        for (int i = 0; i < M; ++i) {
            String line = scanner.nextLine();
            for (int j = 0; j < N; ++j) {
                board[i][j] = line.charAt(j);
                map.putIfAbsent(board[i][j], new ArrayList<>());
                map.get(board[i][j]).add(new int[]{i, j});
            }
        }

        int Q = scanner.nextInt();
        for (int q = 0; q < Q; ++q) {
            int sx = scanner.nextInt() - 1;
            int sy = scanner.nextInt() - 1;
            int tx = scanner.nextInt() - 1;
            int ty = scanner.nextInt() - 1;

            System.out.println(bfs(board, map, sx, sy, tx, ty));
        }
    }

    private static int bfs(char[][] board, Map<Character, List<int[]>> map, int sx, int sy, int tx, int ty) {
        int M = board.length, N = board[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new int[]{sx, sy, 0});
        visited.add(sx + "," + sy);

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], steps = curr[2];

            if (x == tx && y == ty) {
                return steps;
            }

            // 直接移动
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                String key = newX + "," + newY;
                if (newX >= 0 && newX < M && newY >= 0 && newY < N && !visited.contains(key)) {
                    queue.add(new int[]{newX, newY, steps + 1});
                    visited.add(key);
                }
            }

            // 跳跃移动
            char c = board[x][y];
            List<int[]> jumpList = map.get(c);
            for (int[] jump : jumpList) {
                int newX = jump[0], newY = jump[1];
                String key = newX + "," + newY;
                if (!visited.contains(key)) {
                    queue.add(new int[]{newX, newY, steps + 1});
                    visited.add(key);
                }
            }
            map.get(c).clear(); // 清空该字符的位置列表，避免重复访问
        }

        return -1; // 无法到达目标
    }
}










