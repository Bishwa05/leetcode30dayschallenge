package july.week4;

import java.util.Arrays;

public class TaskScheduler
{

    public int leastInterval(char[] t, int n) {
        int []charMap = new int[26];

        for(char c : t) {
            charMap[c-'A']++;
        }

        Arrays.sort(charMap);

        int maxVal = charMap[25] -1;

        int idleSlot = maxVal *n;

        for(int i =24; i>=0; i--){
            idleSlot -= Math.min(charMap[i], maxVal);
        }

        return idleSlot >0 ?idleSlot +t.length : t.length;
    }

    public static void main(String arg[]){
        TaskScheduler t = new TaskScheduler();
        char[] task = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        System.out.print(t.leastInterval(task, 2));
    }
}
