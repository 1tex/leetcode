import java.text.DecimalFormat;
import java.util.Scanner;

public class dewu2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int side1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int side2 = sc.nextInt();

        double overlapX = Math.min(x1 + side1 / 2.0, x2 + side2/2.0) - Math.max(x1 - side1/2.0, x2 - side2/2.0);
        double overlapY = Math.min(y1 + side1 / 2.0, y2 + side2/2.0) - Math.max(y1 - side1/2.0, y2 - side2/2.0);

        double area = 0.0;
        if (overlapX > 0 && overlapY > 0) {
            area = overlapX * overlapY;
        }

        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(area));
    }
}
