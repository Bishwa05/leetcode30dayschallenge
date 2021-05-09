package may21.week2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * Given an array of integers target. From a starting array, A consisting of all 1's, you may perform the following procedure :
 *
 * let x be the sum of all elements currently in your array.
 * choose index i, such that 0 <= i < target.size and set the value of A at index i to x.
 * You may repeat this procedure as many times as needed.
 * Return True if it is possible to construct the target array from A otherwise return False.
 *
 *
 *
 * Example 1:
 *
 * Input: target = [9,3,5]
 * Output: true
 * Explanation: Start with [1, 1, 1]
 * [1, 1, 1], sum = 3 choose index 1
 * [1, 3, 1], sum = 5 choose index 2
 * [1, 3, 5], sum = 9 choose index 0
 * [9, 3, 5] Done
 *
 *
 */
public class ConstructTargetArrayWithMultipleSums
{

    public boolean isPossible(int[] target) {
        if(target.length ==0) return true;
        if(target.length == 1){
            if(target[0] ==1) return true;
            else return false;
        }

        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        long sum =0;

        for(int x: target){
            pq.offer(x);
            sum+=x;
        }

        while(sum > target.length){
            int val = pq.poll();
            if(val ==1)return true;
            if(val>sum - val){
                if(pq.peek() ==1)return true;

                long tmp = sum -val;
                long sub = val/tmp;
                Long num = val%tmp;
                if(num.intValue() ==0) return false;
                pq.offer(num.intValue());
                sum -= tmp* sub;
            } else return false;
        }
        return true;
    }

    public static void main(String arg[]){
        ConstructTargetArrayWithMultipleSums c = new
            ConstructTargetArrayWithMultipleSums();
        int[] nums = {9,3,5};
        c.isPossible(nums);
    }
}
