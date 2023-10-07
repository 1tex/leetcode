//小美拿到了n个集合。她随机取出两个集合准备计算它们的并集大小，请你帮小美计算这个并集大小的期望。
//
//        请注意，集合中是不存在两个相同元素的。例如[1,2]和[1,3,5]的并集为[1,2,3,5]
//        输入描述
//        第一行输入一个正整数n，代表集合的数量。
//        接下来的n行，每行描述一个集合：
//        每行的第一个元素为一个正整数m，代表集合的大小；接下来输入m个正整数a_{ij}，代表第i个集合的第j个元素。
//        保证每个集合中的元素不同。
//        所有集合的大小之和不超过 200000。
//        2\leq n \leq 200000
//        1\leq a_{ij} \leq 10^9
//        输出描述
//        一个浮点数，代表最终并集的大小期望。如果你的答案和标准答案的相对误差不超过10^{-7}，则认为答案正确。
//        示例1
//        输入输出示例仅供调试，后台判题数据一般不包含示例
//        输入
//        复制
//        2
//        2 1 2
//        3 1 3 5
//        输出
//        复制
//        4.00000000000
//        说明
//        显然最终的期望大小是 4。
//        示例2
//        输入输出示例仅供调试，后台判题数据一般不包含示例
//        输入
//        复制
//        3
//        2 1 2
//        3 1 3 5
//        4 1 2 3 4
//        输出
//        复制
//        4.33333333333
//        说明
//        有 2/3 的概率并集大小为 4，1/3 的概率并集大小为 5。

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class meituan_b4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int totalElements = 0;

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            HashSet<Integer> uniqueSet = new HashSet<>();
            for (int j = 0; j < m; j++) {
                int elem = sc.nextInt();
                uniqueSet.add(elem);
            }
            for (int elem : uniqueSet) {
                frequencyMap.put(elem, frequencyMap.getOrDefault(elem, 0) + 1);
            }
            totalElements += uniqueSet.size();
        }

        double expectedSize = 0.0;
        for (int freq : frequencyMap.values()) {
            expectedSize += 1.0 * freq / n * (n - freq) / (n - 1);
            expectedSize += 1.0 * (n - freq) / n * freq / (n - 1);
            expectedSize += 1.0 * freq / n * (freq - 1) / (n - 1);
        }

        System.out.printf("%.11f\n", expectedSize);
    }
}

