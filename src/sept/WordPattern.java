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
}
