import java.math.BigInteger;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class minsheng2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int t = in.nextInt();
        in.nextLine();
        while (t-- > 0) {
            String[] parts = in.nextLine().split(" ");
            BigInteger x = new BigInteger(parts[0]);
            char chr = parts[1].charAt(0);
            System.out.println(chr);

            if (canDecompose(x, chr)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean canDecompose(BigInteger x, char chr) {
        while (x.compareTo(BigInteger.ZERO) > 0 && chr >= 'a') {
            BigInteger diff = BigInteger.valueOf(chr - 'a');
            BigInteger needed = diff.multiply(BigInteger.valueOf(2)).add(BigInteger.ONE);
            if (x.compareTo(needed) >= 0) {
                x = x.subtract(needed);
            } else {
                break;
            }
            chr = 'a';
        }
        return x.equals(BigInteger.ZERO);
    }
}