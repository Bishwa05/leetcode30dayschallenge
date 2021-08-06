package aug21;

/**
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_AryTreeLevelOrderTraversal
{
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> row = new ArrayList<>();
        while(!q.isEmpty()){
            Node curr = q.poll();

            if(curr != null){
                row.add(curr.val);
                if(curr.children != null){
                    for(Node ch : curr.children){
                        q.offer(ch);
                    }
                }
            } else{
                res.add(new ArrayList<>(row));
                if(!q.isEmpty()){
                    row.clear();
                    q.offer(null);
                }
            }
        }
        return res;
    }
}
