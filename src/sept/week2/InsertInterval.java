package sept.week2;

import java.util.ArrayList;
import java.util.List;

class Interval {
    int start;
    int end;
    Interval(){start =0; end =0;}
    Interval(int s, int e) {start = s; end =e;}
}
public class InsertInterval
{

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<Interval> intervals2 = new ArrayList<>();
        for(int i =0; i< intervals.length; i++){
            intervals2.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        Interval newInterval2 = new Interval(newInterval[0], newInterval[1]);

        ArrayList<Interval> result = new ArrayList<>();

        for(Interval interval: intervals2){
            if(interval.end < newInterval2.start){
                result.add(interval);
            }else if(interval.start > newInterval2.end){
                result.add(newInterval2);
                newInterval2 = interval;
            }else if(interval.end >= newInterval2.start || interval.start <= newInterval2.end){
                newInterval2 = new Interval(Math.min(interval.start, newInterval2.start), Math.max(newInterval2.end, interval.end));
            }
        }

        result.add(newInterval2);

        int[][] resArr = new int[result.size()][2];

        for(int i=0; i< result.size(); i++){
            resArr[i][0] = result.get(i).start;
            resArr[i][1] = result.get(i).end;
        }

        return resArr;

    }
}
