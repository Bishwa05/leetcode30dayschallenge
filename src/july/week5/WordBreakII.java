package july.week5;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII
{

    public void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
        if(i==0){
            result.add(curr.trim());
            return;
        }

        for(String s: pos[i]){
            String combined = s + " "+ curr;
            dfs(pos, result, combined, i-s.length());
        }
    }


    public List<String> wordBreak(String s, List<String> wordDict){
        ArrayList<String> [] pos = new ArrayList[s.length()+1];
        pos[0]=new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            if(pos[i]!=null){
                for(int j=i+1; j<=s.length(); j++){
                    String sub = s.substring(i,j);
                    if(wordDict.contains(sub)){
                        if(pos[j]==null){
                            ArrayList<String> list = new ArrayList<>();
                            list.add(sub);
                            pos[j]=list;
                        } else {
                            pos[j].add(sub);
                        }

                    }
                }
            }
        }

        if(pos[s.length()]==null){
            return new ArrayList<>();
        }else{
            ArrayList<String> result = new ArrayList<>();
            dfs(pos, result, "", s.length());
            return result;
        }
    }


    public static void main(String arg[]){

        List<String> x = new ArrayList<>();
        x.add("cat");
        x.add("cats");
        x.add("and");
        x.add("sand");
        x.add("dog");
        String s = "catsanddog";
        WordBreakII wb2 = new WordBreakII();

        wb2.wordBreak( s, x).forEach(e -> System.out.println(e));



    }



    public List<String> wordBreak2(String s, List<String> wordDict) {

        TrieNode root = buildTrie(wordDict);
        int[] dp = new int[s.length() + 1];
        List<List<Integer>> words = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) {
            words.add(new ArrayList<>());
        }

        dfs(s, s.length(), words, dp, root);
        List<String> result = new ArrayList<>();
        if (dp[0] == -1) {
            return result;
        }

        printPath(result, words, s, new ArrayList<>(), 0);
        return result;
    }

    private void printPath(List<String> result, List<List<Integer>> words, String s, List<Integer> path, int index) {

        if (index == s.length()) {

            StringBuilder sb = new StringBuilder();
            int left = 0;
            for (int i = 0; i < path.size(); i++) {
                int right = path.get(i);
                for (int j = left; j < right; j++) {
                    sb.append(s.charAt(j));
                }

                if (i != path.size() - 1) {
                    sb.append(" ");
                }
                left = right;
            }

            result.add(sb.toString());
            return;
        }

        for (Integer next : words.get(index)) {
            path.add(next);
            printPath(result, words, s, path, next);
            path.remove(path.size() - 1);
        }

    }

    private int dfs(String s, int index, List<List<Integer>> words, int[] dp, TrieNode root) {

        if (index == 0) {
            dp[0] = 1;
            return 1;
        }

        if (dp[index] != 0) {
            return dp[index];
        }

        dp[index] = -1;
        for (int i = index; i >= 0; i--) {
            if (search(root, s, i, index)) {
                words.get(i).add(index);
                int current = dfs(s, i, words, dp, root);
                if (current == 1) {
                    dp[index] = 1;
                }
            }
        }

        return dp[index];
    }

    static class TrieNode {

        boolean isWord;
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode buildTrie(List<String> wordDict) {

        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            add(root, word);
        }

        return root;
    }

    private void add(TrieNode root, String word) {

        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {

            char cur = word.charAt(i);
            TrieNode next = current.children[cur - 'a'];
            if (next == null) {
                next = new TrieNode();
                current.children[cur - 'a'] = next;
            }
            current = next;
        }

        current.isWord = true;
    }

    private boolean search(TrieNode root, String word, int left, int right) {

        TrieNode current = root;
        for (int i = left; i < right; i++) {

            char cur = word.charAt(i);
            TrieNode next = current.children[cur - 'a'];
            if (next == null) {
                return false;
            }
            current = next;
        }

        return current.isWord;
    }
}
