import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] numbers = input.substring(1, input.length() - 1).split(",");
        int a = Integer.parseInt(numbers[0].trim());
        int b = Integer.parseInt(numbers[1].trim());
        int c = Integer.parseInt(numbers[2].trim());

        if (formTriangle(a, b, c)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        in.close();
    }

    public static boolean formTriangle(int a, int b, int c) {
        int levelA = findLevel(a);
        int levelB = findLevel(b);
        int levelC = findLevel(c);

        int posA = a - (levelA * (levelA - 1)) / 2;
        int posB = b - (levelB * (levelB - 1)) / 2;
        int posC = c - (levelC * (levelC - 1)) / 2;

        // Check conditions for forming a triangle
        return Math.abs(levelA - levelB) == 1 && Math.abs(levelB - levelC) == 1 && posA == posB && Math.abs(posB - posC) == 1;
    }

    public static int findLevel(int x) {
        int level = (int) Math.ceil((Math.sqrt(1 + 8 * x) - 1) / 2);
        return level;
    }
}