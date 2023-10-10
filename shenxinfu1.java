import java.util.Stack;

public class shenxinfu1 {
    public String get_substr(String st) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : st.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() != ch) {
                int count = 0;
                char prevChar = stack.peek();
                while (!stack.isEmpty() && stack.peek() == prevChar) {
                    stack.pop();
                    count++;
                }
                if (count < 3) {
                    for (int i = 0; i < count; i++) {
                        sb.append(prevChar);
                    }
                }
            }

            stack.push(ch);
        }

        int count = 0;
        char prevChar = stack.isEmpty() ? ' ' : stack.peek();
        while (!stack.isEmpty() && stack.peek() == prevChar) {
            stack.pop();
            count++;
        }
        if (count < 3) {
            for (int i = 0; i < count; i++) {
                sb.append(prevChar);
            }
        }

        String result = sb.toString();
        return result.equals(st) ? result : get_substr(result);
    }

}
