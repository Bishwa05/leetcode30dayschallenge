package august.week4;

import june.TreeNode;

public class SumOfLeftLeaves
{
    int sum =0;
    public int findSumLeft(TreeNode root, boolean isLeft) {
        if(root != null){
            findSumLeft(root.left, true);
            if(root.left == null && root.right == null && isLeft) {
                sum+=root.val;
            }

            findSumLeft(root.right, false);

        }
        return sum;
    }
    public int sumOfLeftLeaves(TreeNode root) {

        return findSumLeft(root, false);
    }

}
