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

    public String frequencySortOptimized(String s){
        if(s.isEmpty() || s.length()==0)
            return s;
        int[] map = new int[128];
        char[] cA = s.toCharArray();

        for(char c:cA)
            map[c]++;

        char[] result = new char[s.length()];
        for(int i=0;i<s.length();){
            int max = 0;
            int index = 0;
            for(int j = 0;j<128;j++){
                if(map[j]>max){
                    max = map[j];
                    index = j;
                }
            }
            while(map[index]>0){
                result[i++] = (char)index;
                map[index]--;
            }
        }
        return new String(result);

    }
    public static void main(String arg[]){

        SortCharactersByFrequency s = new SortCharactersByFrequency();

        System.out.println(s.frequencySort("Aabb"));

    }

}
