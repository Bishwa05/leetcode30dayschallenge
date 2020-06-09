package june.week2;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        int count =0;
        int m =n;
        while(n>1){
            n = n>>1;
            count++;
        }
        return (m== n<<count)?true:false;
    }
}
