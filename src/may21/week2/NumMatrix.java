package may21.week2;

public class NumMatrix
{
    int[][] mat;
    int m =0;
    int n =0;

    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        mat = new int[m][n];

        mat = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for(int i =row1; i<=row2; i++){
            for(int j = col1; j<=col2; j++){
                sum+= mat[i][j];
            }
        }
        return sum;

    }
}
