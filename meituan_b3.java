//小美定义一个字符串是“美丽串”，当且仅当该字符串包含"mei"连续子串。例如"meimei"、"xiaomeichan"都是美丽串，而"meeii"则不是美丽串。
//        现在小美拿到了一个字符串，她准备删除一些字符，但不能删除两个连续字符。
//        小美希望最终字符串变成美丽串，她想知道有多少种删除方案？
//        输入描述
//        一个仅包含小写字母的字符串，长度不超过 20。
//        输出描述
//        删除的方案数。
//        示例1
//        输入输出示例仅供调试，后台判题数据一般不包含示例
//        输入
//        复制
//        meili
//        输出
//        复制
//        3
//        说明
//        方案 1：什么都不删
//        方案 2：删除第四个字符。
//        方案 3：删除第五个字符。
//        示例2
//        输入输出示例仅供调试，后台判题数据一般不包含示例
//        输入
//        复制
//        meei
//        输出
//        复制
//        2

import java.util.Scanner;

public class meituan_b3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = s.length();
        int count = 0;

        for (int mask = 0; mask < (1 << n); ++mask) {
            if (isValid(s, mask)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isValid(String s, int mask) {
        StringBuilder sb = new StringBuilder();
        int last = -2;

        for (int i = 0; i < s.length(); ++i) {
            if ((mask & (1 << i)) == 0) {
                sb.append(s.charAt(i));
            } else {
                if (last == i - 1) {
                    return false;
                }
                last = i;
            }
        }

        return sb.toString().contains("mei");
    }
}