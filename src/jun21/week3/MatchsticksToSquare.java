package jun21.week3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MatchsticksToSquare
{
    List<Integer> nums;
    int[] sums = new int[4];
    int possibleSquareSide;

    public boolean makesquare(int[] matchsticks) {

        if(matchsticks.length ==0) return false;

        int sum =0;
        for(int i : matchsticks){
            sum+=i;
        }
        if(sum%4 !=0) return false;

        this.possibleSquareSide = sum/4;

        this.nums = Arrays.stream(matchsticks).boxed().collect(Collectors.toList());
        Collections.sort(this.nums, Collections.reverseOrder());
        return this.dfs(0);

    }

    public boolean dfs(int index) {
        if(index == this.nums.size()){
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }

        int element = this.nums.get(index);

        for(int i =0; i<4; i++){
            if(this.sums[i] + element <= this.possibleSquareSide){
                this.sums[i]+= element;
                if(dfs(index+1)){
                    return true;
                }
                this.sums[i] -= element;
            }
        }
        return false;
    }
}
