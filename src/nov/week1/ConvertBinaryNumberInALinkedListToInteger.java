package nov.week1;

import may.ListNode;

public class ConvertBinaryNumberInALinkedListToInteger
{


    public int getDecimalValue(ListNode head) {

        int length = 0;
        if(head == null) return 0;
        int result = 0;

        ListNode curr = head;

        while(curr != null){
            curr = curr.next;
            length++;
        }
        length --;
        ListNode curr2 = head;


        while(curr2!= null){
            if(curr2.val !=0)
                result += Math.pow(2, length);
            length--;
            curr2= curr2.next;
        }

        return result;
    }

    public int getDecimalValue2(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = (num << 1) | head.next.val;
            head = head.next;
        }
        return num;
    }
}
