//小美计划派遣一位勇敢的冒险家前往解开宝塔的秘密。宝塔中共保存着 n 个宝藏，价值分别为 a_1, a_2, \dots, a_n。每天冒险家可以进入宝塔，并选择一个价值不低于 b_i 的宝藏带出来。但是冒险家每天只能选择一个宝藏，而且每个宝藏只能被选择一次。
//        现在小美想知道，在这个过程中，最多可以拿出多少个宝藏。
//        输入描述
//        一行一个整数 n，表示宝塔中的宝藏个数。
//        一行 n 个整数 a_1, a_2, \dots, a_n，表示宝塔中的宝藏价值。
//        一行 n 个整数 b_1, b_2, \dots, b_n，表示冒险家每天可以拿出的最低价值。
//        1 \leq n \leq 10^5
//        1 \leq a_i,b_i \leq 10^5
//        输出描述
//        输出一个整数，表示最多可以拿出的宝藏个数。
//
//        示例1
//        输入输出示例仅供调试，后台判题数据一般不包含示例
//        输入
//        复制
//        5
//        1 2 3 4 1
//        3 1 2 3 2
//        输出
//        复制
//        4
//        说明
//        第一天，拿出 3，还剩下[1, 2, 4, 1]
//        第二天，拿出 1，还剩下[2, 4, 1]
//        第三天，拿出 2，还剩下[4, 1]
//        第四天，拿出 4，还剩下[1]
//        第五天，没有宝藏可以拿出来了。

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class meituan_b2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i]= in.nextInt();
        }

        PriorityQueue<Integer> treasures = new PriorityQueue<>();
        for (int value : a) {
            treasures.add(value);
        }

        Arrays.sort(b);

        int count = 0;
        for (int min : b) {
            while (!treasures.isEmpty() && treasures.peek() < min) {
                treasures.poll();
            }
            if (!treasures.isEmpty()) {
                treasures.poll();
                count++;
            }
        }
        System.out.println(count);
    }
}