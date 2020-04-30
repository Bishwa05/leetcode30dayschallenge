package april.week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 *
 */
public class ContiguousArray {

    public static int findMaxLength(int[] nums) {
        int result =0;
        int n = nums.length;

        Map<Integer, Integer> h = new HashMap();
        h.put(0, -1);
        int sum =0;
        for (int i=0; i<n; i++) {
            if(nums[i]==0){
                sum -=1;
            }else{
                sum +=1;
            }

            if (h.containsKey(sum)) {
                result = Math.max(result, i - h.get(sum));
            } else {
                h.put(sum, i);
            }

        }

        return result;
    }

    public static int findMaxLength2(int nums[]){
        int[] arr = new int[2 * nums.length + 1];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (arr[count + nums.length] >= -1) {
                maxlen = Math.max(maxlen, i - arr[count + nums.length]);
            } else {
                arr[count + nums.length] = i;
            }

        }
        return maxlen;


    }

    public static void main(String arg[]){
        int arr[] = {0,1,0,0,0,1,0,1};
        //int arr[] = {0,1,0};
        System.out.println(findMaxLength(arr));
        //System.out.println(findMaxLength2(arr));

    }
}
