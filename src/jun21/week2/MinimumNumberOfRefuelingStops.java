package jun21.week2;

import java.sql.SQLOutput;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * A car travels from a starting position to a destination which is target miles east of the starting position.
 *
 * Along the way, there are gas stations.  Each station[i] represents a gas station that is station[i][0] miles east of the starting position, and has station[i][1] liters of gas.
 *
 * The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.  It uses 1 liter of gas per 1 mile that it drives.
 *
 * When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.
 *
 * What is the least number of refueling stops the car must make in order to reach its destination?  If it cannot reach the destination, return -1.
 *
 * Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.  If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
 *
 *
 *
 * Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * Output: 2
 * Explanation:
 * We start with 10 liters of fuel.
 * We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
 * Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
 * and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
 * We made 2 refueling stops along the way, so we return 2.
 *
 *
 */
public class MinimumNumberOfRefuelingStops
{
    public int minRefuelStops(int target, int startFuel, int[][]stations){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans= 0;
        int prev =0;

        for(int[] station : stations){
            int location = station[0];
            int capacity = station[1];
            startFuel -= location -prev;

            while(!pq.isEmpty() && startFuel <0){
                startFuel+= pq.poll();
                ans++;
            }

            if(startFuel <0) return -1;
            pq.offer(capacity);
            prev = location;

        }

        startFuel -= target-prev;

        while(!pq.isEmpty() && startFuel <0){
            startFuel += pq.poll();
            ans++;
        }

        if(startFuel <0) return -1;

        return ans;
    }

    public static void main(String arg[]){
        MinimumNumberOfRefuelingStops m = new MinimumNumberOfRefuelingStops();

        int target = 100, startFuel = 10;
        int[][] stations = {{10,60},{20,30},{30,30},{60,40}};

        System.out.println(m.minRefuelStops(target, startFuel, stations));
    }
}
