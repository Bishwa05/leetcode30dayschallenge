package oct.week4;

import may.ListNode;

public class LinkedListCycleII
{
    public ListNode detectCycle(ListNode head) {

        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = head;
        boolean cycleFound = false;

        while(p2!= null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;

            if(p2 != null && p1 == p2){
                cycleFound = true;
                break;
            }
        }

        if(!cycleFound){
            return null;
        }


        while(p3 != p1){
            p3 = p3.next;
            p1 = p1.next;
        }
        return p1;

    }
}
