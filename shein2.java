//对于一个给定字符串 s 和行数 row，我们可以对这个字符串进行从上往下，从左到右进行Z字形排列。
//
//        比如输入字符串s为 "SHEINFORALL" ，行数row为3时，我们可以得到以下排列:
//
//        S      N      A
//
//        H  I  F  R  L
//
//        E      O      L
//
//        完成变换后，输出需要从左往右逐行读取，由此我们得到了一个新的字符串，如上述字符串就变成了 "SNAHIFRLEOL"。
//
//        请你实现对字符串进行指定行数变换。
//
//        输入描述
//        SHEINFORALL,4
//        输出描述
//        SOHFRENALIL
//        示例1
//        输入输出示例仅供调试，后台判题数据一般不包含示例
//        输入
//        复制
//        A,1
//        输出
//        复制
//        A
//        备注
//        1. 1<=input.length<=1000
//        2.  input由英文字母(大小写)组成
//        3. 1<=rows<=1000

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class shein2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String [] parts = line.split(",");
        String input = parts[0];
        int rows = Integer.parseInt(parts[1]);

        if (rows == 1) {
            System.out.println(input);
            return;
        }

        StringBuilder[] sb = new StringBuilder[rows];

        for (int i = 0; i < rows; i++) {
            sb[i] = new StringBuilder();
        }

        int index = 0;
        boolean down = false;

        for (char c : input.toCharArray()) {
            sb[index].append(c);

            if (index == 0 || index == rows - 1) {
                down = !down;
            }

            index += down ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder s : sb) {
            result.append(s);
        }

        System.out.println(result.toString());
    }
}