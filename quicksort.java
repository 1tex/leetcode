//public class quicksort {
//    public static void main(String[] args) {
//
//    }
//
//    public static void quicksort(int[] arr, int low, int high) {
//        if (low < high) {
//            int pivot = partition(arr, low, high);
//            quicksort(arr, low, pivot - 1);
//            quicksort(arr, pivot + 1, high);
//        }
//    }
//
//    public static int partition(int[] arr, int low, int high) {
//        int i = low - 1;
//        int p = arr[high];
//        for (int j = low; j < high; j++) {
//            if (arr[j] < p) {
//                i++;
//                swap(arr, i, j);
//            }
//            swap(arr, i + 1, high);
//        }
//        return i + 1;
//    }
//}
