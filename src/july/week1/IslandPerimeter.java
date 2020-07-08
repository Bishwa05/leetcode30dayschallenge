package july.week1;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int count =0;
        int rows = grid.length;
        if(rows >0) {
            int cols = grid[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1) {

                        if (i == 0 || (i > 0 && grid[i - 1][j] == 0)) {
                            count++;
                        }

                        if (i == rows - 1 || (i < rows - 1 && grid[i + 1][j] == 0)) {
                            count++;
                        }

                        if (j == 0 || (j > 0 && grid[i][j - 1] == 0)) {
                            count++;
                        }
                        if (j == cols - 1 || (j < cols - 1 && grid[i][j + 1] == 0)) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;

    }

    public static void main(String arg[]){
        int mat[][] = {{1,1,1,1},
                        {1,1,1,1},
                        {1,1,1,1},
                        {1,1,0,0}};

        IslandPerimeter i = new IslandPerimeter();

        System.out.println(i.islandPerimeter(mat));
    }
}
