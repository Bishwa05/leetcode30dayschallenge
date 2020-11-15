package nov.week3;

import june.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumOfBST
{
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum =0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);


        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.val>=low && curr.val<=high){
                sum+=curr.val;
            }
            if(curr.left != null && curr.val>low){
                q.add(curr.left);
            }
            if(curr.right != null && curr.val< high){
                q.add(curr.right);
            }
        }
        return sum;
    }
}
