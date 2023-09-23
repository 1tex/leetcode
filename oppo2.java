//小欧有一个长度为 n，首项为 a，公差为 d 的等差数列。即 a, a + d, a + 2d, \cdots, a + (n - 1)d。现在，小欧把这 n 个数看作一个集合，每次操作可以从集合中任意选两个数 a_i, a_j，如果 a_i + a_j 是偶数，那么可以将 (a_i + a_j) / 2 加入到集合中。小欧想知道，经过若干次操作后，集合中最多能有多少个数。
//        输入描述
//        一行三个整数 n, a, d，表示等差数列的长度，首项和公差。
//        1 \leq n \leq 10^5
//        1 \leq a, d \leq 10^9
//        输出描述
//        输出一个整数，表示集合中最多能有多少个数。
//        示例1
//        输入输出示例仅供调试，后台判题数据一般不包含示例
//        输入
//        复制
//        5 1 2
//        输出
//        复制
//        9
//        说明
//        一开始集合为 [1, 3, 5, 7, 9]，选择相邻两项，可以得到 [1, 2, 3, 4, 5, 6, 7, 8, 9]。

//import java.util.HashSet;
//import java.util.Scanner;
//
//// 注意类名必须为 Main, 不要有任何 package xxx 信息
//public class oppo2 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        int n = in.nextInt();
//        int a = in.nextInt();
//        int d = in.nextInt();
//
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            set.add(a + i * d);
//        }
//
//        int originalSize;
//        do {
//            originalSize = set.size();
//            HashSet<Integer> newElements = new HashSet<>();
//
//            Integer[] arr = set.toArray(new Integer[0]);
//            for (int i = 0; i < arr.length; ++i) {
//                for (int j = i + 1; j < arr.length; ++j) {
//                    if ((arr[i] + arr[j]) % 2 == 0) {
//                        newElements.add((arr[i] + arr[j]) / 2);
//                    }
//                }
//            }
//
//            set.addAll(newElements);
//        } while (set.size() > originalSize);
//
//        System.out.println(set.size());
//    }
//}

import java.util.Scanner;

public class oppo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int d = scanner.nextInt();

//        boolean aIsOdd = (a % 2 != 0);
//        boolean dIsOdd = (d % 2 != 0);

        if ((a % 2 == 0 && d % 2 == 0) || (a%2!=0 && d%2!=0)) {
            System.out.println(2 * n - 1);
        } else {
            System.out.println(n + n/2);
        }
    }
}









