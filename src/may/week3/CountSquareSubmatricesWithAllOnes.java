package may.week3;

public class CountSquareSubmatricesWithAllOnes {

    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int result = 0;

        for(int i=0; i<rows; i++){
            for(int j = 0; j< cols; j++){
                if(matrix[i][j]>0 && i>0 && j>0){
                    matrix[i][j] = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1]))+1;

                }
                result +=matrix[i][j];
            }
        }
        return result;

    }

    public static void main(String arg[]){

        CountSquareSubmatricesWithAllOnes c = new CountSquareSubmatricesWithAllOnes();
        int[][] matrix =  {
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}};

        System.out.println(c.countSquares(matrix));

    }
}
