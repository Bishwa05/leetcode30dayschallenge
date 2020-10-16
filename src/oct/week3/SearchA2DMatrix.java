package oct.week3;

public class SearchA2DMatrix
{
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length==0) return false;
        if(matrix[0].length ==0) return false;

        //get the row
        boolean found = false;
        int row = 0;
        for(int i =0; i<matrix.length; i++){

            if(matrix[i][0]==target){
                found = true;
                break;
            } else if(matrix[i][0]<target){
                row = i;
            } else{
                break;
            }
        }

        if(!found){

            for(int i =0; i< matrix[0].length; i++){

                if(matrix[row][i] == target){
                    found = true;
                    break;
                }
            }
        }

        return found;

    }
}
