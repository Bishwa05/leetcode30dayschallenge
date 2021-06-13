package jun21.week2;

import java.util.ArrayList;
import java.util.List;

public class PalindromePairs
{
    public boolean isPalindrome(String s){
        int j = s.length()-1;
        int i =0;
        while(i<=j){
            if(s.charAt(i) !=  s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
    public List<List<Integer>> palindromePairs(String[] words) {

        List res = new ArrayList<>();
        for(int i =0; i< words.length; i++) {
            for(int j =0; j< words.length; j++) {
                if(i != j) {
                    String f = words[i] + words[j];
                    if (isPalindrome(f)) {
                        List l = new ArrayList<>();
                        l.add(i);
                        l.add(j);
                        res.add(l);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String arg[]) {
        PalindromePairs p = new PalindromePairs();
        String[] words = {"abcd","dcba","lls","s","sssll"};

        p.palindromePairs(words).forEach( e -> System.out.println(e.get(0)+", "+ e.get(1)));
    }
}
