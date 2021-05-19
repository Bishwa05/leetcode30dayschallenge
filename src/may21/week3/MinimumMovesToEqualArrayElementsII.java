package may21.week3;

import java.util.Arrays;

/**
 *
 * Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
 *
 * In one move, you can increment or decrement an element of the array by 1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: 2
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * Example 2:
 *
 * Input: nums = [1,10,2,9]
 * Output: 16
 *
 */
public class MinimumMovesToEqualArrayElementsII
{
    public int minMoves2(int[] nums) {

        int count = 0;
        Arrays.sort(nums);

        int n = nums.length/2;
        for(int i =0; i<nums.length; i++){
            count += Math.abs(nums[i]-nums[n]);
        }
        return count;

    }
}
