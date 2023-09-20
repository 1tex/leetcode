import java.util.HashMap;
import java.util.Scanner;

public class dewu1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String formula = sc.nextLine();
        sc.close();

        HashMap<Character, Integer> atomicWeight = new HashMap<>();
        atomicWeight.put('C', 12);
        atomicWeight.put('H', 1);
        atomicWeight.put('O', 16);
        atomicWeight.put('N', 14);

        int totalWeight = 0;
        int i = 0;
        while (i < formula.length()) {
            char element = formula.charAt(i);
            int count = 0;
            i++;

            while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                count = count*10 + (formula.charAt(i) -  '0');
                i++;
            }

            if (count == 0) {
                count = 1;
            }

            totalWeight += atomicWeight.get(element) * count;
        }
        System.out.println(totalWeight);
    }

}
