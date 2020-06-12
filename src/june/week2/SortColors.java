package june.week2;

public class SortColors {
    public void sortColors(int[] nums) {
        int zcount =0;
        int ocount =0;
        int tcount =0;

        for(int i =0; i<nums.length; i++){
            if(nums[i]==0){
                zcount++;
            }
            if(nums[i]==1){
                ocount++;
            }
            if(nums[i]==2){
                tcount++;
            }
        }

        for(int i=0; i<nums.length; i++){
            if(i<zcount){
                nums[i]=0;
            }else if(i>=zcount && i<zcount+ocount){
                nums[i]=1;
            } else{
                nums[i] =2;
            }
        }

    }
}
