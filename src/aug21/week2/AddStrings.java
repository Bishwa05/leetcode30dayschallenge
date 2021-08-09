package aug21.week2;

/**
 *
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 *
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 * Example 2:
 *
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 *
 *
 */
public class AddStrings
{

    public String addStrings(String num1, String num2) {
        int n1 = num1.length()-1;
        int n2 = num2.length()-1;

        StringBuilder sb = new StringBuilder();

        int carry = 0;
        while(n1 >=0 || n2 >=0) {
            if(n1 >=0 && n2>=0) {
                int x = num1.charAt(n1)-'0' + num2.charAt(n2) -'0' + carry;
                sb.append(x%10);
                carry = x/10;
                n1--;
                n2--;
            } else if(n1>=0) {
                int x = num1.charAt(n1)-'0' + carry;
                sb.append(x%10);
                carry =x/10;
                n1--;
            } else {
                int x = num2.charAt(n2)-'0' + carry;
                sb.append(x%10);
                carry =x/10;
                n2--;
            }
        }
        if(carry !=0) sb.append(carry);
        return sb.reverse().toString();
    }

}
