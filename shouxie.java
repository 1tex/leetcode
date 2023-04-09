import java.math.BigInteger;
import java.util.Scanner;

public class shouxie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(findClosePair(n));
    }

    private static String findClosePair(int n) {
        int x = 1, y = 1;
        BigInteger minDiff = BigInteger.valueOf(Long.MAX_VALUE);

        BigInteger[] factorials = factorial(n);

        for (int i = 1; i <= n; i++) {

            BigInteger fi = factorials[i];
            int j = binary(i, n, factorials);
            BigInteger diff = fi.multiply(BigInteger.valueOf(j)).subtract(BigInteger.valueOf(j)).subtract(BigInteger.valueOf(n)).abs();
            if (diff.compareTo(minDiff) < 0) {
                minDiff = diff;
                x = i;
                y = j;
            }
            if (minDiff.equals(BigInteger.ZERO)) {
                break;
            }
        }
        return  x + " " + y;
    }

    private static BigInteger[] factorial(int n) {
        BigInteger[] fact = new BigInteger[n + 1];
        fact[0] = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1].multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    public static int binary(int i, int n, BigInteger[] factorials) {
        int left = 1, right = n;
        BigInteger fi = factorials[i];
        BigInteger target = BigInteger.valueOf(n);
        while (left < right) {
            int mid = left + (right - left) / 2;
            BigInteger values = fi.multiply(BigInteger.valueOf(mid)).subtract(BigInteger.valueOf(mid));
            if (values.compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return  left;
    }

}
