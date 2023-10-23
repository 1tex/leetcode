//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//class ListNode<T> {
//    public T data;
//    public ListNode next;
//}
//
//class Solution {
//
//    /* Write Code Here */
//    public int pairSum(ListNode<Integer> head) {
//
//
//    }
//}
//
//public class zhongyihangyan2 {
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int res;
//
//        int head_size = 0;
//        head_size = in.nextInt();
//        ListNode<Integer> head = null, head_curr = null;
//        for(int head_i = 0; head_i < head_size; head_i++) {
//            int head_item = in.nextInt();
//            ListNode<Integer> head_temp = new ListNode<Integer>();
//            head_temp.data = head_item;
//            head_temp.next = null;
//
//            if (head == null) {
//                head = head_curr = head_temp;
//            } else {
//                head_curr.next = head_temp;
//                head_curr = head_temp;
//            }
//        }
//
//        if(in.hasNextLine()) {
//            in.nextLine();
//        }
//
//        res = new Solution().pairSum(head);
//        System.out.println(String.valueOf(res));
//
//    }
//}
