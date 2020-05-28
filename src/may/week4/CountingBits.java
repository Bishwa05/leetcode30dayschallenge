package may.week4;

/**
 *
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] result = new int[num+1];

//        int p = 1; //p tracks the index for number x
//        int pow = 1;
//        for(int i=1; i<=num; i++){
//            if(i==pow){
//                result[i] = 1;
//                pow <<= 1;
//                p = 1;
//            }else{
//                result[i] = result[p]+1;
//                p++;
//            }
//
//        }

        for(int i=1; i<=num; i++){
            result[i] = result[i>>1]+ (i & 1);
        }

        return result;
    }

    public static void main(String arg[]){

        CountingBits c = new CountingBits();

        int [] arr = c.countBits(5);

        for(int i : arr) {
            System.out.print(i+" ");
        }
    }
}
