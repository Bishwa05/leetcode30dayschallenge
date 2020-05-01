package may;

public class FirstBadVersion {

    private boolean isBadVersion(int x){
        if( x>=1702766719){
            return true;
        }
        return false;
    }

    public int firstBadVersion(int n) {


        int i =1;
        return helper(1, n);

    }

    /**
     * Optimised one where we dont check isBadVersion more than once  in a
     * single iteration.
     */
    private int helperItr(int n){
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * The below is not efficient enough takes more time in leetcode  submission.
     */
    private int helper(int i, int n) {
        int mid = i+(n-i)/2;

        if(isBadVersion(mid) && (mid>0)?!isBadVersion(mid-1):false){
            return mid;
        }else if(!isBadVersion(mid)){
            return helper(mid+1,n);
        } else if(isBadVersion(mid)) {
            return helper(i,mid);
        }
        return -1;

    }

    public static void main(String arg[]){
        int n = 2126753390;
        FirstBadVersion f  = new FirstBadVersion();

        System.out.println(f.firstBadVersion(n));
    }

}
