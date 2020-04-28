package week4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class FirstUnique2 {
    Deque<Integer> q;
    Map<Integer,Integer> map;

    public FirstUnique2(int[] nums) {
        map = new HashMap<>();
        q = new ArrayDeque<>();

        for(int i =0; i<nums.length; i++){
            int element = nums[i];
            add(element);
        }
    }

    public int showFirstUnique() {
        if(q.size() ==0){
            return -1;
        }

        while(q.size()>0 && map.get(q.peek())>=2){
            q.poll();
        }

        if(q.size() ==0){
            return -1;
        }
        return q.peek();
    }

    public void add(int value) {
        if(map.containsKey(value)){
            map.put(value, map.get(value)+1);
        }else{
            map.put(value, 1);
        }

        q.add(value);
    }

    public static void main(String arg[]) {
        int arr[] = {2,3,5};
        FirstUnique firstUnique = new FirstUnique(arr);

        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        System.out.println(firstUnique.showFirstUnique()); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique()); // return -1


//        int arr[] = {7,7,7,7,7,7};
//        FirstUnique2 firstUnique = new FirstUnique2(arr);
//
//        System.out.println(firstUnique.showFirstUnique()); // return -1
//        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
//        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
//        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
//        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
//        firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
//        System.out.println(firstUnique.showFirstUnique()); // return 17
    }
}
