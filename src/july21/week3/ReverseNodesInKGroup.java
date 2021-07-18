package july21.week3;

import may.ListNode;

public class ReverseNodesInKGroup
{

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k ==1) return head;

        ListNode curr = head, next = null, prev = null;
        int count = k;

        while(curr != null) {
            curr = curr.next;
            count--;
            if(count == 0) break;
        }

        if(count ==0){
            curr = head;
            count =k;
        } else{
            return head;
        }

        //reverse
        while(curr != null && count>0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count--;
        }

        if(next != null){
            head.next = reverseKGroup(next, k);
        }
        return prev;
    }
}
