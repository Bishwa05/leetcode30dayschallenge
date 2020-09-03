package sept;

import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsDuplicateIII
{

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null||nums.length<2||k<0||t<0)
            return false;

        TreeSet<Long> set = new TreeSet<>();
        for(int i=0; i<nums.length; i++){
            long curr = (long) nums[i];

            long leftBoundary =  curr-t;
            long rightBoundary = curr+t+1; //right boundary is exclusive, so +1
            SortedSet<Long> sub = set.subSet(leftBoundary, rightBoundary);
            if(sub.size()>0)
                return true;

            set.add(curr);

            if(i>=k){ // or if(set.size()>=k+1)
                set.remove((long)nums[i-k]);
            }
        }

        return false;
    }

    public static void main(String arg[]){
        ContainsDuplicateIII c = new ContainsDuplicateIII();

        int[] nums = {1,2,3,1};
            int k = 3, t = 0;
        System.out.println(c.containsNearbyAlmostDuplicate(nums, k, t));
    }
}
