package sept.week2;

import june.TreeNode;

public class SumOfRootToLeafBinaryNumbers
{
    public int sumRootToLeaf(TreeNode root) {


        return sumRootToLeafRec(root, 0);
    }


    public int sumRootToLeafRec(TreeNode root, int current)  {
    if (root == null) {
        return 0;
    }
    current = current << 1;
    current += root.val;
    if (isLeaf(root)) {
        return current;
    }
    return
        sumRootToLeafRec(root.left, current)
            + sumRootToLeafRec(root.right, current);
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
