import java.util.Arrays;
import java.util.Scanner;

public class mashi1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        String sortedString = new String(chars);

        System.out.println(sortedString);

    }
}