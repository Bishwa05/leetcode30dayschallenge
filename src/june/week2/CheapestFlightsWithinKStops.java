package june.week2;

import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //convert flights[] to a weighted graph
        //perform BFS starting from src going only max depth of K
        //For Each node track the cost associated to reach that node
        int min = Integer.MAX_VALUE;
        int[][] graph = new int[n][n];
        int[] minPrices = new int[n];
        for (int[] flight : flights) {
            int start = flight[0];
            int end = flight[1];
            graph[start][end] = flight[2];
        }
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> prices = new LinkedList<>();
        q.add(src);
        prices.add(0);
        while (!q.isEmpty() && K >= 0) {
            K--;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int start = q.poll();
                int priceTillNow = prices.poll();
                for (int j = 0; j < n; j++) {
                    int price = graph[start][j];
                    if (price > 0) {    //there is a flight
                        int curPrice = priceTillNow + price;
                        int oldPrice = minPrices[j];
                        //If there is a cheaper flight with lesser stops do not add it to q
                        if (oldPrice == 0 || oldPrice > curPrice) {//pruning
                            minPrices[j] = curPrice;
                            q.add(j);
                            prices.add(curPrice);
                            if (j == dst && min > curPrice) {
                                min = curPrice;
                            }
                        }
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String arg[]) {
        int n = 3;
        int [][]edges = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int k = 0;

        CheapestFlightsWithinKStops c = new CheapestFlightsWithinKStops();
        System.out.println(c.findCheapestPrice(n, edges, src, dst, k));

    }
}
