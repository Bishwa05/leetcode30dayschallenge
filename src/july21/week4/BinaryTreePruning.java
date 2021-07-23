package july21.week4;

import june.TreeNode;

public class BinaryTreePruning
{
    public TreeNode pruneTree(TreeNode root) {

        if(root != null){
            pruneTree(root.left);
            pruneTree(root.right);


            if(root.left != null && root.left.val == 0 && root.left.left == null && root.left.right == null){
                root.left = null;
            }

            if(root.right != null && root.right.val == 0 && root.right.left == null && root.right.right == null){
                root.right = null;
            }

            if(root.val ==0 && root.left == null && root.right == null){
                root = null;
            }

        }
        return root;
    }

    // shorter soln
    public TreeNode pruneTree2(TreeNode root) {

        if (root == null) return null;

        root.left = pruneTree2(root.left);
        root.right = pruneTree2(root.right);

        if (root.val == 0 && root.left == null && root.right == null) root = null;

        return root;

    }
}
