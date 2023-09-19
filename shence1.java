import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class shence1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String[] stapleItems = in.nextLine().split(" ");
        String[] drinkItems = in.nextLine().split(" ");
        int x = Integer.parseInt(in.nextLine());

        int[] staples = new int[stapleItems.length];
        int[] drinks = new int[drinkItems.length];

        for (int i = 0; i < stapleItems.length; i++) {
            staples[i] = Integer.parseInt(stapleItems[i]);
        }

        for (int i = 0; i < drinkItems.length; i++) {
            drinks[i] = Integer.parseInt(drinkItems[i]);
        }

        Arrays.sort(staples);
        Arrays.sort(drinks);

        long count = 0;

        for (int staple : staples) {
            if (staple <= x) {
                count++;
            }
        }

        for (int drink : drinks) {
            if (drink <= x) {
                count++;
            }
        }

        int j = drinks.length - 1;
        for (int i = 0; i < staples.length; i++) {
            while (j >= 0 && staples[i] + drinks[j] > x) {
                j--;
            }
            count += (j + 1);
        }

        System.out.println(count);

    }
}