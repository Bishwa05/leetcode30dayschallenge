package nov.week2;

import june.TreeNode;

public class BinaryTreeTilt
{
    int tilt =0;
    private int postorder(TreeNode root){
        if (root == null) return 0;
        int leftSum = postorder(root.left);
        int rightSum = postorder(root.right);
        tilt += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
    public int findTilt(TreeNode root) {
        postorder(root);
        return tilt;
    }
}
