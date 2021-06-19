package jun21.week3;

/**
 *
 * 1. Pre-processing step which builds the segment tree from a given array.
 * 2. Update the segment tree when an element is modified.
 * 3. Calculate the Range Sum Query using the segment tree.
 *
 */
public class NumArray
{
    int[] tree;
    int n;

    public NumArray(int[] nums){
        if(nums.length >0){
            n = nums.length;
            tree = new int[n*2];
            buildTree(nums);
        }
    }

    private void buildTree(int[] nums){
        for(int i =n, j =0; i< 2*n; i++, j++){
            tree[i] = nums[j];
        }

        for(int i = n-1; i>0; --i){
            tree[i] = tree[i*2] + tree[i*2+1];
        }
    }

    public void update(int pos, int val){
        pos+=n;
        tree[pos] = val;
        while(pos>0){
            int left = pos;
            int right = pos;
            if(pos%2 ==0){
                right = pos+1;
            } else {
                left = pos -1;
            }

            tree[pos/2] = tree[left] + tree[right];
            pos /=2;
        }
    }

    public int sumRange(int l, int r){
       l +=n;
       r+=n;

       int sum =0;

       while(l<=r){
           if((l%2) ==1){
               sum+= tree[l];
               l++;
           }
           if((r%2)==0){
               sum+= tree[r];
               r--;
           }
           l/=2;
           r /=2;
       }
        return sum;
    }

    public static void main (String[] args)
    {
        int[] nums = {1, 3, 5};
        NumArray n = new NumArray(nums);
        n.sumRange(0,2);
        n.update(1, 2);
        n.sumRange(0, 2);

    }

}
