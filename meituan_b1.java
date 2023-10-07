//如果一个十进制数字只有 0 和 1，那这就是一个类二进制数字。例如：101 和 1100 都是类二进制数字，而 112 和 3001 则不是。
//
//        对于一个数 n，小美想知道最少需要几个类二进制数字相加可以得到。
//        输入描述
//        输入一个正整数 n。
//        1 \leq n \leq 10^{10000}
//        输出描述
//        输出一个正整数，表示最少需要的类二进制数字个数。
//        示例1
//        输入输出示例仅供调试，后台判题数据一般不包含示例
//        输入
//        复制
//        10101
//        输出
//        复制
//        1
//        示例2
//        输入输出示例仅供调试，后台判题数据一般不包含示例
//        输入
//        复制
//        30302
//        输出
//        复制
//        3

//import java.util.Scanner;
//
//// 注意类名必须为 Main, 不要有任何 package xxx 信息
//public class meituan_b1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        int n = in.nextInt();
//        int count = 0;
//        while (n > 0) {
//            String str = Integer.toString(n);
//            char[] chars = str.toCharArray();
//            for (int i = 0; i < chars.length; i++) {
//                if (chars[i] != '0') {
//                    chars[i] = '1';
//                    count++;
//                }
//            }
//            int sub = Integer.parseInt(new String(chars));
//            n -= sub;
//        }
//        System.out.println(count);
//    }
//}

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class meituan_b1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String n = in.nextLine();
        char[] digits = n.toCharArray();
        int maxDigit = 0;
        for (char digitChar : digits) {
            int digit = Character.getNumericValue(digitChar);
            maxDigit = Math.max(maxDigit, digit);
        }
        System.out.println(maxDigit);
    }
}