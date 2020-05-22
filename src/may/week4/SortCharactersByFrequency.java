package may.week4;

import java.util.*;


public class SortCharactersByFrequency {

    private static  List<Map.Entry<Character, Integer>> sortByComparator(Map<Character, Integer> unsortMap) {

        List<Map.Entry<Character, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        return list;
    }

    public String frequencySort(String s) {
        char[] c = s.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();

        for(char x : c){
            if(charMap.containsKey(x)){
                charMap.put(x, charMap.get(x)+1);
            } else {
                charMap.put(x, 1);
            }
        }
        List<Map.Entry<Character, Integer>> sortedEntryList =  sortByComparator(charMap);
        //Arrays.sort(c);

        StringBuffer sb  = new StringBuffer();
        for(Map.Entry<Character, Integer> e: sortedEntryList ){
            int cnt = e.getValue();
            while(cnt>0) {
                sb.append(e.getKey());
                cnt--;
            }
        }

        return sb.toString();
    }

    public static void main(String arg[]){

        SortCharactersByFrequency s = new SortCharactersByFrequency();

        System.out.println(s.frequencySort("Aabb"));

    }

}
