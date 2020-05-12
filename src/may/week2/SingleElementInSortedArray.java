package may.week2;

/**
 * Example 1:
 *
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 *
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *
 */
public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;
        if (n == 1) return nums[0];

        for (int i=0,j=1;i<n-1;i+=2,j+=2){
            if (nums[i]!=nums[j]){
                return nums[i];
            }

        }
        return nums[n-1];

    }
}
