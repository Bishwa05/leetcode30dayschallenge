package may21;

import june.TreeNode;
import may.ListNode;

public class ConvertSortedListToBinarySearchTree
{
    static ListNode head;
    public TreeNode constructRec(int start, int end){
        if(start>end){
            return null;
        }

        int mid =  start + (end-start)/2;

        TreeNode left = constructRec(start, mid-1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        head = head.next;
        TreeNode right = constructRec(mid+1, end);
        root.right = right;
        return root;
    }


    public TreeNode sortedListToBST(ListNode head1) {
        int len = 0;
        ListNode currNode = head1;
        while(currNode != null){
            len++;
            currNode = currNode.next;
        }
        head = head1;
        return constructRec(0, len-1);
    }
}
