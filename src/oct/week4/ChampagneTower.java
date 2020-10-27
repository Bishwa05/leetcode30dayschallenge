package oct.week4;

public class ChampagneTower
{
    public double champagneTower(int poured, int query_row, int query_glass) {
        double [][] arr = new double[101][101];
        for(int i =0; i<= query_row; i++){
            //int k = i<query_glass?i:query_glass;
            for(int j =0; j<= i; j++) {
                if (poured - (i + 1) > 0) {
                    arr[i][j] = 1;
                }
                else {
                    arr[i][j] = (double)poured / (i + 1);
                }
            }
                poured = poured - (i + 1);
        }

        return arr[query_row][query_glass];

    }

    public static void main(String arg[]){
        ChampagneTower c = new ChampagneTower();
        System.out.println(c.champagneTower(25,6,1));
    }
}
