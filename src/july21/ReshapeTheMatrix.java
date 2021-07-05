package july21;

public class ReshapeTheMatrix
{
    public int[][] matrixReshape(int[][] mat, int r, int c){
        int rows = mat.length;
        int columns = mat[0].length;

        if((rows * columns) != (r*c)) return mat;

        int [][] output_arr = new int[r][c];
        int row_num = 0;
        int column_num = 0;

        for(int i =0; i<rows; i++){
            for(int j =0; j< columns; j++){
                output_arr[row_num][column_num] = mat[i][j];
                column_num++;
                if(column_num == c){
                    row_num++;
                    column_num =0;
                }
            }
        }
        return output_arr;
    }
}
