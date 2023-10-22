import java.util.Scanner;

public class pingan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // 读入进制数
        String M = in.next(); // 读入数字
        int step = 0; // 初始化步数

        while (step <= 30) {
            if (isPalindrome(M)) {
                System.out.println("STEP=" + step);
                return;
            }
            M = addInBaseN(M, N);
            step++;
        }

        System.out.println("Impossible!");
    }

    public static boolean isPalindrome(String num) {
        int left = 0, right = num.length() - 1;
        while (left < right) {
            if (num.charAt(left) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String addInBaseN(String num, int base) {
        StringBuilder result = new StringBuilder();
        StringBuilder reverseNum = new StringBuilder(num).reverse();

        int carry = 0;
        for (int i = 0; i < num.length(); i++) {
            int sum = Character.getNumericValue(num.charAt(i)) + Character.getNumericValue(reverseNum.charAt(i)) + carry;
            carry = sum / base;
            sum = sum % base;
            result.append(Character.forDigit(sum, base));
        }

        if (carry != 0) {
            result.append(Character.forDigit(carry, base));
        }

        return result.reverse().toString();
    }
}
