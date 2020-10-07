package oct;

import may.ListNode;

public class RotateList
{
    public ListNode rotateRight(ListNode head, int k) {
        int n = 0;
        ListNode curr = head;

        if(k ==0 || head == null) return head;

        while(curr != null){
            curr = curr.next;
            n++;
        }

        int r = k%n;

        if(r ==0) return head;

        ListNode p1  = head;
        ListNode p2  = head;
        int c= 0;

        while(p1 != null){
            p1 = p1.next;
            c++;
            if (c<n-r) {
                p2 = p2.next;
            }
        }
        ListNode p3 = p2.next;
        //System.out.println(p3.val);
        p2.next = null;
        p2 = head;
        head = p3;
        while(p3.next != null){
            p3 =p3.next;
        }
        // System.out.println(p3.val);
        p3.next = p2;
        return head;
    }
}
