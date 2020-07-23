package july.week4;

public class SingleNumberIII
{
    public int[] singleNumber(int[] nums) {
        int A = 0;
        int B = 0;
        int AXORB = 0;
        for(int i = 0; i<nums.length; i++){
            AXORB ^= nums[i];
        }

        AXORB = (AXORB & (AXORB - 1)) ^ AXORB;

        for(int i = 0; i<nums.length; i++){
            if((AXORB & nums[i]) == 0)
                A ^= nums[i];
            else
                B ^= nums[i];
        }
        return new int[]{A, B};
    }
}
