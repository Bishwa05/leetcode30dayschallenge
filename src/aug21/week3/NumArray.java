package aug21.week3;

public class NumArray
{
    int [] sumArr;

    public NumArray(int[] nums) {
        int n =nums.length;
        sumArr = new int[n];

        sumArr[0] = nums[0];
        for(int i =1; i<n; i++){
            sumArr[i] = nums[i] + sumArr[i-1];
        }
    }

    public int sumRange(int left, int right) {

        if (left == right) return (left==0)?sumArr[left]-0 : sumArr[left] - sumArr[left-1];
        if(left ==0) return sumArr[right];
        return sumArr[right] - sumArr[left-1];

    }
}
