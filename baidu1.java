import java.util.*;

public class baidu1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }
        Collections.sort(numbers);
        double result = 0, totalSum = 0;
        int elementsCount = 0;
        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                result += numbers.get(i);
            } else {
                totalSum += numbers.get(i);
                elementsCount += 1;
            }
        }
        result += totalSum / elementsCount;
        System.out.printf("%.10f\n", result);
    }
}



