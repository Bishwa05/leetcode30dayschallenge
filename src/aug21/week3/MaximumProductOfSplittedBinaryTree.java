package aug21.week3;

import june.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumProductOfSplittedBinaryTree
{
    long res =0;
    long treeSum = 0;
    int MOD = 1_000_000_007;
    public int maxProduct(TreeNode root) {

        treeSum = sumOfTree(root);
        subTreeSumProd(root);
        return (int)(res%MOD);
    }

    public int subTreeSumProd(TreeNode root) {
            if(root.left == null && root.right == null){
                return root.val;
            }
            int subSum = 0;
            if(root.left != null){
                subSum += subTreeSumProd(root.left);
            }
            if(root.right != null){
                subSum += subTreeSumProd(root.right);
            }
            subSum += root.val;
            long tot = ((treeSum-subSum)*subSum);
            if(tot>res) res = tot;
            return subSum;




        /**
         *
         *      Approach 2
         *
         *            if(root == null) return 0;
         *             int currSum = dfs(root.left) + dfs(root.right) + root.val;
         *             res = Math.max(res, (treeSum-currSum)*currSum);
         *             return currSum;
         */
    }



    public int sumOfTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        int sum =0;
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            sum += curr.val;
            if(curr.left != null){
                q.offer(curr.left);
            }
            if(curr.right != null){
                q.offer(curr.right);
            }

        }
        return sum;
    }

    public static void main (String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.left  = new TreeNode(5);
        root.right.right.right  = new TreeNode(6);


        MaximumProductOfSplittedBinaryTree m = new MaximumProductOfSplittedBinaryTree();
        m.maxProduct(root);
    }
}
