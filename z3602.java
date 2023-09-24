import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class z3602 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        HashSet<Integer> uniqueFeatures = new HashSet<>(map.keySet());

        int count = 0;
        int newFeature = 0;
        for (int key : uniqueFeatures) {
            int val = map.get(key);
            while (val > 1) {
                while (uniqueFeatures.contains(newFeature)) {
                    newFeature++;
                }
                map.put(newFeature, 1);
                val--;
                count++;
                newFeature++;
            }
        }

        System.out.println(count);
    }


}