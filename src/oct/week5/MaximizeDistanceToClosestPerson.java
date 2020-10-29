package oct.week5;

import java.util.Arrays;

public class MaximizeDistanceToClosestPerson
{

    public int maxDistanceToClosest(int[] seats){
        int N = seats.length;
        int[] left = new int[N], right = new int[N];

        Arrays.fill(left, N);
        Arrays.fill(right, N);


        for(int i =0; i<N; ++i){
            if(seats[i] == 1) left[i] =0;
            else if(i >0) left[i] = left[i-1]+1;
        }

        for(int i = N-1; i>=0; --i){
            if(seats[i]==1) right[i] = 0;
            else if(i< N-1) right[i] = right[i+1]+1;
        }

        int ans =0;

        for(int i =0; i<N; ++i){
            if(seats[i] ==0){
                ans = Math.max(ans, Math.min(left[i], right[i]));
            }
        }
        return ans;
    }


    public static void main(String arg[]){
        int[] nums = {1,0,0,0,1,0,1};
        MaximizeDistanceToClosestPerson m = new MaximizeDistanceToClosestPerson();
        System.out.println(m.maxDistanceToClosest(nums));
    }
}
