//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//// 注意类名必须为 Main, 不要有任何 package xxx 信息
//public class zhaohang1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//
//        List<Integer> L = new ArrayList<>();
//        List<Integer> G = new ArrayList<>();
//
//        for (int i= 0; i < n; i++) {
//            prefixes[i] = in.next();
//            times[i] = in.nextInt();
//            if (prefixes[i].equals("G")) {
//                t_min = Math.max(t_min, times[i]);
//            } else {
//                t_max = Math.min(t_max, times[i]);
//            }
//        }
//
//        int countG = 0;
//        int countL = 0;
//        for (int i = 0; i < n; i++) {
//            if (prefixes[i].equals("G") && times[i] > t_max) {
//                countG++;
//            } else if (prefixes[i].equals("L") && times[i] < t_min) {
//                countL++;
//            }
//        }
//        System.out.println(Math.min(countG, countL));
//    }
//}