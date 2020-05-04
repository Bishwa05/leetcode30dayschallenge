package may;

public class NumberComplement {
    public int findComplement(int num) {
        int ans = 0;
        int count =0;

        while(num>0){
            if((1&num) ==  0){
                ans = ans + (int)Math.pow(2,count);
            }
            num = num>>1;
            count++;
        }

//  The below approach not works properly for num = 2^31+1 and 2^31
//       int x = (int)Math.pow(2,count)-1;
//       int y = (x)^num;
       return ans;

    }

    public static void main(String arg[]){
        NumberComplement n = new NumberComplement();
        System.out.println(n.findComplement(5));
    }
}
