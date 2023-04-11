import java.util.Scanner;

public class baidu2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int temp = 0, index = 0, c = 1;
        StringBuffer buffer = new StringBuffer();
        while (x > 0) {
            temp = 0;
            for (int i = 1; i < 9999999; i++) {
                temp += i;
                if (temp > x) {
                    temp -= i;
                    index = i - 1;
                    break;
                }
            }
            if (c == 1) {
                for (int i = 0; i < index; i++) {
                    buffer.append("d");
                }
                c++;
            } else if (c == 2) {
                for (int i = 0; i < index; i++) {
                    buffer.append("e");
                }
                c++;
            } else {
                for (int i = 0; i < index; i++) {
                    buffer.append("r");
                }
                c = 1;
            }
            x = x - temp;
        }
        System.out.println(buffer.toString());
    }
}
