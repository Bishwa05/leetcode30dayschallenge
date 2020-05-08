package may.week1;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {

        Set<Character> charSet = new HashSet<>();

        for(char a : J.toCharArray()){
            charSet.add(a);
        }
        int count =0;
        for(int i =0; i<S.length(); i++){
            if(charSet.contains(S.charAt(i))){
                count++;
            }
        }
        return count;

    }
}
