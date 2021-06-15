package jun21.week2;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumUnitsOnATruck
{
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[1], a[1]));

        for(int[] arr : boxTypes){
            pq.offer(arr);
        }

        int res = 0;

        while(truckSize>0 && pq.size()>0    ){
            int[] element = pq.poll();

            int k = element[0];
            if(truckSize> k){
                res+= k*element[1];
            } else{
                res+= element[1]*truckSize;
            }
            truckSize -= k;

        }
        return res;

    }
}
