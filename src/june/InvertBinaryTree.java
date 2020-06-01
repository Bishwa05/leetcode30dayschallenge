package june;

public class InvertBinaryTree {

    /**
     * Recursive approach.
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode currNode = root.left;

        root.left = root.right;
        root.right = currNode;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


}
