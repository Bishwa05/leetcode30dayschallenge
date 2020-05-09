package may.week2;

public class ValidPerfectSquare {

    public boolean isPerfectSquareEfficient(int num) {
        int n = num;
        while(n>0){

            int half = (n/2);
            //System.out.println(half);
            if(half*half>num || half*half<0)
                n=n/2;
            else if( half * half <=num && half*half>=0){
                for(int i = half; i<=n; i++){
                    if(i * i ==num)
                        return true;
                }
                return false;
            }
        }
        return false;
    }

    /**
     * Not efficient one.
     */
    public boolean isPerfectSquare(int num) {
        if(num ==1) return true;
        for(int i=1; i<=num/2; i++){
            if(i*i == num){
                return true;
            }else if(i*i > num){
                break;
            }
        }
        return false;
    }


}
