package jun21.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TrieNode {
    TrieNode[] children;
    List<Integer> palindromeList;
    int index;

    TrieNode() {
        children = new TrieNode[26];
        palindromeList= null;
        index =-1;
    }
}

class Trie {
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String str, int index){
        TrieNode curr = root;
        int n = str.length();
        int i =0;
        while(i< n){
            if(isPalindrome(str, i, n-1)){
                if(curr.palindromeList == null){
                    curr.palindromeList = new ArrayList<>();
                }
                curr.palindromeList.add(index);
            }
            int ch= str.charAt(i)-'a';
            if(curr.children[ch] == null){
                curr.children[ch] = new TrieNode();
            }
            curr = curr.children[ch];
            i++;
        }
        curr.index = index;
    }

    public void find(String str, int index, List<List<Integer>> result){
        TrieNode curr = root;
        int n = str.length();
        int i = n-1;
        for(;i>=0; i--){
            if(curr.index != -1 && isPalindrome(str, 0, i)){
                result.add(Arrays.asList(curr.index, index));
            }
            int ch = str.charAt(i) -'a';
            if(curr.children[ch] == null){
                return;
            }
            curr = curr.children[ch];
        }

        if(curr.palindromeList != null){
            for(Integer in: curr.palindromeList){
                result.add(Arrays.asList(in, index));
            }
        }
        if(curr.index != -1 && curr.index!=index){
            result.add(Arrays.asList(curr.index, index));
        }
    }

    public boolean isPalindrome(String str, int begin, int end){
        while(begin<end && str.charAt(begin) == str.charAt(end)){
            begin++;
            end --;
        }
        return begin>=end;
    }
}

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

    /**
     *
     * Trie approach
     */

    public List<List<Integer>> palindromePairsTrie(String[] words) {
        Trie trie = new Trie();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            trie.find(words[i], i, result);
        }
        return result;
    }


    public static void main(String arg[]) {
        PalindromePairs p = new PalindromePairs();
        String[] words = {"abcd","dcba","lls","s","sssll"};

        p.palindromePairs(words).forEach( e -> System.out.println(e.get(0)+", "+ e.get(1)));
    }

}
