package nov.week2;

public class FlippingAnImage
{
    public int[][] flipAndInvertImage(int[][] A){
        int m = A.length, n = A[0].length;
        for(int i=0; i<m; i++){
            int l =0, r = n-1;
            while(l<=r){
                int temp = A[i][l];
                A[i][l++] = A[i][r]^1;
                A[i][r--] = temp^1;
            }
        }
        return A;
    }
}
