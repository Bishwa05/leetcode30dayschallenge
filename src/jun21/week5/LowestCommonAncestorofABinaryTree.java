package jun21.week5;

import june.TreeNode;


public class LowestCommonAncestorofABinaryTree
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root, p, q);
    }

    public TreeNode LCA(TreeNode root, TreeNode a, TreeNode b)
    {
        TreeNode left, right;
        if (root == null)
            return root;
        if (root == a || root == b)
            return root;
        left = LCA(root.left, a, b);
        right = LCA(root.right, a, b);
        if (left != null && right != null)
            return root; //nodes are each on a separate branch
        else
            return (left != null ? left : right);
        //Either 1 node is on 1 branch or none was found in any of the branches
    }

    //[3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LowestCommonAncestorofABinaryTree l = new LowestCommonAncestorofABinaryTree();

        TreeNode n = l.lowestCommonAncestor(root, root.left.left, root.right.right);
        System.out.println(n.val);


    }
}
