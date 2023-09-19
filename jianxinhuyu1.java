

import java.util.*;


public class jianxinhuyu1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 求奇序列数
     * @param nNum int整型 指定的数字
     * @return int整型
     */
    public int Calc (int nNum) {
        // write code here
        int left = 1, right = 1;
        int count = 0;
        int sum = 1;

        while (left <= nNum / 2) {
            if (sum < nNum) {
                right += 2;
                sum += right;
            } else if (sum > nNum) {
                sum -= left;
                left += 2;
            } else {
                count++;
                sum -= left;
                left += 2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        jianxinhuyu1 solution = new jianxinhuyu1();
        System.out.println(solution.Calc(12));
        System.out.println(solution.Calc(16));
        System.out.println(solution.Calc(17));
    }

}