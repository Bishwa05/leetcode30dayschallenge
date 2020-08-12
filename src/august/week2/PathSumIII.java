package august.week2;

import june.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII
{
    int count =0;
    List<Integer> list = new ArrayList<>();

    public int pathSum(TreeNode root, int sum) {
        getSum(root, sum);
        return count;
    }

    private void getSum(TreeNode root, int sum){
        if(root == null)
            return;

        list.add(root.val);

        getSum(root.left, sum);
        getSum(root.right, sum);

        int temp =0;
        for(int i= list.size()-1; i>=0; i--){
            temp +=list.get(i);

            if(temp == sum){
                count++;
            }
        }
        list.remove(list.size()-1);
    }


}
