//小欧想要构造一个合法的括号序列满足以下条件：
//
//        1.括号序列长度恰好为2 \times n。
//        2.括号序列的嵌套层数最大值为r。
//
//
//        括号嵌套层数是指在一个字符串中，以左括号 "(" 和右括号 ")" 形成的括号对的最大嵌套深度。
//        例如，在字符串 "((())())" 中，括号嵌套层数最大值为 3。
//        输入描述
//        一行两个整数n, r(1 \leq r \leq n \leq 10^5)。
//        输出描述
//        一行一个字符串表示括号序列。若有多种构造方案，输出任意一个即可。
//        示例1
//        输入输出示例仅供调试，后台判题数据一般不包含示例
//        输入
//        复制
//        3 2
//        输出
//        复制
//        ()(())

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class oppo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < r; i++) {
            sb.append('(');
        }

        for (int i = 0; i < n - r; i++) {
            sb.append(")(");
        }

        for (int i = 0; i < r; i++) {
            sb.append(')');
        }

        System.out.println(sb.toString());
    }
}