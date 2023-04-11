import java.util.*;
import java.io.*;

public class xiaohongshu3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String colors = reader.readLine();
        int m = Integer.parseInt(reader.readLine());
        int[] times = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] operations = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        reader.close();

        int[] bag = new int[n + 1];
        int currentTime = 0;
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int time = times[i];
            int operation = operations[i];

            for (int j = 1; j <= n; j++) {
                if (bag[j] != 0) {
                    if (colors.charAt(j - 1) == 'R') {
                        nums[j - 1] += (time - currentTime);
                    } else {
                        nums[j - 1] -= (time - currentTime);
                    }
                }
            }
            currentTime = time;

            if (operation == 0) {
                int sum = 0;
                for (int j = 1; j <= n; j++) {
                    if (bag[j] != 0) {
                        sum += nums[j - 1];
                    }
                }
                results.add(sum);
            } else if (operation > 0) {
                bag[operation]++;
            } else {
                bag[-operation]--;
            }
        }

        System.out.print(results.size());
        for (Integer result : results) {
            System.out.print(" " + result);
        }
        System.out.println();
    }
}
