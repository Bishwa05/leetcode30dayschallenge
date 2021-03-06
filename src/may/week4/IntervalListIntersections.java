package may.week4;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {

        List<int[]> result = new ArrayList();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi)
                result.add(new int[]{lo, hi});

            /**
             * This is actually a 2 pointer concept.
             * if high of array A finishes first we need to increase i pointer
             * if high of Array B finishes first we need to increase j pointer.
             */
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String arg[]){

        IntervalListIntersections l = new IntervalListIntersections();
        int [][] A ={{0,2},{5,10},{13,23},{24,25}};
        int [][] B = {{1,5},{8,12},{15,24},{25,26}};

        int res[][] = l.intervalIntersection(A, B);

        for(int i =0; i<res.length; i++){
            System.out.println( res[i][0] +" - "+ res[i][1]);
        }

    }
}
