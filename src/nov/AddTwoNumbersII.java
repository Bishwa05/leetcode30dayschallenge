package nov;

import may.ListNode;

public class AddTwoNumbersII
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        int len1 =0, len2 = 0;

        ListNode list1 = l1;
        while(list1 != null){
            len1++;
            list1 = list1.next;
        }

        ListNode list2 = l2;
        while(list2 != null){
            len2++;
            list2 = list2.next;
        }

        ListNode result;

        if(len1 >= len2){
            result = helper(l1, l2, len1, len2);
        } else {
            result = helper(l2, l1, len2, len1);
        }

        if(result.val ==0){
            return result.next;
        }
        return result;
    }

    private ListNode helper(ListNode l1, ListNode l2, int len1, int len2){
        if(l1 == null && l2 == null){
            return new ListNode(0);
        }

        ListNode node;
        int nextValue;

        if(len1>len2){
            node = new ListNode(0);
            node.next = helper(l1.next, l2, len1-1, len2);
            nextValue = node.next.val;
            node.next.val = (node.next.val + l1.val)%10;


            if(nextValue + l1.val>=10){
                node.val = (nextValue + l1.val)/10;
            }
            return node;
        }

        node = new ListNode(0);
        node.next = helper(l1.next, l2.next, len1-1, len2-1);
        nextValue = node.next.val;
        node.next.val = (node.next.val + l1.val+ l2.val)%10;

        if(nextValue + l1.val +l2.val>=10){
            node.val = (nextValue + l1.val + l2.val)/10;
        }
        return node;
    }
}
