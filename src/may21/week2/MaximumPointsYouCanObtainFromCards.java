package may21.week2;

import java.util.HashMap;
import java.util.Map;

public class MaximumPointsYouCanObtainFromCards
{

    public int maxScore(int[] arr, int k)
    {
        int total =0;
        for(int i=0; i<k; i++) total+=arr[i];
        int best = total;

        for(int i = k-1, j = arr.length-1; i>=0; i--, j--){
            total += arr[j] - arr[i];
            best = Math.max(best, total);
        }
        return best;
    }

    //Another approach easier to code
    public int maxScor2(int[] cardPoints, int k) {
        int[] left = new int[k+1];
        int[] right = new int[k+1];

        int ans = 0;

        left[0] = 0;
        right[0] = 0;

        left[1] = cardPoints[0];
        right[1] = cardPoints[cardPoints.length-1];


        for(int i=1;i<=k;i++){
            left[i] = left[i-1] + cardPoints[i-1];
        }

        for(int i=1;i<=k;i++)
            right[i] = right[i-1] + cardPoints[cardPoints.length-i];

        for(int i=0;i<=k;i++){
            ans = Math.max(ans , left[i]+right[k-i]);
        }

        return ans ;

    }

    public static void main(String arg[]){
        MaximumPointsYouCanObtainFromCards m = new MaximumPointsYouCanObtainFromCards();
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(m.maxScore(cardPoints, k));
    }
}
