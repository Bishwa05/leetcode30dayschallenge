package week2;

import java.util.ArrayList;
import java.util.List;

/**
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */

public class MinStack {
    int min;
    List stackList;
    int index;

    class Node{
        int x;
        int min;

        Node(int x, int min){
            this.x = x;
            this.min  =  min;
        }

    }
    public MinStack() {
         this.stackList =  new ArrayList();
         index =-1;
    }

    public void push(int x) {
        if(stackList.size()==0){
            min = x;
        }
        if(min>x) min = x;

        Node n = new Node(x, min);

        stackList.add(n);
        index++;

    }

    public void pop() {
        if(index>=0) {
            stackList.remove(index);
            --index;
            int nodeMin = ((Node)stackList.get(index)).min;
            if(min<nodeMin){
                min = nodeMin;
            }
        }

    }

    public int top() {
        if(index>=0){
            return ((Node)stackList.get(index)).x;
        }
        return -1;
    }

    public int getMin() {
        if(index>=0){
            return ((Node)stackList.get(index)).min;
        }
        return -1;

    }

    public static void main(String arg[]){
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin());   //--> Returns -3.
//        minStack.pop();
//        System.out.println(minStack.top());      //--> Returns 0.
//        System.out.println(minStack.getMin());   //--> Returns -2.


//        MinStack minStack = new MinStack();
//        minStack.push(2);
//        minStack.push(0);
//        minStack.push(3);
//        minStack.push(0);
//        System.out.println(minStack.getMin());   //--> Returns 0.
//        minStack.pop();
//        System.out.println(minStack.getMin());   //--> Returns 0.
//        minStack.pop();
//        System.out.println(minStack.getMin());   //--> Returns 0.
//        minStack.pop();
//        System.out.println(minStack.getMin());   //--> Returns 2.

        /**
         * ["MinStack","push","push",
         * "getMin","getMin",
         * "push",
         * "getMin","getMin",
         * "top",
         * "getMin",
         * "pop",
         * "push","push",
         * "getMin",
         * "push",
         * "pop",
         * "top",
         * "getMin",
         * "pop"]
         * [[],[-10],[14],[],[],[-20],[],[],[],[],[],[10],[-7],[],[-7],[],[],[],[]]
         */

        MinStack minStack = new MinStack();
        minStack.push(-10);
        minStack.push(14);
        System.out.println(minStack.getMin());
        System.out.println(minStack.getMin());
        minStack.push(-20);
        System.out.println(minStack.getMin());
        System.out.println(minStack.getMin()); //--> Returns -3.
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(10);
        minStack.push(-7);
        System.out.println(minStack.getMin());
        minStack.push(-7);
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
    }
}
