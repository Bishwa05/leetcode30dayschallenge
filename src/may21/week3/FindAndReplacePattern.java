package may21.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern
{
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(String word: words){
            if(word.length() != pattern.length()){
                continue;
            }
            Map<Character, Character> charMap = new HashMap<>();
            Map<Character, Character> charMap2 = new HashMap<>();
            boolean isMatch = true;;

            for(int i =0; i< word.length(); i++){
                char c = word.charAt(i);
                char k = pattern.charAt(i);
                if(!charMap.containsKey(k) && !charMap.values().contains(c)){
                    charMap.put(k, c);
                } else{
                    if(!charMap.containsKey(k)){
                        isMatch = false;
                    } else if(c != charMap.get(k)){
                        isMatch = false;
                    }
                }
            }

            if(isMatch){
                res.add(word);
            }

        }
        return res;
    }


    public static void main(String arg[]){
        String[] words = {"ccc"};
        String pattern = "abb";
        FindAndReplacePattern f = new FindAndReplacePattern();
        f.findAndReplacePattern(words, pattern);
    }
}
