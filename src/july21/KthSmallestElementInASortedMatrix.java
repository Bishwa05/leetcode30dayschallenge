package july21;

import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix
{
    public int kthSmallest(int[][] matrix, int k) {

        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                pq.add(matrix[i][j]);
            }
        }

        while(k>1){
            pq.remove();
            k-=1;
        }

        return pq.remove();

    }
}
