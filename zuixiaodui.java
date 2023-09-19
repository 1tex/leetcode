import java.util.PriorityQueue;

public class zuixiaodui {

    public static int[] mergeKSortedArrays(int[][] arrays) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int totalLength = 0;

        // 初始化最小堆和总长度
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.offer(new int[]{arrays[i][0], i, 0});
                totalLength += arrays[i].length;
            }
        }

        int[] result = new int[totalLength];
        int index = 0;

        while (!minHeap.isEmpty()) {
            int[] element = minHeap.poll();
            result[index++] = element[0];
            int arrayIndex = element[1], elementIndex = element[2];

            if (elementIndex + 1 < arrays[arrayIndex].length) {
                minHeap.offer(new int[]{arrays[arrayIndex][elementIndex + 1], arrayIndex, elementIndex + 1});
            }
        }

        return result;
    }

}
