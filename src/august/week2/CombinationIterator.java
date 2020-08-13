package august.week2;

import java.util.LinkedList;
import java.util.Queue;

/**
Leetcode 1286

Example of dfs
 **/

public class CombinationIterator
{
    Queue<String> q = new LinkedList<>();
    public CombinationIterator(String characters, int combinationLength) {
        StringBuffer sb  = new StringBuffer();
        dfs(characters, 0, combinationLength, sb);
    }

    public void dfs(String chs, int pos, int len, StringBuffer sb)
    {
        if(sb.length() == len)
        {
            q.add(sb.toString());
            return;
        }

        for(int i = pos; i<chs.length(); i++)
        {
            sb.append(chs.charAt(i));
            dfs(chs, i+1, len, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public String next() {
        if(q.size()>0)
            return q.poll();
        return "";
    }

    public boolean hasNext() {
        return q.size()>0;
    }

    public static void main(String arg[]){

        CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

        System.out.println(iterator.next()); // returns "ab"
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next()); // returns "ac"
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next()); // returns "bc"
        System.out.println(iterator.hasNext()); // returns false
    }
}
