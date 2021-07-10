package july21.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaximumLengthOfRepeatedSubarray
{
    // TLE
    public int findLength(int[]A, int []B){
        int ans = 0;
        Map<Integer, ArrayList<Integer>> bStarts = new HashMap<>();
        for(int j =0; j<B.length; j++){
            bStarts.computeIfAbsent(B[j], x-> new ArrayList<>()).add(j);
        }

        for(int i =0; i<A.length; i++){
            if(bStarts.containsKey(A[i])) {
                for(int j : bStarts.get(A[i])){
                    int k = 0;
                    while(i+k<A.length && j+k <B.length && A[i+k] == B[j+k]){
                        k++;
                    }
                    ans = Math.max(ans, k);
                }
            }
        }
        return ans;
    }



    public static void main (String[] args)
    {
        MaximumLengthOfRepeatedSubarray m = new MaximumLengthOfRepeatedSubarray();
        int[] A = {1,2,3,1,2};
        int[] B = {3,1,2,2,3};

        int res = m.findLength(A, B);
        System.out.println(res);
    }
}
