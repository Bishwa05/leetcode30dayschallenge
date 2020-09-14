package sept.week2;

public class HouseRobber
{
    public int rob(int[] nums) {
        int oddSum =0;
        int evenSum =0;


        for(int i =0; i< nums.length; i++){
            if(i%2!=0){
                oddSum += nums[i];
                oddSum = evenSum > oddSum ? evenSum : oddSum;
            } else{
                evenSum += nums[i];
                evenSum = evenSum > oddSum ? evenSum : oddSum;
            }
        }
        return (oddSum>evenSum)?oddSum:evenSum;
    }

    public int robDP(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }

        return dp[nums.length-1];
    }

    public static void main(String arg[]) {
        HouseRobber h = new HouseRobber();
        int []nums = {50, 1, 1, 50};
        System.out.println(h.rob(nums));
        System.out.println(h.robDP(nums));
    }
}
