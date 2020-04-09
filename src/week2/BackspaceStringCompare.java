package week2;

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

    public static boolean backspaceCompare(String S, String T) {
        StringBuilder sb1 = new StringBuilder();
        int x =0;
        for(int i =S.length()-1; i>=0; i--){
            char c = S.charAt(i);
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

        x =0;
        StringBuilder sb2 = new StringBuilder();
        for(int i =T.length()-1; i>=0; i--){
            char c = T.charAt(i);
            if(c=='#') {
                x++;
                continue;
            }
            if(x>0) {
                x--;

            } else{
                sb2.append(c);
            }
        }

        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String arg[]) {
        String S = "a#c";
        String T = "b";
        System.out.println(backspaceCompare(S, T));
    }
}
