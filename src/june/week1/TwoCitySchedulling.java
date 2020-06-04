package june.week1;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCitySchedulling {
    public int twoCitySchedCost(int[][] costs) {
        int N = costs.length / 2;
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
        }
        for (int j = 1; j <= N; j++) {
            dp[0][j] = dp[0][j - 1] + costs[j - 1][1];
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
            }
        }
        return dp[N][N];
    }

    public int twoCitySchedCostGreedy(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - a[1] - (b[0] - b[1]);
            }
        });
        int res = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            res += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length;i++) {
            res += costs[i][1];
        }
        return res;
    }
}
