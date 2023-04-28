import java.util.Scanner;

public class meituans1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int C = scanner.nextInt();
        for (int c = 0; c < C; c++) {
            String S = scanner.next();
            String T = scanner.next();
            System.out.println(minOps(S, T));
        }
    }

    private static int minOps(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();
        int count = 0, pos = 0;
        if (sLen > tLen) {
            count = sLen - tLen;
            pos = tLen - 1;
        } else {
            pos = sLen - 1;
        }
        while (pos >= 0) {
            if (S.charAt(pos) != T.charAt(pos)) {
                count++;
            }
            pos--;
        }
        return count;
    }
}
