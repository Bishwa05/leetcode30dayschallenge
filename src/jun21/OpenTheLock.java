package jun21;

import java.util.*;

public class OpenTheLock
{
    public int openLock(String[] deadends, String target) {

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        int count =0;

        Set<String> deadEndSet = new HashSet<>();
        deadEndSet.addAll(Arrays.asList(deadends));

        Set<String> visited = new HashSet<>();
        visited.add("0000");

        while(!q.isEmpty()){
            int size = q.size();

            for(int i =0; i<size; i++){
                String val = q.poll();
                if(target.equals(val)) return count;

                if(deadEndSet.contains(val)) continue;

                for(int j =0; j<4; j++){
                    char c = val.charAt(j);
                    char next = (char) ((c=='9')?'0': c+1);
                    char prev = (char) ((c=='0')?'9': c-1);

                    StringBuffer sb = new StringBuffer();
                    sb.append((j!=0)?val.substring(0,j):"");
                    sb.append(next);
                    sb.append((j!=3)?val.substring(j+1):"");

                    if(!visited.contains(sb.toString()) && !deadEndSet.contains(sb.toString())){
                        q.offer(sb.toString());
                        visited.add(sb.toString());
                    }

                    sb = new StringBuffer();
                    sb.append((j!=0)?val.substring(0,j):"");
                    sb.append(prev);
                    sb.append((j!=3)?val.substring(j+1):"");

                    if(!visited.contains(sb.toString()) && !deadEndSet.contains(sb.toString())){
                        q.offer(sb.toString());
                        visited.add(sb.toString());
                    }
                }

            }
            count++;
        }
        return -1;

    }

    public static void main(String arg[]){
        String[] d = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        OpenTheLock o = new OpenTheLock();
        System.out.println(o.openLock(d, target));
    }
}
