package week3;

public class NumberOfIslands {

    public static void dfsToAll(char[][] grid, int row, int col) {
        if(grid[row][col]=='0') return;

        grid[row][col] ='0';

        if(row+1<grid.length) dfsToAll(grid,row+1,col);
        if(row-1>=0) dfsToAll(grid,row-1,col);

        if(col+1<grid[0].length) dfsToAll(grid,row,col+1);
        if(col-1>=0) dfsToAll(grid,row,col-1);
    }

    public static int numIslands(char[][] grid) {
        int count =0;
        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    dfsToAll(grid, i, j);
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String arg[]){

        char [][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));

    }
}
