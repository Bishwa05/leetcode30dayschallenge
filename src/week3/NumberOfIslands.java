package week3;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * In bfs approach
     *  1. iterate over each element
     *  2. if 1 is found then put (i,j) in queue.
     *  3. extract (i,j) from queue make it 0 and search in surroundings 1.
     *  4. repeat step 2 until the iteration in step 1 is over.
     *
     */
    class CoOrdinates{
        int i;
        int j;

        CoOrdinates(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    //Time limit exceeded in leetcode in this approach
    public int numIslandsBFS(char [][] grid){
        int count =0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<CoOrdinates> q = new LinkedList<>();
        for(int i=0; i<rows; i++){
            for(int j =0; j<cols; j++){
                if('1'==grid[i][j]){
                    count++;
                    CoOrdinates c =  new CoOrdinates(i,j);
                    q.offer(c);

                    while(!q.isEmpty()){
                        CoOrdinates n = q.poll();
                        grid[n.i][n.j]='0';
                        if(n.i-1>=0 && '1' == grid[n.i-1][n.j]){
                            CoOrdinates d =  new CoOrdinates(n.i-1,n.j);
                            q.offer(d);
                        }
                        if(n.i+1<rows && '1' == grid[n.i+1][n.j]){
                            CoOrdinates d =  new CoOrdinates(n.i+1,n.j);
                            q.offer(d);
                        }
                        if(n.j-1>=0 && '1' == grid[n.i][n.j-1]){
                            CoOrdinates d =  new CoOrdinates(n.i,n.j-1);
                            q.offer(d);
                        }
                        if(n.j+1<cols && '1' == grid[n.i][n.j+1]){
                            CoOrdinates d =  new CoOrdinates(n.i,n.j+1);
                            q.offer(d);
                        }

                    }
                }
            }
        }
        return count;
    }

    public static void main(String arg[]){

//        char [][] grid = {{'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0','0','0','0','0'}
//        };

        char [][] grid ={{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        NumberOfIslands n = new NumberOfIslands();
        System.out.println(n.numIslandsBFS(grid));
        //System.out.println(numIslands(grid));

    }
}
