package oct.week2;

import may.ListNode;

public class SortList
{
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge (left, right);

    }

    ListNode merge(ListNode list1, ListNode list2){
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while(list1 != null && list2 != null){
            if(list1.val<list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null)?list1:list2;
        return dummyHead.next;
    }

    ListNode getMid(ListNode head){
        ListNode p2 = null;

        while(head != null && head.next != null){
            p2 = (p2 == null)?head: p2.next;
            head = head.next.next;
        }
        ListNode mid = p2.next;
        p2.next = null;
        return mid;
    }
}
