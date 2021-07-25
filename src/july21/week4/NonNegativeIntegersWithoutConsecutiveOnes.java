package july21.week4;

public class NonNegativeIntegersWithoutConsecutiveOnes
{

    public int findIntegers(int num){
        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;

        for(int i = 2; i< f.length; i++){
            f[i] = f[i-1] +f[i-2];
        }
        int i =30, sum =0, prevBit = 0;

        while(i>=0){
            if((num &(1<<i))!=0){
                sum +=f[i];
                if(prevBit ==1){
                    sum--;
                    break;
                }
                prevBit = 1;
            } else {
                prevBit = 0;
            }
            i--;
        }
        return sum+1;
    }

    public static void main (String[] args)
    {
        NonNegativeIntegersWithoutConsecutiveOnes n = new NonNegativeIntegersWithoutConsecutiveOnes();
        System.out.println(n.findIntegers(5));
    }
}
