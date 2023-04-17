import java.util.Scanner;

public class hyx3602 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // 读取换行符
        while (t-- > 0) {
            String equation = scanner.nextLine();
            boolean flag = false;
            for (int i = 0; i < equation.length(); i++) {
                if (equation.charAt(i) == '+' || equation.charAt(i) == '*' || equation.charAt(i) == '=') {
                    for (int j = 0; j <= 9; j++) {
                        String newEquation = equation.substring(0, i) + j + equation.substring(i);
                        if (checkEquation(newEquation)) {
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag) break;
            }
            if (!flag) {
                for (int i = 0; i <= 9; i++) {
                    String newEquation = equation + i;
                    if (checkEquation(newEquation)) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    // 判断方程是否成立
    private static boolean checkEquation(String equation) {
        String[] parts = equation.split("=");
        int leftValue = calculate(parts[0]);
        int rightValue = calculate(parts[1]);
        return leftValue == rightValue;
    }

    // 计算表达式的值
    private static int calculate(String expression) {
        int value = 0;
        int num = 0;
        char operator = '+';
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            }
            if (ch == '+' || ch == '*' || i == expression.length() - 1) {
                if (operator == '+') {
                    value += num;
                } else {
                    value *= num;
                }
                operator = ch;
                num = 0;
            }
        }
        return value;
    }
}
