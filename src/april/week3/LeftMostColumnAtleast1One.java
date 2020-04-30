package april.week3;

public class LeftMostColumnAtleast1One {

    //This approach is not efficient failed in submission.
    public static int searchLeft1(int[][] binaryMatrix, int row, int r){

        int l =0;
 //       int prevVal =0;

        while(l<=r){
            int mid = (l+r)/2;
            int val = binaryMatrix[row][mid];

            if(mid ==0 && val ==1){
                return mid;
            }
            if(mid>0) {
                int prevVal = binaryMatrix[row][mid-1];

                if(val ==1 && prevVal==0){
                    return mid;
                }
            }

//            if(l==r && prevVal!=val) {
//                return mid;
//            }

//            prevVal = val;
             if(val==1){
                 r= mid-1;
             } else{
                 l = mid+1;
             }
        }

      return -1;

    }

    public static int leftMostColumnWithOne(int[][] binaryMatrix) {

        int rows = binaryMatrix.length-1;
        int cols = binaryMatrix[0].length-1;
        int col =cols+1;

        int i=0;
        while(i<=rows){
            int pos = searchLeft1(binaryMatrix,i,cols);
            if(pos !=-1) {
                col = Math.min(col, pos);
            }
            if(pos ==0) return 0;
            i++;
        }
        return col==cols+1?-1:col;
    }

//    Accepted Solutions

//    public static int leftMostColumnWithOne(){
//        List<Integer> x = binaryMatrix.dimensions();
//        int rows = x.get(0)-1;
//        int cols = x.get(1)-1;
//        int col =-1;
//
//        if(rows ==0 || cols ==0) return -1;
//
//        int i=0; int j =cols;
//
//        while(i<=rows && j>=0) {
//            if(binaryMatrix.get(i,j) ==1){
//                col=j;
//                j--;
//            } else{
//                i++;
//            }
//        }
//        return col;
//
//    }

    public static void main(String arg[]) {
        int [][] mat = {{0,0,0},{0,0,0},{1,1,1}};
        System.out.println(leftMostColumnWithOne(mat));
    }
}
