package may.week4;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
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
}
