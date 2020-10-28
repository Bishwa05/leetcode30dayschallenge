package oct.week4;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges
{
    public List<String> summaryRanges(int[] nums){
        if(nums.length <1) return new ArrayList<>();

        List<String> result = new ArrayList<>();

        int curr = nums[0];
        int prev = nums[0];

        for(int i =1; i<nums.length; i++){
            if(nums[i]-prev >1 || nums[i]-prev<1){
                if(curr != prev){
                    result.add(curr +"->" +prev);
                } else{
                    result.add(""+curr);
                }
                curr = nums[i];
                prev = nums[i];
            }
            if(nums[i] - prev ==1){
                prev = nums[i];
            }
        }
        if(curr != prev){
            result.add(curr+"->"+ prev);
        } else{
            result.add(""+curr);
        }
        return result;
    }
}
