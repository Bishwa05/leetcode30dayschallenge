package week4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * With Set and a Deque the time limit exceeded in leetcode.
 */
public class FirstUnique {
    Deque<Integer> q;
    Set<Integer> set;

    public FirstUnique(int[] nums) {
        set = new HashSet<>();
        q = new ArrayDeque<>();

        for(int i =0; i<nums.length; i++){
            int element = nums[i];
            if(set.contains(element)){
                if(q.contains(element)) {
                    q.remove(element);
                }
            }else{
               q.addLast(element);
               set.add(element);
            }
        }


    }

    public int showFirstUnique() {
        return q.size()>0?q.getFirst():-1;
    }

    public void add(int value) {
        if(set.contains(value)){
            if(q.contains(value)) {
                q.remove(value);
            }
        }else{
            q.addLast(value);
            set.add(value);
        }
    }

    public static void main(String arg[]) {
//        int arr[] = {2,3,5};
//        FirstUnique firstUnique = new FirstUnique(arr);
//
//        System.out.println(firstUnique.showFirstUnique()); // return 2
//        firstUnique.add(5);            // the queue is now [2,3,5,5]
//        System.out.println(firstUnique.showFirstUnique()); // return 2
//        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
//        System.out.println(firstUnique.showFirstUnique()); // return 3
//        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
//        System.out.println(firstUnique.showFirstUnique()); // return -1


        int arr[] = {7,7,7,7,7,7};
        FirstUnique firstUnique = new FirstUnique(arr);

        System.out.println(firstUnique.showFirstUnique()); // return -1
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
        firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
        System.out.println(firstUnique.showFirstUnique()); // return 17
    }
}
