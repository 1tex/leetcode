import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class shein1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int totalLines = in.nextInt();

        int currentTokens = 100;
        int maxTokens = 150;
        int tokenRate = 10;
        int lastTime = 0;

        int limitedRequests = 0;

        for (int i = 0; i < totalLines; i++) {
            int currentTime = in.nextInt();
            int requestCount = in.nextInt();

            int newTokens = (currentTime - lastTime) / 100 * tokenRate;

            currentTokens = Math.min(maxTokens, currentTokens + newTokens);

            if (requestCount <= currentTokens) {
                currentTokens -= requestCount;
            } else {
                limitedRequests += (requestCount - currentTokens);
                currentTokens = 0;
            }

            lastTime = currentTime;
        }
        System.out.println(limitedRequests);
    }
}












