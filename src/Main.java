import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        ListNode l1 = new ListNode(3);
        l1 = new ListNode(4, l1);
        l1 = new ListNode(2, l1);

        ListNode l2 = new ListNode(4);
        l2 = new ListNode(6, l2);
        l2 = new ListNode(5, l2);

        m.addTwoNumbers(l1, l2);

        Stack<Integer> s = new Stack<>();

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        Stack<Integer> s = new Stack<>();

        int sum;
        int carry = 0;
        int val;

        while(cur1 != null && cur2 != null){
            sum = cur1.val + cur2.val + carry;
            carry = 0;
            if(sum >= 10){
                sum = sum % 10;
                carry = 1;
            }

            s.push(sum);
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while(cur1 != null) {
            sum = cur1.val +  carry;
            carry = 0;
            if(sum >= 10){
                sum = sum % 10;
                carry = 1;
            }

            s.push(sum);
            cur1 = cur1.next;
        }

        while(cur2 != null) {
            sum = cur2.val +  carry;
            carry = 0;
            if(sum >= 10){
                sum = sum % 10;
                carry = 1;
            }

            s.push(sum);
            cur2 = cur2.next;
        }

        if (carry == 1)
            s.push(carry);

        ListNode l3 = new ListNode(s.pop());

        while(!s.empty()){
            val = s.pop();
            l3 = new ListNode(val, l3);
            System.out.println(val);
        }

        ListNode cur = l3;
        while(cur != null){
            System.out.print(cur.val);
            cur = cur.next;
        }


        return l3;
    }
}
