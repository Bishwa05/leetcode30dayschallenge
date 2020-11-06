package nov;

public class FindTheSmallestDivisorGivenAThreshold
{
    public int calDiv(int[] nums, int div){
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            int num =0;
            if(nums[i]%div == 0){
                num = nums[i]/div;
            } else {
                num = nums[i]/div +1;
            }
            sum +=num;
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;

        if(n ==0) return 0;

        int left =1, right = threshold;

        for(int i=0; i<n; i++){
            right = Math.max(right, nums[i]);
        }

        while(left < right){
            int mid = (left+right)/2;
            int sum = calDiv(nums, mid);
            if(sum<=threshold){
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String arg[]){
        int[]nums = {1,2,5,9};
        int threshold = 6;
        FindTheSmallestDivisorGivenAThreshold f = new FindTheSmallestDivisorGivenAThreshold();
        System.out.println(
            f.smallestDivisor(nums, threshold)
        );
    }
}
