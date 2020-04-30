package april.week2;

/**
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 */
public class BackspaceStringCompare {
    public static String getFormattedString(String str) {
        StringBuilder sb1 = new StringBuilder();
        int x =0;
        for(int i =str.length()-1; i>=0; i--){
            char c = str.charAt(i);
            if(c=='#') {
                x++;
                continue;
            }
            if(x>0) {
                x--;

            } else{
                sb1.append(c);
            }

        }

    return sb1.toString();
    }

    public static boolean backspaceCompare(String S, String T) {
        return getFormattedString(S).equals(getFormattedString(T));
    }

    public static void main(String arg[]) {
        String S = "a#c";
        String T = "b";
        System.out.println(backspaceCompare(S, T));
    }
}
