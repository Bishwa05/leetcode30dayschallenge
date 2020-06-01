package june.week1;

import june.TreeNode;

import java.util.LinkedList;

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


    /**
     * Iterative approach
     */
    public TreeNode invertTreeItr(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        if(root!=null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            if(p.left!=null)
                queue.add(p.left);
            if(p.right!=null)
                queue.add(p.right);

            TreeNode temp = p.left;
            p.left = p.right;
            p.right = temp;
        }

        return root;
    }


}
