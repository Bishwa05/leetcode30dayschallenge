package july.week1;

/**
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 *
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        StringBuffer s = new StringBuffer();
        boolean added = false;
        for(int i = digits.length-1; i>=0; i--){
            if(digits[i]==9 && !added){
                s.append(0);
            } else if (!added) {
                s.append(digits[i]+1);
                added = true;
            } else {
                s.append(digits[i]);
            }
        }
        if(!added){
            s.append(1);
        }
        char[] x = s.reverse().toString().toCharArray();
        int [] res = new int[x.length];
        for(int i=0; i<x.length; i++){
            res[i] = x[i]-48;
        }
        return res;
    }

    public static void main(String arg[]) {
        int []digits = {1,0,9};
        PlusOne p = new PlusOne();
        int[] res = p.plusOne(digits);
        for(int i =0; i< res.length; i++){
            System.out.print(res[i]);
        }
    }

}
