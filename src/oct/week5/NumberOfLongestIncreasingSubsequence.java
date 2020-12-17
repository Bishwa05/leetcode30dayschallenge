package oct.week5;


class Value {
    int length;
    int count;

    public Value(int len, int ct){
        this.length = len;
        this.count = ct;
    }
}

class RangeNode {
    int rangeLeft, rangeRight;
    RangeNode left, right;
    Value val;

    public RangeNode(int start, int end){
        rangeLeft = start;
        rangeRight = end;
        left = null;
        right = null;
        val = new Value(0,1);
    }

    public int getRangeMid(){
        return
            rangeLeft + (rangeRight - rangeLeft)/2;
    }


    public RangeNode getLeft(){
        if(left == null) left = new RangeNode(rangeLeft , getRangeMid());
        return left;
    }

    public RangeNode getRight(){
        if(right == null) right = new RangeNode(getRangeMid()+1, rangeRight);
        return right;
    }


}

public class NumberOfLongestIncreasingSubsequence
{


    public Value merge(Value v1, Value v2){
        if(v1.length == v2.length) {
            if(v1.length ==0) return new Value(0, 1);
            return new Value(v1.length, v1.count+v2.count);
        }
        return v1.length> v2.length? v1: v2;
    }

    public void insert(RangeNode node, int key, Value val){

        if(node.rangeLeft == node.rangeRight){
            node.val = merge(val, node.val);
            return;
        } else if(key <= node.getRangeMid()) {
            insert(node.getLeft(), key, val);
        } else {
            insert(node.getRight(), key, val);
        }
        node.val = merge(node.getLeft().val, node.getRight().val);
    }

    public Value query(RangeNode node, int key){
        if(node.rangeRight <= key) return node.val;
        else if(node.rangeLeft>key) return new Value(0,1);
        else return merge(query(node.getLeft(), key),
                query(node.getRight(), key));
    }

    public int findNumberOfLIS(int[] nums){
        if(nums.length == 0) return 0;
        int min =  nums[0], max = nums[0];

        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        RangeNode root = new RangeNode(min, max);

        for(int num : nums){
            Value v = query(root, num-1);
            insert(root, num, new Value(v.length+1, v.count));
        }
        return root.val.count;
    }
}
