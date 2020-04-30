package april.week3;

public class MinimumSumPath {

    public static int minPathSum(int[][] grid){

        if(grid.length== 0) return 0;
        for(int i =1; i <grid.length; i++){
            grid[i][0] += grid[i-1][0];
        }

        for(int i =1; i <grid[0].length; i++){
            grid[0][i] += grid[0][i-1];
        }

        for(int i =1; i<grid.length; i++){
            for(int j =1; j< grid[0].length; j++){
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }

//        for(int i =0; i<grid.length; i++){
//            for(int j =0; j< grid[0].length; j++){
//                if(j ==0 && i>0){
//                    grid[i][j] += grid[i-1][j];
//                } else if(i ==0 && j>0){
//                    grid[i][j] += grid[i][j-1];
//                } else if(i>0 && j>0) {
//                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
//                }
//            }
//        }


        return grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String args[]) {
        int[][] arr = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(minPathSum(arr));
    }
}
