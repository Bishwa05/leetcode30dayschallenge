package april.week4;

import java.util.HashMap;

public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node head;
    Node tail;
    HashMap<Integer, Node> m;
    int size;

    public LRUCache(int capacity) {
        m = new HashMap<>();
        size = capacity;
    }

    public int get(int key) {
        if(m.get(key)==null){
            return -1;
        }

        //Move to tail
        Node t = m.get(key);

        removeNode(t);
        offerNode(t);
        return t.value;
    }

    public void put(int key, int value) {
        if(m.containsKey(key)){
            Node t = m.get(key);
            t.value= value;

            //move to tail
            removeNode(t);
            offerNode(t);
        }else {
            if(m.size()>=size){
                //delete head
                m.remove(head.key);
                removeNode(head);
            }
            //add to tail
            Node node = new Node(key, value);
            offerNode(node);
            m.put(key,node);
        }

    }

    private void removeNode(Node n){
        if(n.prev != null){
            n.prev.next = n.next;
        } else{
            head = n.next;
        }

        if(n.next != null){
            n.next.prev = n.prev;
        }else{
            tail = n.prev;
        }
    }

    private void offerNode(Node n){
        if(tail != null){
            tail.next = n;
        }
        n.prev = tail;
        n.next = null;
        tail = n;

        if(head == null) {
            head = tail;
        }
    }

    //More efficient pu
    public void put2(int key, int value) {
        Node node = m.get(key);
        if(node == null) {
            // add new node
            node = new Node(key, value);
            if(size == 0) {
                // ran out of space
                m.remove(head.key);
                head = head.next;
                size++;
            }
            if(head == null) {
                head = node;
            } else {
                tail.next = node;
                node.prev = tail;
            }
            tail = node;
            m.put(key, node);
            size--;
        } else {
            // update the existing node with the value
            node.value = value;
            if(node != tail) {
                if(node == head) {
                    head = head.next;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }

                tail.next = node;
                node.prev = tail;
                node.next = null;
                tail = node;
            }
        }
    }

    //More efficient get
    public int get2(int key) {
        Node node = m.get(key);
        if(node == null) return -1;

        // node exists in the cache
        if(node != tail) {
            if(node == head) {
                head = head.next;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            // move the curr node to the end/tail
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }

        return node.value;
    }

    public static void main(String arg[]) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);                        // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);                        // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
