import java.util.Scanner;
import java.util.StringTokenizer;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class zhongjinsuojishu3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String priceInput = in.nextLine();
        int fee = in.nextInt();

        StringTokenizer st = new StringTokenizer(priceInput, ",");
        int[] prices = new int[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            prices[i++] = Integer.parseInt(st.nextToken());
        }
        System.out.println(maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}