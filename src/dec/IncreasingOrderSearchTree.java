package dec;

import june.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 897
 */
public class IncreasingOrderSearchTree
{

    public TreeNode increasingBST(TreeNode root){
        List<Integer> vals = new ArrayList<>();
        inOrder(root, vals);
        TreeNode ans = new TreeNode(0);
        TreeNode curr = ans;
        for(int v: vals){
            curr.right = new TreeNode(v);
            curr = curr.right;
        }
        return ans.right;
    }

    public void inOrder(TreeNode node, List<Integer> vals){
        if(node == null) return;
        inOrder(node.left, vals);
        vals.add(node.val);
        inOrder(node.right, vals);
    }
}
