package jan2021;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.Arrays;

public class MinimumOperationsToReduceXToZero
{
    public int minOperations(int[] nums, int x) {
        int target = Arrays.stream(nums).sum()-x;
        int n = nums.length, windowSize = -1, current = 0;

        for (int right =0, left =0; right<n; right++){
            current +=nums[right];
            while(current> target && left <= right)
                current -= nums[left++];
            if(current == target)
                windowSize = Math.max(windowSize, right -left+1);
        }
        return windowSize != -1? n-windowSize : -1;
    }

    public static void main(String args[]){
        MinimumOperationsToReduceXToZero m = new MinimumOperationsToReduceXToZero();
        int[] nums = {1,1,4,2,3};
        System.out.println(m.minOperations(nums, 5));
    }
}
