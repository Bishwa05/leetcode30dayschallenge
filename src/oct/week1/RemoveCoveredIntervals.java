package oct.week1;

import java.util.*;

public class RemoveCoveredIntervals
{
    public int removeCoveredIntervals(int[][] intervals) {


        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        int[] currInt = {-1, -1};
        int overlap = 0;
        for(int[] interval: intervals) {
            if(currInt[0] <= interval[0] && currInt[1] >= interval[1]) {
                overlap++;
            } else {
                if(currInt[0] >= interval[0] && currInt[1] <= interval[1])
                    overlap++;
                currInt = interval;
            }
        }

        return intervals.length - overlap;
    }

    public static void main(String arg[]){
        //int [][] intervals = {{1,2},{1,4},{3,4}};
        int [][] intervals = {{1,4},{3,6},{2,8}};
        RemoveCoveredIntervals r = new RemoveCoveredIntervals();
        System.out.println(r.removeCoveredIntervals(intervals));

    }
}
