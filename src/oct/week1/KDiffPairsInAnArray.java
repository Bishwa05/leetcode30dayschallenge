package oct.week1;

import java.util.*;

public class KDiffPairsInAnArray
{
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> m = new HashSet<>();
        Set<String> uniq = new HashSet<>();

        for(int v : nums){
            if(m.contains(v-k)){
                uniq.add(v+"-"+k);
            }
            m.add(v);
        }
        return uniq.size();
    }

    public static void main(String arg[]){
        KDiffPairsInAnArray k = new KDiffPairsInAnArray();
//        int []nums = {1,3,1,5,4};
//        int kd = 0;
//        int []nums = {3,1,4,1,5};
//        int kd =2;
//        int []nums = {1,2,4,4,3,3,0,9,2,3};
//        int kd =3;
//        int []nums = {-1,-2,-3};
//        int kd =2;
                int []nums = {1,2,3,4,5};
                int kd = 1;
        System.out.println(k.findPairs(nums, kd));
    }
}
