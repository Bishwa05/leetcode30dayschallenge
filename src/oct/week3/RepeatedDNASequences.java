package oct.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences
{
    public List<String> findRepeatedDnaSequences(String s){
        List<String> repeadedSubsequences = new ArrayList<>();

        if(s == null || s.length() <10) return repeadedSubsequences;

        HashMap<String, Integer> seen = new HashMap<>();

        int i =0;

        while(i+10 <=s.length()){
            String subSequence = s.substring(i, i++ +10);
            seen.put(subSequence, seen.getOrDefault(subSequence, 0)+1);
            if(seen.get(subSequence)==2){
                repeadedSubsequences.add(subSequence);
            }
        }
        return repeadedSubsequences;
    }

    public static void main(String arg[]){
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        RepeatedDNASequences r = new RepeatedDNASequences();
        r.findRepeatedDnaSequences(s).forEach(e -> System.out.println(e));
    }
}
