package jun21.week1;

public class MinCostClimbingStairs
{
    public int minCostClimbingStairs(int[] cost) {
        int [] minCost = new int[cost.length+1];

        for(int i =2; i< minCost.length; i++){
            int takeOneStep = minCost[i-1]+ cost[i-1];
            int takeTwoStep = minCost[i-2] + cost[i-2];

            minCost[i] = Math.min(takeOneStep, takeTwoStep);
        }

        return minCost[minCost.length-1];

    }
}
