package july21.week3;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray
{
    int copy[];
    int nums[];
    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        copy = new int[nums.length];

        for(int i =0; i< nums.length; i++){
            copy[i] = nums[i];
        }

    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return copy;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int l = nums.length;
        if(l ==1) return nums;
        int startIndex = (int)(Math.random()*10) %l;
        int swapIndex = startIndex==0? startIndex+1: startIndex -1;
        //swap
        int t = nums[startIndex];
        nums[startIndex]= nums[swapIndex];
        nums[swapIndex] = t;

        return nums;
    }
}
