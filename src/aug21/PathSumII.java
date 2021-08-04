package aug21;

import june.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII
{
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        preOrder(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    public void preOrder(TreeNode root, int targetSum, List<Integer>path, List<List<Integer>>res){
        if(root== null) return;

        int val = root.val;

        targetSum -= val;
        path.add(val);

        if(targetSum ==0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
        }
        System.out.println(val +"---"+ targetSum);
        preOrder(root.left, targetSum, path, res);
        preOrder(root.right, targetSum, path, res);
        path.remove(path.size()-1);

    }
}
