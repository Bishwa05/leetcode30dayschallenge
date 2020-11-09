package nov.week2;

import june.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor
{
    int maxDiff =0;

    private void dfs(TreeNode root, int min, int max){
        if(root == null) return;

        int diff1 = Math.abs(root.val - min);
        int diff2 = Math.abs(root.val - max);

        maxDiff = Math.max(maxDiff, diff1);
        maxDiff = Math.max(maxDiff, diff2);


        dfs(root.left, Math.min(root.val, min), Math.max(root.val, max));
        dfs(root.right, Math.min(root.val, min), Math.max(root.val, max));
    }

    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;

        maxDiff =0;
        dfs(root, root.val, root.val);
        return maxDiff;

    }
}
