import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class z3601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int mixCount = 0;
        int nextFeature = 1;

        // 统计每个元素出现的次数
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            countMap.put(a, countMap.getOrDefault(a, 0) + 1);
        }

        // 保存HashMap的键
        HashSet<Integer> uniqueFeatures = new HashSet<>(countMap.keySet());

        // 遍历保存的键，找到重复的特征值并进行处理
        for (Integer key : uniqueFeatures) {
            int occurrences = countMap.get(key);
            while (occurrences > 1) {
                // 找到下一个未使用的特征值
                while (countMap.containsKey(nextFeature)) {
                    nextFeature++;
                }
                countMap.put(nextFeature, 1);
                occurrences--;
                mixCount++;
                nextFeature++;
            }
        }

        System.out.println(mixCount);
    }
}