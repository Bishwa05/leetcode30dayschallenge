package sept21.week2;

/**
 *
 * Given a string s, reverse the string according to the following rules:
 *
 * All the characters that are not English letters remain in the same position.
 * All the English letters (lowercase or uppercase) should be reversed.
 * Return s after reversing it.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 *
 * Input: s = "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 *
 *
 */
public class ReverseOnlyLetters
{
    public String reverseOnlyLetters(String s) {

        char[] charArr = s.toCharArray();

        int p1 = 0;
        int p2 = s.length()-1;

        while(p1<=p2){
            if(((charArr[p1]>='a' && charArr[p1]<='z') ||
                (charArr[p1]>='A' && charArr[p1]<='Z')) &&
                ((charArr[p2]>='a' && charArr[p2]<='z') ||
                    (charArr[p2]>='A' && charArr[p2]<='Z'))){
                char c = charArr[p2];
                charArr[p2] = charArr[p1];
                charArr[p1] = c;
                p1++;
                p2--;
            } else if((charArr[p1]>='a' && charArr[p1]<='z') ||
                (charArr[p1]>='A' && charArr[p1]<='Z')){
                p2--;
            } else if((charArr[p2]>='a' && charArr[p2]<='z') ||
                (charArr[p2]>='A' && charArr[p2]<='Z')){
                p1++;
            } else{
                p1++;
                p2--;
            }
        }
        return new String(charArr);
    }
}
