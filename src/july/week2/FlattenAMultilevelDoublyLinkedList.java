package july.week2;

import july.Node;

import java.util.Stack;

/**
 *
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 *
 */

public class FlattenAMultilevelDoublyLinkedList
{

    public Node flatten(Node head) {

        Node temp = head;
        Stack<Node> s = new Stack();

        while(head != null){
            if(head.child != null){
                if(head.next != null){
                    s.push(head.next);
                }

                head.next = head.child;
                head.next.prev = head;
                head.child = null;
            } else if(head.next != null && !s.isEmpty()) {
                head.next = s.pop();
                head.next.prev = head;

            }
            head = head.next;

        }
        return temp;

    }

}
