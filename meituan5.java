import java.util.HashMap;
import java.util.Scanner;

public class meituan5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
        }

        System.out.println(getMax(countMap));
    }

    private static int getMax(HashMap<Integer, Integer> countMap) {
        int k = 1;
         while (countMap.containsKey(k)) {
             int count = countMap.get(k);
             if (count > 1) {
                 countMap.put(k + 1, countMap.getOrDefault(k + 1, 0) + (count - 1));
             }
             k++;
         }
         return k;
    }
}
