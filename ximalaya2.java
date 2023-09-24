//import java.util.*;
//
//
//public class Solution {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     * 对于给定的若干硬币面值及目标金额，输出组成目标金额的方法数
//     * @param coinValues int整型一维数组 硬币面值
//     * @param targetValue int整型 目标金额
//     * @return int整型
//     */
//    public int count (int[] coinValues, int targetValue) {
//        // write code here
//        int[] dp = new int[targetValue + 1];
//        dp[0] = 1;
//
//        for (int coin : coinValues) {
//            for (int i = coin; i <= targetValue; i++) {
//                dp[i] += dp[i - coin];
//            }
//        }
//
//        return dp[targetValue];
//    }
//}