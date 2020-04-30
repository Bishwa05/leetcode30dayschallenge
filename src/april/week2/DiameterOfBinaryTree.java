package april.week2;

public class DiameterOfBinaryTree {
    /**
     *
     * The problem is solved in datastructure repo
     * https://github.com/Bishwa05/datastructure/blob/master/src/tree/binarytree/CommonFunction.java
     *
     *     class Height{
     *         int h = Integer.MIN_VALUE;
     *     }
     *
     *     public int height(TreeNode root, Height x) {
     *         if(root == null)
     * 		    return 0;
     *
     *         int leftH, rightH;
     * 		leftH = height(root.left, x);
     * 		rightH = height(root.right, x);
     *
     *         x.h = Math.max(x.h,1+leftH+rightH);
     *
     *         return 1+ Math.max(leftH, rightH);
     *     }
     *     public int diameterOfBinaryTree(TreeNode root) {
     * 		if(root == null)
     * 		    return 0;
     *         Height obj = new Height();
     *         height(root,obj);
     *
     * 		return obj.h-1;
     *     }
     *
     */


}
