package dec;

public class PairsSongsTotalDurationsDivisibleBy60
{

    public int numPairsDivisibleBy60(int [] times){
        int [] modTimes = new int[60];
        for(int songTime : times)
            modTimes[songTime%60]++;

        int totalPairs =0;
        totalPairs += findPairs(modTimes[0]);
        totalPairs += findPairs(modTimes[30]);

        for(int i =1; i<=29; i++)
            totalPairs +=modTimes[i] * modTimes[60-i];

        return totalPairs;
    }

    public int findPairs(int n){
        return n*(n-1)/2;
    }

    public static void main(String arg[]){
        int[] arr = {30,20,150,100,40};
        PairsSongsTotalDurationsDivisibleBy60 p = new PairsSongsTotalDurationsDivisibleBy60();
        System.out.println(p.numPairsDivisibleBy60(arr));
    }
}
