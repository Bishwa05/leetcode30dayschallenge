package jun21.week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * https://leetcode.com/problems/maximum-performance-of-a-team/solution/
 * Nice explaination
 */
class Engineer implements Comparable{
    int speed;
    int efficiency;

    Engineer(int speed, int efficiency){
        this.speed = speed;
        this.efficiency = efficiency;
    }

    public int compareTo(Object o){
        if(this.efficiency> ((Engineer)o).efficiency){
            return -1;
        } else {
            return 1;
        }
    }

}

public class MaximumPerformanceOfATeam
{
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        List<Engineer> listE = new ArrayList<>();

        for(int i =0; i<n; i++){
            Engineer e = new Engineer(speed[i], efficiency[i]);
            listE.add(e);
        }

        Collections.sort(listE);

        PriorityQueue<Integer> speedHeap = new PriorityQueue<>();

        long speedSum = 0, perf = 0;
        for (Engineer p : listE) {
            Integer currEfficiency = p.efficiency;
            Integer currSpeed = p.speed;
            // maintain a heap for the fastest (k-1) speeds
            if (speedHeap.size() > k - 1) {
                speedSum -= speedHeap.remove();
            }
            speedHeap.add(currSpeed);

            // calculate the maximum performance with
            // the current member as the least efficient one in the team
            speedSum += currSpeed;
            perf = Math.max(perf, speedSum * currEfficiency);
        }
        int MOD = 1_000_000_007;
        int res = (int)( perf %MOD);
        return res;
    }

    public static void main(String arg[]){
        MaximumPerformanceOfATeam m = new MaximumPerformanceOfATeam();
        int n = 6;
        int[] speed = {2,10,3,1,5,8};
        int[] efficiency = {5,4,3,9,7,2};
        int k = 3;
        System.out.println(m.maxPerformance(n, speed, efficiency, k));
    }
}
