package april.week4;

public class MaximalSquare {
    /**
     * Brute force solution.From each cell
     * find the biggest square submatrix for which
     * it is the upper left-hand corner
     *
     * In order to evaluate the runtime of this code, we can examine
     * our recursion at a high level. With each turn, we make three
     * recursive calls. Therefore, we branch by 3 each time and get a
     * runtime of 3 * 3 * 3 * … or 3^x. In this case, x is the depth of
     * our recursion. Since in each turn, we either go down or left in our
     * matrix, we can find that the maximum depth of our recursion is
     * n + m for an n by m matrix. In this solution, we also have to do
     * our recursive call for each of the n * m cells. We, therefore, get
     * a runtime of O(n * m * 3 ^ (n + m)).
     *
     */
    public int squareSubmatrix(char[][] arr) {
        int max = 0;
        // Compute for each cell the biggest subarray
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j]=='1') max =
                        Math.max(max,squareSubmatrix(arr,i,j));
            }
        }
        return max*max;
    }

    // Overloaded recursive function
    private int squareSubmatrix(char[][] arr, int i, int j) {
        // Base case at bottom or right of the matrix
        if (i == arr.length || j == arr[0].length)
            return 0;
        // If the cell is false then it’s not part
        // of a valid submatrix
        if (arr[i][j]=='0') return 0;
        // Find the size of the right, bottom, and
        // bottom right submatrices and add 1 to the
        // minimum of those 3 to get the result
        return 1 + Math.min(Math.min(
                squareSubmatrix(arr, i+1, j),
                squareSubmatrix(arr, i, j+1)),
                squareSubmatrix(arr, i+1, j+1));
    }

    /** Top down dynamic programming solution. Cache
     *  the values to avoid repeating computations
     **/
    public int squareSubmatrixMemo(char[][] arr) {
        // Initialize cache. Don't need to initialize
        // to -1 because the only cells that will be
        // 0 are ones that are '0' and we want to
        // skip those ones anyway
        int[][] cache =
                new int[arr.length][arr[0].length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j]=='1') max = Math.max(max,
                        squareSubmatrix(arr, i, j, cache));
            }
        }
        return max*max;
    }
    // Overloaded recursive function
    private int squareSubmatrix(char[][] arr,
                                int i, int j, int[][] cache) {
        if (i == arr.length || j == arr[0].length)
            return 0;
        if (arr[i][j]=='0') return 0;

        // If the value is set in the cache return
        // it. Otherwise compute and save to cache
        if (cache[i][j] > 0) return cache[i][j];
        cache[i][j] = 1 + Math.min(Math.min(
                squareSubmatrix(arr, i+1, j, cache),
                squareSubmatrix(arr, i, j+1, cache)),
                squareSubmatrix(arr, i+1, j+1, cache));
        return cache[i][j];
    }


    //DP approach
    public int maximalSquare(char[][] matrix) {

        int max =0;

        if(matrix.length ==0) return 0;
        if(matrix[0].length ==0) return 0;


        int rows = matrix.length;
        int cols = matrix[0].length;

        int dp[][] = new int[rows+1][cols+1];

        for(int i=1;i<=rows; i++){
            for(int j =1; j<= cols; j++){
                if(matrix[i-1][j-1]=='0'){
                    dp[i][j] = 0;
                } else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]),
                            dp[i-1][j-1]) +1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max*max;
    }

    public static void main(String arg[]){
        char[][] ch = {{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};

        MaximalSquare m = new MaximalSquare();
        System.out.println(m.maximalSquare(ch));
        System.out.println(m.squareSubmatrix(ch));
        System.out.println(m.squareSubmatrixMemo(ch));

    }
}
