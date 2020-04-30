package april.week4;

import java.util.HashMap;

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

    //optimised
    public static int subarraySum2(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String arg[]){
        int [] nums = {-1,-1,1};
        int k = 0;
        System.out.println(subarraySum2(nums, k));
    }
}
