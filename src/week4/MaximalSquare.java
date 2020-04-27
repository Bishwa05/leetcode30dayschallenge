package week4;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {

        int max =0;

        if(matrix.length ==0) return 0;
        if(matrix[0].length ==0) return 0;


        int rows = matrix.length;
        int cols = matrix[0].length;

        int dp[][] = new int[rows+1][cols+1];

        for(int i=1;i<=rows; i++){
            for(int j =1; j<= cols; j++){
                if(matrix[i-1][j-1]=='0'){
                    dp[i][j] = 0;
                } else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]),
                            dp[i-1][j-1]) +1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max*max;
    }

    public static void main(String arg[]){
        char[][] ch = {{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};

        MaximalSquare m = new MaximalSquare();
        System.out.println(m.maximalSquare(ch));

    }
}
