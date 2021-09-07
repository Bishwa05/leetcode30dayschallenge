package sept21;

import may.ListNode;

public class ReverseALinkedList
{
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head.next;
        ListNode prev = head;

        while(curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;

        }
        head.next = null;
        return prev;

    }

    public static void main (String[] args)
    {
        ReverseALinkedList r = new ReverseALinkedList();
        ListNode x = new ListNode(1);
        x.next = new ListNode(2);
        x.next.next = new ListNode(3);
        x.next.next.next = new ListNode(4);
        x.next.next.next.next = new ListNode(5);

        r.reverseList(x);

    }
}
