package week4;

public class ValidSequencefromRootLeavesPathBinaryTree {

    public boolean isValidSequence(TreeNode root, int[] arr) {

        return helper(root, arr, 0);

    }

    public boolean helper(TreeNode curr, int[] arr, int i) {

        if(curr== null || i==arr.length) {
            return false;
        }

        if(curr.val == arr[i]){
            i = i+1;
            if(curr.left== null && curr.right == null && i==arr.length){
                return true;
            } else {

                return (helper(curr.left, arr, i) ||
                        helper(curr.right, arr, i));
            }
        }

        return false;

    }

    public static void main(String arg[]){
        /**
         * [4,null,2,7,5,3,4,4]
         * [4,2,7,4]
         *
         */
        TreeNode ro = new TreeNode(4);
        TreeNode r1 =new TreeNode(2);
        TreeNode l21 = new TreeNode(7);
        TreeNode r21 =new TreeNode(5);
        TreeNode l31 = new TreeNode(3);
        TreeNode r31 =new TreeNode(4);
        TreeNode l32 =new TreeNode(4);

        l21.left = l31;
        l21.right = r31;
        r21.left = l32;
        r1.left = l21;
        r1.right = r21;
        ro.right =r1;

        int arr[] = {4,2,7,4};

        ValidSequencefromRootLeavesPathBinaryTree t = new ValidSequencefromRootLeavesPathBinaryTree();

        System.out.println(t.isValidSequence(ro, arr));
    }
}
