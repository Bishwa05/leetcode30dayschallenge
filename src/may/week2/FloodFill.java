package may.week2;

/**
 *
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 *
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor) return image;
        fill(image,sr, sc, image[sr][sc], newColor);
        return image;
    }

    public void fill(int[][] image, int sr, int sc, int currColor, int newColor){
        if(sr<0 || sc<0 || sr>=image.length || sc >= image[0].length ||image[sr][sc] != currColor){
            return;
        }
//
//        if(image[sr][sc] != currColor){
//            return;
//        }

        if (image[sr][sc]==currColor)
            image[sr][sc]=newColor;

        //image[sr][sc]= newColor;
        fill(image, sr-1, sc, currColor, newColor);
        fill(image, sr+1, sc, currColor, newColor);
        fill(image, sr, sc-1, currColor, newColor);
        fill(image, sr, sc+1, currColor, newColor);
    }
    public static void main(String[] args) {
        FloodFill f = new FloodFill();
        int [][] im = {{1,1,1},{1,1,1},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int [][] a = f.floodFill(im, sr, sc, newColor);

        for(int[] x  : a){
            for(int y: x ){
                System.out.print(y+" ");
            }
            System.out.print("");
        }
    }
}
