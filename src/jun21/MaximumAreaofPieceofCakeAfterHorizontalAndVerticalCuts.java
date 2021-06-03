package jun21;

import java.util.Arrays;

public class MaximumAreaofPieceofCakeAfterHorizontalAndVerticalCuts
{

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts)
    {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int m = horizontalCuts.length;
        int n = verticalCuts.length;

        int maxRow =0;
        int maxCol =0;

        for(int i =0; i<= m; i++){
            int row = (((i==m)?h:horizontalCuts[i])- ((i==0)?0:horizontalCuts[i-1]));
            maxRow = Math.max(row, maxRow);
        }

        for(int j =0; j<=n; j++){
            int col = (((j==n)?w:verticalCuts[j]) - ((j==0)?0:verticalCuts[j-1]));
            maxCol = Math.max(col, maxCol);
        }
        int MOD=1_000_000_007;

        return (int)(maxRow*1L*maxCol%MOD);
    }

    //Another approach
    public int maxArea2(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int MOD=1_000_000_007;

        int m = horizontalCuts.length, n = verticalCuts.length;
        int maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[m - 1]);
        int maxWidth = Math.max(verticalCuts[0], w - verticalCuts[n - 1]);

        for (int i = 1; i < horizontalCuts.length; ++i)
        {
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int i = 1; i < verticalCuts.length; ++i)
        {
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
        }

        return (int)(maxHeight * 1L * maxWidth % MOD);

    }
}
