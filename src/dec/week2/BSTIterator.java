package dec.week2;

import june.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BSTIterator
{
    public void doInOrderTraversal(TreeNode root){
        if(root != null){
            doInOrderTraversal(root.left);
            iterList.offer(root.val);
            doInOrderTraversal(root.right);
        }
    }

    Queue<Integer> iterList;
    public BSTIterator(TreeNode root) {
        iterList = new LinkedList();
        doInOrderTraversal(root);
    }

    public int next() {
        return iterList.poll();
    }

    public boolean hasNext() {
        return !iterList.isEmpty();
    }
}
