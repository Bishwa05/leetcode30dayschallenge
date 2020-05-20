package may.week3;

import may.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInaBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> a = new ArrayList<>();
        TreeNode x = kthSmallestNode(root, k, a);

        return a.get(k-1);
    }

    public TreeNode kthSmallestNode(TreeNode root, int k, List<Integer> a) {
        if(root == null)
            return null;
        TreeNode left = kthSmallestNode(root.left, k, a);
        if(left != null)
            return left;
        a.add(root.val);
        return kthSmallestNode(root.right,k,a);
    }


    public int kthSmallestOptimized(TreeNode root, int k) {
        int count=0;
        int ksmall=Integer.MAX_VALUE;
        TreeNode current=root;
        while(current!=null)
        {
            if(current.left==null)
            {
                count++;
                if(count==k)
                {ksmall=current.val;
                    break;
                }
                current=current.right;
            }
            else
            {
                TreeNode prev=current.left;
                while(prev.right!=null&&prev.right!=current)
                    prev=prev.right;
                if(prev.right==null)
                {
                    prev.right=current;
                    current=current.left;
                }
                else
                {
                    prev.right=null;
                    count++;
                    if(count==k)
                    {ksmall=current.val;
                        break;
                    }
                    current=current.right;
                }
            }
        }

        return ksmall;

    }
}
