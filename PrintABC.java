public class PrintABC {
    private final Object lock = new Object();
    private volatile int state = 0;

    public static void main(String[] args) {
        PrintABC printABC = new PrintABC();

        // 线程A
        new Thread(() -> {
            for (int i = 0; i < 10;) {
                synchronized (printABC.lock) {
                    if (printABC.state % 3 == 0) {
                        System.out.print("A");
                        i++;
                        printABC.state++;
                        printABC.lock.notifyAll();
                    } else {
                        try {
                            printABC.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        // 线程B
        new Thread(() -> {
            for (int i = 0; i < 10;) {
                synchronized (printABC.lock) {
                    if (printABC.state % 3 == 1) {
                        System.out.print("B");
                        i++;
                        printABC.state++;
                        printABC.lock.notifyAll();
                    } else {
                        try {
                            printABC.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        // 线程C
        new Thread(() -> {
            for (int i = 0; i < 10;) {
                synchronized (printABC.lock) {
                    if (printABC.state % 3 == 2) {
                        System.out.print("C");
                        i++;
                        printABC.state++;
                        printABC.lock.notifyAll();
                    } else {
                        try {
                            printABC.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
