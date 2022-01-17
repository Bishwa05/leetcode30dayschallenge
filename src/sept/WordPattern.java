package sept;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern
{
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> hMap = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] sArr = str.split(" ");

        if(sArr.length != pattern.length()) return false;
        for(int i =0; i< pattern.length(); i++){

            char key = pattern.charAt(i);
            if(hMap.containsKey(key)){
                //System.out.println(sArr[i]+"--"+hMap.get(key));
                if(!hMap.get(key).equals(sArr[i])){
                    return false;
                }
            } else{
                hMap.put(key, sArr[i]);
                if(!set.add(sArr[i])){
                    return false;
                }
            }
        }
        return true;
    }


    public boolean wordPattern2(String pattern, String s) {

        String[] strArr = s.split(" ");
        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> wordMap = new HashMap<>();

        if(pattern.length() != strArr.length) return false;

        for(int i = 0; i<strArr.length; i++){
            char c = pattern.charAt(i);
            String word = strArr[i];
            if(charMap.containsKey(c)) {
                if(!charMap.get(c).equals(word)) return false;
            } else if(wordMap.containsKey(word)){
                if(!wordMap.get(word).equals(c)) return false;
            } else {
                charMap.put(c, word);
                wordMap.put(word, c);
            }
        }
        return true;

    }

    public static void main(String[] args) {
        WordPattern w = new WordPattern();
        System.out.println(w.wordPattern2("abba", "cat dog dog cat"));
    }
}
