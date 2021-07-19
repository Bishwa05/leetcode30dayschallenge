package july21.week3;

import june.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root.val == p.val || root.val == q.val){
            return root;
        }

        if(p.val<root.val && q.val< root.val){
            return lowestCommonAncestor(root.left, p, q);
        } else if(p.val>root.val && q.val> root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
