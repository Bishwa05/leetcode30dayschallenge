package august.week2;

import java.util.Arrays;

public class HIndex
{
    //counting sort approach
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] counter = new int[len+1];

        for(int c: citations){
            counter[Math.min(len,c)]++;
        }

        int k=len;
        for(int s=counter[len]; k > s; s += counter[k]){
            k--;
        }

        return k;
    }

    public int hIndexSimple(int[] citations) {
        Arrays.sort(citations);

        int result = 0;
        for(int i=citations.length-1; i>=0; i--){
            int cnt = citations.length-i;
            if(citations[i]>=cnt){
                result = cnt;
            }else{
                break;
            }
        }

        return result;
    }

    public static void main(String arg[]){
        int[] citations =  {3,0,6,1,5};

        HIndex h = new HIndex();
        System.out.println(h.hIndexSimple(citations));
    }

}
