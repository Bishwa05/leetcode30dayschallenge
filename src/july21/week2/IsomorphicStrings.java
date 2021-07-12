package july21.week2;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings
{
    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()) return false;

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        int i =0;
        int n = s.length();

        while(i<n){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(sMap.containsKey(c1)){
                if(sMap.get(c1) != c2) return false;
            } else{
                if(!tMap.containsKey(c2)){
                    sMap.put(c1, c2);
                    tMap.put(c2, c1);
                } else{
                    return false;
                }

            }
            i++;
        }

        return true;
    }
}
