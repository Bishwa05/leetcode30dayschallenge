package week4;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;

    }

    public static void main(String arg[]){
        int []arr = {2,3,1,1,4};
        JumpGame j = new JumpGame();
        System.out.println(j.canJump(arr));
    }
}
