package june.week2;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {

        int l = 0;
        int h = nums.length-1;

        while(l<=h){
            int mid = l + (h-l)/2;

            if(target == nums[mid]){
                return mid;
            }else if(mid>0 && nums[mid-1]<target &&  target<nums[mid]){
                return mid;
            }else if(mid==0 && target <nums[mid]){
                return mid;
            } else if(mid == nums.length-1 && target>nums[mid]){
                return mid+1;
            }
            else if(target > nums[mid]){
                l = mid+1;
            } else{
                h = mid;
            }
        }
        return -1;

    }

    public static void main(String arg[]) {
        int[] arr = {1,3,5,6};
        int num = 0;
        SearchInsertPosition s = new SearchInsertPosition();
        System.out.println(s.searchInsert(arr, num));
    }
}
