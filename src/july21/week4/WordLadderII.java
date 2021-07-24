package july21.week4;

import java.util.*;

public class WordLadderII
{
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){

        List<List<String>> res = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return res;
        }

        Map<String, List<String>> mapTree = new HashMap<>();
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();

        begin.add(beginWord);
        end.add(endWord);
        if (buildTree(words, begin, end, mapTree, true)) {
            dfs(res, mapTree, beginWord, endWord, new LinkedList<>());
        }
        return res;
    }


    private boolean buildTree(Set<String> words, Set<String> begin, Set<String> end, Map<String, List<String>> mapTree, boolean isFront) {
        if (begin.size() == 0) return false;

        if (begin.size() > end.size()) {
            return buildTree(words, end, begin, mapTree, !isFront);
        }

        words.removeAll(begin);
        boolean isMeet = false;
        Set<String> nextLevel = new HashSet<>();
        for (String word : begin) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char old = chars[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String str = String.valueOf(chars);
                    if (words.contains(str)) {
                        nextLevel.add(str);
                        String key = isFront ? word : str;
                        String nextWord = isFront ? str : word;
                        if (end.contains(str)) {
                            isMeet = true;
                        }
                        mapTree.putIfAbsent(key, new ArrayList<>());
                        mapTree.get(key).add(nextWord);
                    }
                }
                chars[i] = old;
            }
        }
        if (isMeet) return true;
        return buildTree(words, nextLevel, end, mapTree, isFront);
    }

    private void dfs(List<List<String>> res, Map<String, List<String>> mapTree, String beginWord, String endWord, LinkedList<String> list) {
        list.add(beginWord);
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(list));
            list.removeLast();
            return;
        }
        if (mapTree.containsKey(beginWord)) {
            for (String word : mapTree.get(beginWord)) {
                dfs(res, mapTree, word, endWord, list);
            }
        }
        list.removeLast();
    }
}
