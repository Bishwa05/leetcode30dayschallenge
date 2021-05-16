package may21.week3;

import june.TreeNode;

/**
 * 1 -> camera not needed.
 * 2 -> camera installation needed
 * 3 -> camera already installed
 */
public class BinaryTreeCameras
{
    int count = 0;
    public int minCameraCover(TreeNode root) {

        return dfs(root) == 2? count+1: count;
    }

    public int dfs(TreeNode root){
        if(root == null) return 1;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(left == 2 || right ==2){
            count++;
            return 3;
        }

        if(left == 3 || right ==3) return 1;

        return 2;
    }

    public static void main(String arg[]) {
        BinaryTreeCameras b = new BinaryTreeCameras();
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(0);
        root.right.right = new TreeNode(0);
        root.right.right.right = new TreeNode(0);

        b.minCameraCover(root);
    }
}
