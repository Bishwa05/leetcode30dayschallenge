package may.week1;


import may.TreeNode;

public class CousinsInBinaryTree {
    public boolean ifCousin(TreeNode root, int x, int y){
        TreeNode a = new TreeNode(x);
        TreeNode b = new TreeNode(y);

        if(root == null || a == null || b == null){
            return false;
        }

        if(getLevelOfNode(root, a.val, 1) != getLevelOfNode(root, b.val, 1)){
            return false;
        }

        return !isSibling(root, x, y);
    }

    public int getLevelOfNode(TreeNode node, int val, int level) {
        if(node == null) return 0;

        if(node.val == val){
            return level;
        }

        int l = getLevelOfNode(node.left, val, level+1);
        if(l !=0){
            return l;
        }
        l = getLevelOfNode(node.right, val, level+1);
        return l;
    }

    public boolean isSibling(TreeNode root , int x, int y) {
        if(root == null){
            return false;
        }

        boolean a = false, b = false, c = false;
        if(root.left != null && root.right != null)
            a = ( (root.left.val == x && root.right.val == y) ||
                    (root.left.val == y && root.right.val == x) );
        if(root.left != null)
            b = isSibling(root.left, x, y);
        if(root.right != null)
            c = isSibling(root.right, x, y);
        return (a || b || c);
    }


    public static void main(String arg[]){
        CousinsInBinaryTree b = new CousinsInBinaryTree();

        System.out.println(b.ifCousin(new TreeNode(), 1,2));
    }
}
