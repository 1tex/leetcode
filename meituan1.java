import java.util.Scanner;

public class meituan1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.next();
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < a; k++) {
                    if (matrix[i][j].charAt(k) != matrix[(i + 1) % n][(j + 1) % m].charAt(k)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}

