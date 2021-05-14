package may21.week2;

import june.TreeNode;

public class FlattenBinaryTreeToLinkedList
{
    public void flatten(TreeNode root) {
        if(root!= null)
            dfs(root);

    }

    public TreeNode dfs(TreeNode root){
        if(root.left != null){
            TreeNode right = root.right;

            TreeNode curr =  dfs(root.left);
            root.right =curr;
            root.left = null;
            while(curr.right != null) curr = curr.right;
            curr.right = right;

            while(right!= null && right.left == null &&  right.right != null) right = right.right;
            if(right!= null && right.left != null){
                dfs(right);
            }

        } else if(root.right != null) {
            dfs(root.right);
        }
        return root;
    }

    public static void main(String arg[]){
        FlattenBinaryTreeToLinkedList f = new FlattenBinaryTreeToLinkedList();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(5);
        t.left.left = new TreeNode(3);
        t.left.right = new TreeNode(4);
        t.right.right = new TreeNode(6);
        f.flatten(t);
    }
}
