import java.util.*;

public class josefu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 小朋友个数
        int k = sc.nextInt(); // 游戏进行轮数
        List<Integer> nums = new ArrayList<>(); // 使用List保存小朋友编号
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        boolean clockwise = true; // 初始方向为顺时针
        int cur = 0; // 初始领头为第一个小朋友
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt(); // 当前轮数的ai
            int size = nums.size();
            int idx = (cur + a) % size; // 计算出局小朋友在List中的下标
            if (!clockwise) {
                idx = (size - idx) % size;
            }
            System.out.print(nums.remove(idx) + " "); // 输出出局小朋友的编号
            cur = idx % size; // 更新领头小朋友的下标
            if (!clockwise) {
                cur = (size - cur) % size;
            }
            clockwise = !clockwise; // 更改方向
        }
    }
}