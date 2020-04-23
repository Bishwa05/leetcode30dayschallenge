package week4;

public class BitwiseANDofNumbersRange {
    public static int rangeBitwiseAnd(int m, int n) {

        int step = 0;
        while(m!=n){
            m >>= 1;
            n >>= 1;
            step ++;
        }
        return m<<step;

        // while (n > m) {
        //     n = n & n - 1;
        //  }
        //  return m & n;

    }

    /**
     * 110
     *
     * 1000
     * 1001
     * 1010
     * @param arg
     */
    public static void main(String arg[]){
        int m =6; int n =7;
        //int m =1; int n = 2147483647;
        //int m =1; int n =3;
        System.out.println(rangeBitwiseAnd(m,n));

    }
}
