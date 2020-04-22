package week4;

import java.util.Arrays;

public class SubarraySumEqualsK {

    //brute force
    public static int subarraySum(int[] nums, int k) {
        int sumCount =0;

        for(int i =0; i<nums.length; i++){
            int sum =0;
            for(int j =i; j<nums.length; j++){

                sum = sum + nums[j];


                if(sum == k){
                    sumCount++;
                }
            }
        }
        return sumCount;
    }

    public static void main(String arg[]){
        int [] nums = {-1,-1,1};
        int k = 0;
        System.out.println(subarraySum(nums, k));
    }
}
