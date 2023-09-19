import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class xinye1 {
    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();
        Object lockC = new Object();

        new Thread(() -> {
            synchronized (lockA) {
                for (int i = 0; i < 10; i++) {
                    synchronized (lockB) {
                        lockB.notify();
                    }
                }
            }
        }


        )
    }
}