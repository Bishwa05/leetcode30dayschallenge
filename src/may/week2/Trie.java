package may.week2;

public class Trie {
    /** Initialize your data structure here. */
    Trie root;

    static final int ALPHABET_SIZE = 26;
    Trie[] children = new Trie[ALPHABET_SIZE];

    boolean isLeaf;

    public Trie() {
        isLeaf = false;
        for(int i=0; i<ALPHABET_SIZE; i++) {
            children[i] = null;
        }
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(root == null){
            root = new Trie();
        }
        Trie curr = root;

        for(int i=0; i<word.length(); i++){
            int index = word.charAt(i)-'a';
            if(curr.children[index]==null){
                curr.children[index] = new Trie();
            }
            curr = curr.children[index];
        }
        curr.isLeaf = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = root;

        if(curr==null) return false;
        for(int i=0; i<word.length(); i++){
            int index = word.charAt(i)-'a';
            if(curr.children[index]==null){
                return false;
            }
            curr = curr.children[index];
        }

        return curr.isLeaf?true:false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie curr = root;

        if(curr==null) return false;
        for(int i=0; i<prefix.length(); i++){
            int index = prefix.charAt(i)-'a';
            if(curr.children[index]==null){
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }
}
