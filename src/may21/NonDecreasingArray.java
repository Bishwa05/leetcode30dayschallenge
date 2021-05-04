package may21;

public class NonDecreasingArray
{
    public boolean checkPossibility(int[] nums) {

        for(int i=1, err =0; i< nums.length; i++){
            if(nums[i]< nums[i-1]){
                if(err >0 || (i>1 && i < nums.length &&
                    nums[i-2]> nums[i] && nums[i-1]> nums[i+1])){
                    return false;
                }
                err +=1;
            }
        }
        return true;

    }
}
