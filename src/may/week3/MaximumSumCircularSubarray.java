package may.week3;

import java.util.Arrays;

public class MaximumSumCircularSubarray {

    public static int kadane(int[] A)
    {
        int max_so_far = 0;
        int max_ending_here = 0;


        for (int i = 0; i < A.length; i++)
        {
            max_ending_here = max_ending_here + A[i];

            max_ending_here = Integer.max(max_ending_here, 0);

            max_so_far = Integer.max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }

    public int maxSubarraySumCircular(int[] A) {

        int maxSum = Integer.MIN_VALUE;
        boolean anyPositive =  false;

        for(int i : A) {
            if(i>=0) {
                anyPositive= true;
            }

            if(i>maxSum){
                maxSum =i;
            }
        }

        if(!anyPositive) {
            return maxSum;
        }


        int normalMax = kadane(A);
        int sum = Arrays.stream(A).sum();
        for (int i = 0; i < A.length; i++) {
            A[i] = -A[i];
        }

        // run Kadane's algorithm on modified array
        int negMaxSum = kadane(A);

        // restore the array
//        for (int i = 0; i < A.length; i++) {
//            A[i] = -A[i];
//        }

		/*  return maximum of

			1. sum returned by Kadane's algorithm on original array.

			2. sum returned by Kadane's algorithm on modified array +
				sum of all elements of the array.
		*/

        return Integer.max(normalMax, sum + negMaxSum);

    }

    public static void main(String arg[]){

        MaximumSumCircularSubarray m = new MaximumSumCircularSubarray();
        int [] arr ={5,-3,5};
        System.out.println(m.maxSubarraySumCircular(arr));

    }
}
