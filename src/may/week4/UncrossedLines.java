package may.week4;

public class UncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {

        int[][] dp = new int[A.length+1][B.length+1];

        for(int i=1; i<=A.length; i++){
            for(int j =1; j<=B.length; j++){
                if(A[i-1]==B[j-1]){
                    dp[i][j] =1+ dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[A.length][B.length];
    }

    public static void main(String arg[]){

        UncrossedLines u = new UncrossedLines();

//        int[] A = {1,4,2};
//        int[] B = {1,2,4};

//        int[] A = {2,5,1,2,5};
//        int[] B = {10,5,2,1,5,2};

        int[] A = {1,3,7,1,7,5};
        int[] B = {1,9,2,5,1};


        System.out.println(u.maxUncrossedLines(A,B));

    }
}
