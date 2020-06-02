package june.week1;

import may.ListNode;

public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        if(node.next == null){
            node = null;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
