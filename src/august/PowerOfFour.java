package august;

public class PowerOfFour
{
    public boolean isPowerOfFour(int num) {
        int count0=0;
        int count1=0;

        while(num>0) {
            if((num&1)==1){
                count1++;
            }else{
                count0++;
            }

            num>>=1;
        }

        return count1==1 && (count0%2==0);
    }


    public boolean isPowerOfFourMath(int num) {
        if(num==0) return false;

        int pow = (int) (Math.log(num) / Math.log(4));
        if(num==Math.pow(4, pow)){
            return true;
        }else{
            return false;
        }
    }
}
