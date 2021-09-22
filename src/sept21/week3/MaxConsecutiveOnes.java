package sept21.week3;

public class MaxConsecutiveOnes
{
    public int findMaxConsecutiveOnes(int[] nums) {
        int p1 = 0, p2=0;
        int max = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0){

                max = Math.max(max, p1-p2);
                p2 = i+1;
            }
            if(nums[i]==1){
                p1 = i+1;
            }
        }
        max = Math.max(max, p1-p2);
        return max;
    }
}
