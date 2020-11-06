package nov;

public class MinimumCostToMoveChipsToTheSamePosition
{
    public int minCostToMoveChips(int[] position) {
        int evenCount =0;
        int oddCount =0;
        for(int i : position){
            if(i%2 == 0){
                evenCount++;
            }else{
                oddCount++;
            }
        }
        return Math.min(oddCount, evenCount);

    }
}
