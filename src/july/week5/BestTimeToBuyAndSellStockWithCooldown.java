package july.week5;

public class BestTimeToBuyAndSellStockWithCooldown
{

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<2){
            return 0;
        }
        int []buy = new int[n];
        int []sell = new int[n];

        for(int i =0; i< buy.length; i++){
            buy[i] = Integer.MIN_VALUE;
        }

        for(int i=0; i<n; i++){
            buy[i] = Math.max((i>0?buy[i-1]: -prices[0]), (i>1?sell[i-2]: 0) -prices[i]);
            sell[i] = Math.max((i>0?sell[i-1]:0), (i>0?buy[i-1]: -prices[0]) + prices[i]);
        }
        return sell[n-1];

    }
}
