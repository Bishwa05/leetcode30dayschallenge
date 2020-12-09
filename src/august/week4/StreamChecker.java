package august.week4;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3434/
 */
public class StreamChecker
{

//

//
//    public StreamChecker(String[] words) {
//        TrieNode root = new TrieNode();
//        for(String word : words){
//            insert(word, root);
//        }
//    }
//
//    public boolean query(char letter) {
//
//    }


    TrieNode t;
    StringBuilder searchedSoFar;

    public StreamChecker(String[] words) {
        t = new TrieNode();

        for (String w : words) {
            StringBuilder s = new StringBuilder(w);
            String str = s.reverse().toString();
            t.insert(str);
        }
        searchedSoFar = new StringBuilder();
    }

    public boolean query(char letter){
        searchedSoFar.append(letter);
        String str = searchedSoFar.toString();
        return t.search(str);
    }
}

class TrieNode{
    public TrieNode[] children;
    boolean isLeaf;
    TrieNode root;

    TrieNode(){
        children = new TrieNode[26];
        isLeaf=false;
    }

        public void insert(String word) {
            if(root == null){
                root = new TrieNode();
            }

            TrieNode curr = root;

            for(char c : word.toCharArray()){
                if(curr.children[c-'a']==null){
                    curr.children[c-'a']= new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isLeaf = true;
        }

    public boolean search(String word){
        TrieNode curr = root;

        if(curr == null){
            return false;
        }
        for(int i=0; i<word.length(); i++){
            int index = word.charAt(i)-'a';
            if(curr.children[index]==null){
                return false;
            }
            curr = curr.children[index];
        }

        return curr.isLeaf?true:false;
    }
}
