import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        String[] strArray = input.split(" ");
        int[] nums = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            if (!strArray[i].isEmpty()) {
                nums[i] = Integer.parseInt(strArray[i]);
            }
        }

        int maxLength = 0;
        int start = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int end = 0; end < nums.length; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

            while (map.get(nums[end]) > 1) {
                map.put(nums[start], map.get(nums[start]) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        System.out.println(maxLength);
    }
}
