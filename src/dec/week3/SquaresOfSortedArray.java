package dec.week3;

import java.util.Arrays;

public class SquaresOfSortedArray
{
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            res[i] = (nums[i]>0)? nums[i] : nums[i]*-1;
        }
        Arrays.sort(res);

        for(int i=0; i<nums.length; i++){
            res[i] = res[i]*res[i];
        }

        return res;
    }
}
