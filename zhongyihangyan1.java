import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class ListNode<T> {
    public T data;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(T data) {
        this.data = data;
        this.next = null;
    }
}


class Solution {

    public ListNode<Long> mergeTwoLists(ListNode<Integer> list_a, ListNode<Integer> list_b) {
        ListNode<Long> dummy = new ListNode<>();
        ListNode<Long> current = dummy;

        while (list_a != null && list_b != null) {
            if (list_a.data <= list_b.data) {
                current.next = new ListNode<Long>((long) list_a.data);
                list_a = list_a.next;
            } else {
                current.next = new ListNode<Long>((long) list_b.data);
                list_b = list_b.next;
            }
            current = current.next;
        }

        while (list_a != null) {
            current.next = new ListNode<Long>((long) list_a.data);
            list_a = list_a.next;
            current = current.next;
        }

        while (list_b != null) {
            current.next = new ListNode<Long>((long) list_b.data);
            list_b = list_b.next;
            current = current.next;
        }

        return dummy.next;
    }
}


public class zhongyihangyan1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode<Long> res = null;

        int list_a_size = 0;
        list_a_size = in.nextInt();
        ListNode<Integer> list_a = null, list_a_curr = null;
        for(int list_a_i = 0; list_a_i < list_a_size; list_a_i++) {
            int list_a_item = in.nextInt();
            ListNode<Integer> list_a_temp = new ListNode<Integer>();
            list_a_temp.data = list_a_item;
            list_a_temp.next = null;

            if (list_a == null) {
                list_a = list_a_curr = list_a_temp;
            } else {
                list_a_curr.next = list_a_temp;
                list_a_curr = list_a_temp;
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        int list_b_size = 0;
        list_b_size = in.nextInt();
        ListNode<Integer> list_b = null, list_b_curr = null;
        for(int list_b_i = 0; list_b_i < list_b_size; list_b_i++) {
            int list_b_item = in.nextInt();
            ListNode<Integer> list_b_temp = new ListNode<Integer>();
            list_b_temp.data = list_b_item;
            list_b_temp.next = null;

            if (list_b == null) {
                list_b = list_b_curr = list_b_temp;
            } else {
                list_b_curr.next = list_b_temp;
                list_b_curr = list_b_temp;
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = new Solution().mergeTwoLists(list_a, list_b);
        while (res != null) {
            System.out.print(String.valueOf(res.data) + " ");
            res = res.next;
        }
        System.out.println();

    }
}
