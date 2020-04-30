package april.week3;

public class ConstructBSTFromPreOrederTraversal {

    /**
     *
     *
     * public TreeNode constructBST(int[] preorder, int start, int end)
     *        {
     * 		// base case
     * 		if (start > end) {
     * 			return null;
     *        }
     *
     *
     * 		TreeNode node = new TreeNode(preorder[start]);
     *
     * 		int i;
     * 		for (i = start; i <= end; i++) {
     * 			if (preorder[i] > node.val) {
     * 				break;
     *            }
     *        }
     *
     * 		node.left = constructBST(preorder, start + 1, i - 1);
     *
     * 		node.right = constructBST(preorder, i, end);
     *
     * 		return node;
     *    }
     *
     *     public TreeNode bstFromPreorder(int[] preorder) {
     *
     *         TreeNode root = constructBST(preorder, 0, preorder.length - 1);
     *         return root;
     *
     *     }
     */
}
