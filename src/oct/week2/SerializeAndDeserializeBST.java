package oct.week2;

import june.TreeNode;

import java.util.Stack;

public class SerializeAndDeserializeBST
{
    public String serialize(TreeNode root) {
        if(root==null)
            return null;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            TreeNode h = stack.pop();
            if(h!=null){
                sb.append(h.val+",");
                stack.push(h.right);
                stack.push(h.left);
            }else{
                sb.append("#,");
            }
        }

        return sb.toString().substring(0, sb.length()-1);
    }

    public TreeNode deserialize(String data) {
        if(data == null)
            return null;

        int[] t = {0};
        String[] arr = data.split(",");

        return helper(arr, t);
    }

    public TreeNode helper(String[] arr, int[] t){
        if(arr[t[0]].equals("#")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[t[0]]));

        t[0]=t[0]+1;
        root.left = helper(arr, t);
        t[0]=t[0]+1;
        root.right = helper(arr, t);

        return root;
    }
}
