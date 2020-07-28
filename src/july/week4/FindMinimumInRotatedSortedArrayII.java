package july.week4;

public class FindMinimumInRotatedSortedArrayII
{
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length-1);
    }

    public int findMin(int[] num, int left, int right)
    {
        if (right == left) {
            return num[left];
        }
        if (right == left + 1) {
            return Math.min(num[left], num[right]);
        }
        // 3 3 1 3 3 3

        int middle = (right - left) / 2 + left;
        // already sorted
        if (num[right] > num[left]) {
            return num[left];
            //right shift one
        }
        else if (num[right] == num[left]) {
            return findMin(num, left + 1, right);
            //go right
        }
        else if (num[middle] >= num[left]) {
            return findMin(num, middle, right);
            //go left
        }
        else {
            return findMin(num, left, middle);
        }
    }

    public static void main(String arg[]){
        int []nums = {4,5,6,7,0,1,2};
        FindMinimumInRotatedSortedArrayII f = new FindMinimumInRotatedSortedArrayII();
        System.out.print(f.findMin(nums));
    }
}
