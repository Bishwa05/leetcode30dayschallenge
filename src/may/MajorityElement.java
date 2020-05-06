package may;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElementBest(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        return majorityElement(nums, 0);
    }

    /**
     * Time complexity is O(n).
     *
     */
    private int majorityElement(int[] nums, int start){
        int count = 1;
        int num = nums[start];
        for(int i = start+1;i<nums.length;i++){
            if(num == nums[i]) count++;
            else count--;
            if(count == 0) return majorityElement(nums,i+1);
        }
        return num;
    }

    /**
     * Another approach.
     * Just sort the array, the majority element definitely will be at mid.
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[(nums.length/2)];

    }
}
