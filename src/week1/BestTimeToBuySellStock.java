package week1;

public class BestTimeToBuySellStock {

    // The 2nd best solution.
    public static int maxProfit(int prices[]) {
        int maxProfit =0;
        int n = prices.length;

        int i=0;

        while(i<n-1) {
            //Find local min
            // Next i  should  be less  than current  i
            while(i<n-1 && prices[i+1]<= prices[i]) i++;

            if(i==n-1)
                break;

            int buyIndex = i;
            i++;


            //current i should be > previous i
            while(i<n && prices[i]>=prices[i-1]) i++;

            int selIndex= i-1;
            maxProfit +=prices[selIndex]-prices[buyIndex];
        }
        return maxProfit;
    }

    // The best solution
    public static int maxProfit2(int prices[]){
        int res = 0;
        for(int i = 1; i < prices.length; i++)
            if(prices[i] > prices[i - 1])
                res += prices[i] - prices[i - 1];
        return res;
    }

    /**
     * Another approach with DP
     *
     * Here the we have 2 state everytime,
     * comparision between 1 stock vs money without stock
     * bestWithoutStock-i --> buying the stock -> to become -> bestWithStock
     * bestWithStock+i --> selling the stock -> to become -> bestWithoutStock
     * @param prices
     * @return
     */
    public static int maxProfit3(int prices[]) {
        int bestWithoutStock = 0;
        int bestWithStock = Integer.MIN_VALUE;

        for(int i : prices) {
            bestWithStock = Math.max(bestWithStock, bestWithoutStock-i);
            bestWithoutStock = Math.max(bestWithoutStock, bestWithStock+i);
        }
        return bestWithoutStock;
    }


    public static void main(String args[]) {
        int arr[] ={7,1,5,3,6,4};
        //int arr[]= {1,2,3,4,5};
        //int arr[] ={7,6,4,3,1};
        //int arr[] ={1};
        System.out.println(maxProfit3(arr));

    }
}
