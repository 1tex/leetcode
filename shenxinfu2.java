import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class shenxinfu2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long x = scanner.nextLong();
        long[][] tuples = new long[N][2];

        for (int i = 0; i < N; i++) {
            tuples[i][0] = scanner.nextLong();
            tuples[i][1] = scanner.nextLong();
        }

        Arrays.sort(tuples, Comparator.comparingLong(a -> a[0]));

        long maxSum = 0;
        long currentSum = 0;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        int j = 0;
        for (int i = 0; i < N; i++) {
            currentSum += tuples[i][1];
            minHeap.offer(tuples[i][1]);

            while (tuples[i][0] - tuples[j][0] > x) {
                currentSum -= tuples[j][1];
                minHeap.remove(tuples[j][1]);
                j++;
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        System.out.println(maxSum);
    }
}
