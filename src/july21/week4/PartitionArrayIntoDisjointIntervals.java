package july21.week4;

/**
 *
 * end is the leftmost index of left part
 * maxIndex is max number's we encountered so far
 * maxCurrIndex is the max number's index in the left part
 *
 */
public class PartitionArrayIntoDisjointIntervals
{
    public int partitionDisjoint(int[] nums) {
        int maxIndex =0;
        int end = 0;
        int maxCurrIndex = 0;

        for(int i =1; i<nums.length; i++){
            if(nums[i]< nums[maxCurrIndex]){
                maxCurrIndex = maxIndex;
                end = i;
            } else if(nums[i]> nums[maxIndex]){
                maxIndex = i;
            }
        }

        return end+1;
    }

    public static void main (String[] args)
    {
        PartitionArrayIntoDisjointIntervals p = new PartitionArrayIntoDisjointIntervals();
        int[] nums = {5,0,3,8,6};
        System.out.println(p.partitionDisjoint(nums));
    }
}
