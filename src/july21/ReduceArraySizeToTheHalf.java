package july21;

import java.util.*;

public class ReduceArraySizeToTheHalf
{
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();


        for(int x: arr){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());

//        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
//                return e1.getValue().compareTo(e2.getValue());
//            }
//        });

        Collections.sort(list, (m1, m2)-> m2.getValue().compareTo(m1.getValue()));

        int n = arr.length;
        int m =0;
        int count=0;
        while(!list.isEmpty()){
            int val = list.get(0).getValue();
            list.remove(list.get(0));
            m +=val;
            count++;
            if(m>=n/2) break;
        }
        return count;
    }

    public static void main (String[] args)
    {
        ReduceArraySizeToTheHalf r = new ReduceArraySizeToTheHalf();
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        System.out.println(r.minSetSize(arr));
    }
}
