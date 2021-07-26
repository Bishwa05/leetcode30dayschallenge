package july21.week4;

import june.TreeNode;

public class ConvertSortedArrayToBinarySearchTree
{
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null)
            return null;
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
    private TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if(low > high)
            return null;
        int mid = low+(high-low)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, low, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, high);
        return root;
    }
}
