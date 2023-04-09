import java.util.Scanner;

public class mayi3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        int n = s.length();
        int count_red = 0;
        int[] count_palindrome = new int[n];
        count_palindrome[0] = 1;

        for (int i = 1; i < n; i++) {
            if (s.substring(i-1, i+1).equals("red")) {
                count_red += count_palindrome[Math.max(i-2, 0)];
            }
            if (i > 1 && s.substring(i-2, i+1).equals("red")) {
                count_red += count_palindrome[Math.max(i-3, 0)];
            }
            if (s.charAt(i) == s.charAt(i-1)) {
                count_palindrome[i] = count_palindrome[Math.max(i-2, 0)] + 1;
            } else if (i > 1 && s.charAt(i) == s.charAt(i-2)) {
                count_palindrome[i] = count_palindrome[Math.max(i-3, 0)] + 1;
            } else {
                count_palindrome[i] = 1;
            }
        }

        System.out.println(count_red);
        sc.close();
    }
}
