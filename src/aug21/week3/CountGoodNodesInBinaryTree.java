package aug21.week3;

import june.TreeNode;

public class CountGoodNodesInBinaryTree
{
    int res=0;
    public int goodNodes(TreeNode root) {
        int arr[] = new int[1];
        arr[0] = root.val;
        preOrder(root, arr);
        return res;
    }

    public void preOrder(TreeNode root, int[] pathMax){

        if(root != null){
            //System.out.println(root.val);
            int pathVal = pathMax[0];
            if(root.val> pathMax[0]){
                pathMax[0] = root.val;
            }
            if(root.val == pathMax[0]){
                res+=1;
            }
            preOrder(root.left, pathMax);
            preOrder(root.right, pathMax);
            pathMax[0] = pathVal;
        }
    }
}
