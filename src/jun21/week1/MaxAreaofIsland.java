package jun21.week1;

public class MaxAreaofIsland
{
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(n ==0) return 0;

        int arr[] = {0}; // To store count;
        int max = 0;
        for(int i =0; i<m; i++){
            for(int j =0; j< n; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j, arr);
                    max = Math.max(max, arr[0]);
                    arr[0] = 0;
                }
            }
        }
        return max;
    }

    public void dfs(int[][]grid, int i, int j, int[]arr) {
        if(grid[i][j] ==0) return;

        arr[0] = arr[0]+1;
        grid[i][j] =0;

        int m = grid.length;
        int n = grid[0].length;

        if(i+1<m) dfs(grid, i+1, j, arr);
        if(j+1<n) dfs(grid, i, j+1, arr);
        if(i-1>=0) dfs(grid, i-1, j, arr);
        if(j-1>=0) dfs(grid, i, j-1, arr);
        return;
    }


    public static void main(String args[]){
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        MaxAreaofIsland m = new MaxAreaofIsland();
        System.out.println(m.maxAreaOfIsland(grid));
    }
}
