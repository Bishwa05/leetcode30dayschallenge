package june.week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChangeII {

    public int change(int amount, int[] coins) {
        Map<String, Integer> lookup = new HashMap<>();
        return count(coins,coins.length-1, amount, lookup);
    }

    /**
     * DP top-down approach, which actually slow in submission coz of recursion
     *
     */
    public int count(int S[], int n, int N, Map<String, Integer> lookup)
    {
        if (N == 0) {
            return 1;
        }

        if (N < 0 || n < 0) {
            return 0;
        }

        String key = n + "|" + N;

        if (!lookup.containsKey(key))
        {
            int include = count(S, n, N - S[n], lookup);
            int exclude = count(S, n - 1, N, lookup);

            lookup.put(key, include + exclude);
        }

        return lookup.get(key);
    }

    public int changeOptimized(int amount, int[] coins) {

        int dp[] = new int[amount+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for(int coin:coins)
        {
            for(int j = coin; j<=amount; j++){
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

}
