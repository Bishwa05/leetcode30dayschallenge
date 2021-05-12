package may21.week2;

public class NumMatrix
{
//    int[][] mat;
//    int m =0;
//    int n =0;
//
//    public NumMatrix(int[][] matrix) {
//        m = matrix.length;
//        n = matrix[0].length;
//
//        mat = new int[m][n];
//
//        mat = matrix;
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int sum = 0;
//
//        for(int i =row1; i<=row2; i++){
//            for(int j = col1; j<=col2; j++){
//                sum+= mat[i][j];
//            }
//        }
//        return sum;
//
//    }

    /**
     * Sum(ABCD)=Sum(OD)−Sum(OB)−Sum(OC)+Sum(OA)
     */

    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}
