package july21.week2;

import java.util.HashMap;

/**
 *
 * order and str are strings composed of lowercase letters. In order, no letter occurs more than once.
 *
 * order was sorted in some custom order previously. We want to permute the characters of str so that they match the order that order was sorted. More specifically, if x occurs before y in order, then x should occur before y in the returned string.
 *
 * Return any permutation of str (as a string) that satisfies this property.
 *
 * Example:
 * Input:
 * order = "cba"
 * str = "abcd"
 * Output: "cbad"
 * Explanation:
 * "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".
 * Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.
 *
 */
public class CustomSortString
{
    public String customSortString(String order, String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        String res = "";

        for(int i =0; i<order.length(); i++){
            char ch = order.charAt(i);
            if(!map.containsKey(ch)) continue;

            int freq = map.get(ch);
            for(int j =0; j<freq; j++){
                res+= Character.toString(ch);
            }
            map.remove(ch);
        }

        for(Character rest: map.keySet()){
            int freq = map.get(rest);

            for(int j =0; j<freq; j++){
                res+= Character.toString(rest);
            }
        }
        return res;
    }
}
